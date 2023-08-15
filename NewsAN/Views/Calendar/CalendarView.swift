//
//  CalendarView.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct CalendarView: View {
    @State private var selectedDate = Date()
    @State private var navigateToNextPage = false
    
    @StateObject private var viewModel = CalenderViewModel()
    
    
    var body: some View {
        
        NavigationView{
            
            
            ScrollView {
                
                VStack{
                    DatePicker(
                        "Start Date",
                        selection: $selectedDate,
                        in: ...Date(),
                        displayedComponents: [.date]
                    )
                    .datePickerStyle(GraphicalDatePickerStyle())
                    .disabled(isFutureDate(date: selectedDate))
                    .onChange(of: selectedDate, perform: { newDate in
                       
                        
                        let startOfDay = Calendar.current.startOfDay(for: selectedDate)
                       let endOfDay = Calendar.current.date(byAdding: .day, value: 1, to: startOfDay)!
                        
                        print(startOfDay)
                        print(endOfDay)
                        viewModel.fetchEventDateAndQuery(targetDate: startOfDay,endDate: endOfDay)


                    })

                    NavigationLink("", destination: NewsContentView(urlLink: self.viewModel.calendardata.urlLink), isActive: $viewModel.showResults)
                        .opacity(0)
                }
               
                
                
            }
            .navigationTitle("Calendar")
            .navigationBarTitleDisplayMode(.inline)
            .background(Image("Blob 1").offset(x: -180, y: 300))
            .background(Image("Blob 1").offset(x: -150, y: -600))
            
            
        }
        
        
        .navigationViewStyle(.stack)
        
        
    }
    func isFutureDate(date: Date) -> Bool {
        let calendar = Calendar.current
        let currentDate = calendar.startOfDay(for: Date())
        let selectedDate = calendar.startOfDay(for: date)
        return selectedDate > currentDate
    }
}


struct CalendarView_Previews: PreviewProvider {
    static var previews: some View {
        CalendarView()
    }
}

//
//  CalenderController.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI
import Firebase
import FirebaseFirestoreSwift




struct CalendarData {
   
    var urlLink : String
   
}

class CalenderViewModel: ObservableObject {
    @Published var calendardata : CalendarData = CalendarData(urlLink: "")
    @Published var showResults: Bool = false
    
    
    func fetchEventDateAndQuery(targetDate: Date,endDate: Date) {
        
        print(Timestamp(date: targetDate))
        let db = Firestore.firestore()
        
        print("sucess to fetch 1")
        db.collection("news")
            .whereField("publishedAt", isGreaterThanOrEqualTo: targetDate
                           // Timestamp(seconds: 1691865317, nanoseconds: 0)
            )
            .whereField("publishedAt", isLessThan: endDate
                           // Timestamp(seconds: 1691865317, nanoseconds: 0)
            )
            .getDocuments {
                snapshot, error in
                
                print("sucess to fetch 2")
                if let error = error {
                    print("Error fetching documents: \(error)")
                    return
                }
                
                guard let documents = snapshot?.documents else {
                    print("No documents found")
                    return
                }
                
                for document in documents {
                    let data = document.data()
                    let urlLink = data["url"] as? String
                    self.calendardata.urlLink = urlLink!
                    
                    //CalendarData(urlLink: urlLink ?? "")
                    self.showResults = true
                    // Process the data as needed
                    print("sucess to fetch ******")
                    print(data)
                }
            }
    }
    
}


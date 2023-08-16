//
//  ContentView.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI
struct ContentView: View {
    @State private var isActive = false
    @EnvironmentObject var model: Model
    @AppStorage("selectedTab") var selectedTab: Tab = .homePage
    @AppStorage("showAccount") var showAccount = false
    
    init() {
        showAccount = false
    }
    
    
    
    var body: some View {
        NavigationView {
            if isActive {
                
                ZStack {
                    Group {
                        switch selectedTab {
                        case .homePage:
                            CategoryHome()
                           
                        case .calander:
                            CalendarView()
                        case .notifications:
                            NotificationsList()
                          
                            
                        }
                    }
                    .safeAreaInset(edge: .bottom) {
                        VStack {}.frame(height: 44)
                    }
                    
                    TabBar()
                    
                }
                .dynamicTypeSize(.large ... .xxLarge)
                
                
                
            } else {
                SplashView(isActive: $isActive)
            }
        }.dynamicTypeSize(.large ... .xxLarge)
            .navigationViewStyle(.stack)
    }
}




struct HomeView: View {
    var body: some View {
        Text("Welcome to Twitter Clone")
            .font(.title)
            .padding()
    }
}




struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .environmentObject(ModelData())
            .environmentObject(Model())
    }
}

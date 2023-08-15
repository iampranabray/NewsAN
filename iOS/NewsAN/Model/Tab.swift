//
//  Tab.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct TabItem: Identifiable {
    let id = UUID()
    var name: String
    var icon: String
    var color: Color
    var selection: Tab
}

var tabItems = [
    TabItem(name: "News", icon: "newspaper", color: .teal, selection: .homePage),
    TabItem(name: "Calender", icon: "calendar", color: .blue, selection: .calander),
    TabItem(name: "Notifications", icon: "bell", color: .red, selection: .notifications),
   
]

enum Tab: String {
    case homePage
    case calander
    case notifications
    
}

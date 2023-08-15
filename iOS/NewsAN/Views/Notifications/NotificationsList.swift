//
//  NotificationsList.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct NotificationsList: View {
    @EnvironmentObject var modelData: ModelData
    @State private var showFavoritesOnly = false

    var filteredLandmarks: [NotificationsModel] {
        
        modelData.notifications.filter { landmark in
            (!showFavoritesOnly || landmark.isFavorite)
        }
    }

    var body: some View {
        NavigationView {
            List {
                Toggle(isOn: $showFavoritesOnly) {
                    Text("Favorites only")
                }

                ForEach(filteredLandmarks) { landmark in
                    NavigationLink {
                        NotificationsDetail(notifications: landmark)
                    } label: {
                        NotificationsRow(notifications: landmark)
                        
                    }
                    
                }
            }
           
            .navigationTitle("Notifications")
            
           
        }
        .dynamicTypeSize(.large ... .xxLarge)
            .navigationViewStyle(.stack)
    }
}

struct Notifications_Previews: PreviewProvider {
    static var previews: some View {
        NotificationsList()
            .environmentObject(ModelData())
    }
}

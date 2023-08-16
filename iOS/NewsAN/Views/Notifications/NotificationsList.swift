//
//  NotificationsList.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct NotificationsList: View {
    
    @State private var showFavoritesOnly = false
    @StateObject var viewModel = NotificationsViewModel()
    @ObservedObject private var favoriteItemsManager = FavoriteItemsManager.shared
    
    
    var filteredLandmarks: [NotificationsModelFirebase] {
        
        
        viewModel.notificationModel.filter { landmark in
            
            
            //(!showFavoritesOnly || landmark.isFavorite)
            
            
            
            if showFavoritesOnly{
                return (favoriteItemsManager.favoriteItemIDs.contains(landmark.id))
            }else{
                return (favoriteItemsManager.favoriteItemIDs.contains(landmark.id) || !(favoriteItemsManager.favoriteItemIDs.contains(landmark.id)))
            }
            
            
            
        }
    }
    
    var body: some View {
        NavigationView {
            List {
                Toggle(isOn: $showFavoritesOnly) {
                    Text("Favorites only")
                }
                
                ForEach(filteredLandmarks, id: \.id) { notificationRecord in
                    NavigationLink {
                        //NotificationsDetail(notifications: notificationRecord)
                        NewsContentView(urlLink: notificationRecord.urlLink ).navigationTitle("News")
                            .navigationBarTitleDisplayMode(.inline)
                    } label: {
                        NotificationsRow(notifications: notificationRecord)
                        
                    }
                    
                }
            }
            
            .navigationTitle("Notifications")
            
            
        }
        .onAppear{
            self.viewModel.readDataFromFirestore()
        }
        .dynamicTypeSize(.large ... .xxLarge)
        .navigationViewStyle(.stack)
    }
}

struct Notifications_Previews: PreviewProvider {
    static var previews: some View {
        NotificationsList()
        
    }
}

//
//  NotificationsRow.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct NotificationsRow: View {
    var notifications: NotificationsModelFirebase
    
    @ObservedObject private var favoriteItemsManager = FavoriteItemsManager.shared

    var body: some View {
        HStack {
            notifications.image
                .resizable()
                .foregroundColor(Color.accentColor)
                .frame(width: 50, height: 50)
            Text(notifications.title)

            Spacer()
            Image(systemName: favoriteItemsManager.favoriteItemIDs.contains(notifications.id) ? "star.fill" : "star").foregroundColor(.yellow)
                                .onTapGesture {
                                    favoriteItemsManager.toggleFavorite(itemID: notifications.id)
                                }

//            if notifications.isFavorite {
//                Image(systemName: "star.fill")
//                    .foregroundColor(.yellow)
//            }
        }
        
    }
}

//struct NotificationsRow_Previews: PreviewProvider {
//    static var notifications = ModelData().notifications
//
//    static var previews: some View {
//        Group {
//            NotificationsRow(notifications: notifications[0])
//            NotificationsRow(notifications: notifications[1])
//        }
//        .previewLayout(.fixed(width: 300, height: 70))
//    }
//}

//struct NotificationsRow_Previews: PreviewProvider {
//    static var previews: some View {
//        NotificationsRow()
//    }
//}

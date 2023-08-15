//
//  NotificationsDetail.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct NotificationsDetail: View {
    @EnvironmentObject var modelData: ModelData
    var notifications: NotificationsModel

    var landmarkIndex: Int {
        modelData.notifications.firstIndex(where: { $0.id == notifications.id })!
    }

    var body: some View {
        ScrollView {
            MapView(coordinate: notifications.locationCoordinate)
                .ignoresSafeArea(edges: .top)
                .frame(height: 300)

            CircleImage(image: notifications.image)
                .offset(y: -130)
                .padding(.bottom, -130)

            VStack(alignment: .leading) {
                HStack {
                    Text(notifications.name)
                        .font(.title)
                    FavoriteButton(isSet: $modelData.notifications[landmarkIndex].isFavorite)
                }

                HStack {
                    Text(notifications.park)
                    Spacer()
                    Text(notifications.state)
                }
                .font(.subheadline)
                .foregroundColor(.secondary)

                Divider()

                Text("About \(notifications.name)")
                    .font(.title2)
                Text(notifications.description)
            }
            .padding()
        }
        .navigationTitle(notifications.name)
        .navigationBarTitleDisplayMode(.inline)
    }
}

struct NotificationsDetail_Previews: PreviewProvider {
    static let modelData = ModelData()

    static var previews: some View {
        NotificationsDetail(notifications: modelData.notifications[0])
            .environmentObject(modelData)
    }
}

//struct NotificationsDetail_Previews: PreviewProvider {
//    static var previews: some View {
//        NotificationsDetail()
//    }
//}

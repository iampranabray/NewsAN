//
//  LandMark.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import Foundation
import SwiftUI
import Combine
import Firebase
import FirebaseFirestore
import CoreLocation



struct NotificationsModelFirebase:Identifiable, Codable {
    //var id: String
    
    let title: String
    let urlLink : String
    let id: Timestamp
    //var isFeatured: Bool
    var image: Image {
        Image(systemName: "newspaper.circle.fill")
        
    }
    
}

struct NotificationsModel: Hashable, Codable, Identifiable {
    var id: Int
    var name: String
    var park: String
    var state: String
    var description: String
    var isFavorite: Bool
    var isFeatured: Bool

    var category: Category
    enum Category: String, CaseIterable, Codable {
        case lakes = "Latest News"
        case rivers = "Rivers"
        case mountains = "Mountains"
    }

    private var imageName: String
    var image: Image {
        Image(systemName: "newspaper.circle.fill")

    }
    var featureImage: Image? {
        isFeatured ? Image(imageName + "_feature") : nil
    }

    private var coordinates: Coordinates
    var locationCoordinate: CLLocationCoordinate2D {
        CLLocationCoordinate2D(
            latitude: coordinates.latitude,
            longitude: coordinates.longitude)
    }

    struct Coordinates: Hashable, Codable {
        var latitude: Double
        var longitude: Double
    }
}

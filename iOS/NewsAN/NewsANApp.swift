//
//  NewsANApp.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI
import FirebaseFirestore
import Firebase
import FirebaseCore


class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        FirebaseApp.configure()
//        let db = Firestore.firestore()
//        let citiesRef = db.collection("news")
//        //
//        let customTimestamp1 = Timestamp(seconds: 1691865317, nanoseconds: 0)
//        let customTimestamp2 = Timestamp(seconds: 1691778917, nanoseconds: 0)
//        let customTimestamp3 = Timestamp(seconds: 1691692517, nanoseconds: 0)
//        let customTimestamp4 = Timestamp(seconds: 1691606117, nanoseconds: 0)
//        let customTimestamp5 = Timestamp(seconds: 1691519717, nanoseconds: 0)
//        let customTimestamp6 = Timestamp(seconds: 1691433317, nanoseconds: 0)
//        let customTimestamp7 = Timestamp(seconds: 1691346917, nanoseconds: 0)
//        let customTimestamp8 = Timestamp(seconds: 1691260517, nanoseconds: 0)
//        let customTimestamp9 = Timestamp(seconds: 1691174117, nanoseconds: 0)
//        let customTimestamp10 = Timestamp(seconds: 1691087717, nanoseconds: 0)
//        //
//
//
//        citiesRef.document("12-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1001,
//            "url": "https://dt.andaman.gov.in/epaper/128202392125539.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp1
//        ])
//        citiesRef.document("11-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1002,
//            "url": "https://dt.andaman.gov.in/epaper/118202393435848.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp2
//        ])
//        citiesRef.document("10-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1003,
//            "url": "https://dt.andaman.gov.in/epaper/108202392530409.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp3
//        ])
//        citiesRef.document("09-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1004,
//            "url": "https://dt.andaman.gov.in/epaper/98202392253881.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp4
//        ])
//        citiesRef.document("08-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1005,
//            "url": "https://dt.andaman.gov.in/epaper/88202392033945.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp5
//        ])
//        citiesRef.document("07-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1006,
//            "url": "https://dt.andaman.gov.in/epaper/78202391622382.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp6
//        ])
//        citiesRef.document("06-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1007,
//            "url": "https://dt.andaman.gov.in/epaper/682023103753204.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp7
//        ])
//        citiesRef.document("05-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1008,
//            "url": "https://dt.andaman.gov.in/epaper/118202393435848.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp8
//        ])
//        citiesRef.document("04-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1009,
//            "url": "https://dt.andaman.gov.in/epaper/118202393435848.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp9
//        ])
//        citiesRef.document("03-08-2023").setData([
//            "name": "DT",
//            "author": "dt.andaman.gov.in",
//            "id": 1010,
//            "url": "https://dt.andaman.gov.in/epaper/118202393435848.pdf",
//            "urlToImage": "https://c.biztoc.com/p/1ff58033162e4633/s.webp",
//            "publishedAt": customTimestamp10
//        ])
        
        //      citiesRef.document("09-08-2023").setData([
        //        "name": "Turtle Rock",
        //        "category": "Rivers",
        //        "city": "Twentynine Palms",
        //        "state": "California",
        //        "id": 1001,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Joshua Tree National Park",
        //        "description": "Suscipit inceptos est",
        //        "imageName": "turtlerock",
        //        "publishedAt": customTimestamp1
        //          ])
        //      citiesRef.document("09-09-2024").setData([
        //        "name": "Turtle Rock",
        //        "category": "Rivers",
        //        "city": "Twentynine Palms",
        //        "state": "California",
        //        "id": 1001,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Joshua Tree National Park",
        //        "description": "Suscipit inceptos est",
        //        "imageName": "turtlerock",
        //        "publishedAt": customTimestamp2
        //          ])
        //
        //      citiesRef.document("09-02-2020").setData([
        //        "name": "Turtle Rock",
        //        "category": "Rivers",
        //        "city": "Twentynine Palms",
        //        "state": "California",
        //        "id": 1001,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Joshua Tree National Park",
        //        "description": "Suscipit inceptos est",
        //        "imageName": "turtlerock",
        //        "publishedAt": customTimestamp3
        //          ])
        //      citiesRef.document("10-08-2023").setData([
        //        "name": "Turtle Rock",
        //        "category": "Rivers",
        //        "city": "Twentynine Palms",
        //        "state": "California",
        //        "id": 1001,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Joshua Tree National Park",
        //        "description": "Suscipit inceptos est",
        //        "imageName": "turtlerock",
        //        "publishedAt": customTimestamp4
        //          ])
        //
        //      citiesRef.document("SF").setData([
        //        "name": "Turtle Rock",
        //        "category": "Rivers",
        //        "city": "Twentynine Palms",
        //        "state": "California",
        //        "id": 1001,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Joshua Tree National Park",
        //        "description": "Suscipit inceptos est",
        //        "imageName": "turtlerock",
        //        "publishedAt": customTimestamp5
        //          ])
        //      citiesRef.document("LA").setData([
        //        "name": "Today",
        //        "category": "Latest News",
        //        "city": "Port Alsworth",
        //        "state": "Alaska",
        //        "id": 1002,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "Lake Clark National Park and Preserve",
        //
        //        "description": "Suscipit inceptos est",
        //        "imageName": "silversalmoncreek",
        //        "publishedAt": customTimestamp6
        //          ])
        //      citiesRef.document("DC").setData([
        //        "name": "Chilkoot Trail",
        //        "category": "Mountains",
        //        "city": "Skagway",
        //        "state": "Alaska",
        //        "id": 1003,
        //        "isFeatured": false,
        //        "isFavorite": true,
        //        "park": "Klondike Gold Rush National Historical Park",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "chilkoottrail",
        //        "publishedAt": customTimestamp7
        //          ])
        //      citiesRef.document("TOK").setData([
        //        "name": "Yesterday",
        //        "category": "Latest News",
        //        "city": "Browning",
        //        "state": "Montana",
        //        "id": 1004,
        //        "isFeatured": true,
        //        "isFavorite": true,
        //        "park": "Glacier National Park",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "stmarylake",
        //        "publishedAt":customTimestamp8
        //          ])
        //      citiesRef.document("BJ").setData([
        //        "name": "Twin Lake",
        //        "category": "Latest News",
        //        "city": "Twin Lakes",
        //        "state": "Alaska",
        //        "id": 1005,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "Lake Clark National Park and Preserve",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "twinlake",
        //        "publishedAt": customTimestamp9
        //          ])
        //      citiesRef.document("BR").setData([
        //        "name": "Lake McDonald",
        //        "category": "Mountains",
        //        "city": "West Glacier",
        //        "state": "Montana",
        //        "id": 1006,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "Glacier National Park",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "lakemcdonald",
        //        "publishedAt": customTimestamp10
        //          ])
        //      citiesRef.document("PB").setData([
        //        "name": "Charley Rivers",
        //        "category": "Rivers",
        //        "city": "Eaking",
        //        "state": "Alaska",
        //        "id": 1007,
        //        "isFeatured": true,
        //        "isFavorite": false,
        //        "park": "Charley Rivers National Preserve",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "charleyrivers",
        //        "publishedAt": FieldValue.serverTimestamp()
        //          ])
        //
        //      citiesRef.document("HP").setData([
        //        "name": "Rainbow Lake",
        //        "category": "Latest News",
        //        "city": "Willow",
        //        "state": "Alaska",
        //        "id": 1009,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "State Recreation Area",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "rainbowlake",
        //        "publishedAt": FieldValue.serverTimestamp()
        //          ])
        //      citiesRef.document("HP").setData([
        //        "name": "Hidden Lake",
        //        "category": "Latest News",
        //        "city": "Newhalem",
        //        "state": "Washington",
        //        "id": 1010,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "North Cascades National Park",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "hiddenlake",
        //        "publishedAt": FieldValue.serverTimestamp()
        //          ])
        //
        //      citiesRef.document("DXB").setData([
        //        "name": "Chincoteague",
        //        "category": "Rivers",
        //        "city": "Chincoteague",
        //        "state": "Virginia",
        //        "id": 1011,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "Chincoteague National Wildlife Refuge",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "chincoteague",
        //        "publishedAt": FieldValue.serverTimestamp()
        //          ])
        //
        //      citiesRef.document("ABH").setData([
        //        "name": "Lake Umbagog",
        //        "category": "Latest News",
        //        "city": "Errol",
        //        "state": "New Hampshire",
        //        "id": 1012,
        //        "isFeatured": false,
        //        "isFavorite": false,
        //        "park": "Umbagog National Wildlife Refuge",
        //        "description": "Suscipit inceptos est.",
        //        "imageName": "umbagog",
        //        "publishedAt": FieldValue.serverTimestamp()
        //          ])
        //
        return true
    }
}


@main
struct NewsANApp: App {
    @StateObject private var modelData = ModelData()
    @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(modelData)
                .environmentObject(Model())
        }
        
    }
}

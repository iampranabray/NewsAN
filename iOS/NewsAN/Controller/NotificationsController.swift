//
//  NotificationsController.swift
//  NewsAN
//
//  Created by Pranab Ray on 15/08/23.
//

import Firebase
import FirebaseFirestore
import Combine
import SwiftUI



class NotificationsViewModel: ObservableObject {
    
    @Published var notificationModel: [NotificationsModelFirebase] = []
    
    
    func readDataFromFirestore() {
        let db = Firestore.firestore()
        
        db.collection("notifications")
            .order(by: "publishedAt", descending: true)
            .getDocuments { (querySnapshot, error) in
                if let error = error {
                    print("Error getting documents: \(error)")
                } else {
                    guard let documents = querySnapshot?.documents else {
                        print("No documents found.")
                        return
                    }
                    
                    var notificationModel = [NotificationsModelFirebase]()
                    for document in documents {
                        let data = document.data()
                        
                        
                        if let urlLink = data["url"] as? String,
                           let title = data["title"] as? String,
                           let timestamp = data["publishedAt"] as? Timestamp {
                            
                            notificationModel.append( NotificationsModelFirebase(title: title,urlLink: urlLink, id: timestamp))
                        }
                        
                        
                    }
                    self.notificationModel = notificationModel
                    print(notificationModel)
                    
                    
                    
                }
            }
    }
    
}

class FavoriteItemsManager: ObservableObject {
    static let shared = FavoriteItemsManager()
    private let userDefaults = UserDefaults.standard
    
    @Published var favoriteItemIDs: Set<Timestamp> {
        didSet {
            saveFavorites()
        }
    }
    
    private init() {
        if let data = userDefaults.data(forKey: "favoriteItemIDs"),
           let favoriteItemIDs = try? JSONDecoder().decode(Set<Timestamp>.self, from: data) {
            self.favoriteItemIDs = favoriteItemIDs
        } else {
            self.favoriteItemIDs = []
        }
    }
    
    private func saveFavorites() {
        if let data = try? JSONEncoder().encode(favoriteItemIDs) {
            userDefaults.setValue(data, forKey: "favoriteItemIDs")
        }
    }
    
    func toggleFavorite(itemID: Timestamp) {
        if favoriteItemIDs.contains(itemID) {
            favoriteItemIDs.remove(itemID)
        } else {
            favoriteItemIDs.insert(itemID)
        }
    }
}

//class FavoriteItemsManager {
//    static let shared = FavoriteItemsManager()
//    private let userDefaults = UserDefaults.standard
//
//    private init() {}
//
//    var favoriteItemIDs: Set<Timestamp> {
//        get {
//            if let data = userDefaults.data(forKey: "favoriteItemIDs"),
//               let favoriteItemIDs = try? JSONDecoder().decode(Set<Timestamp>.self, from: data) {
//                return favoriteItemIDs
//            }
//            return []
//        }
//        set {
//            if let data = try? JSONEncoder().encode(newValue) {
//                userDefaults.setValue(data, forKey: "favoriteItemIDs")
//            }
//        }
//    }
//
//    func toggleFavorite(itemID: Timestamp) {
//        if favoriteItemIDs.contains(itemID) {
//            favoriteItemIDs.remove(itemID)
//        } else {
//            favoriteItemIDs.insert(itemID)
//        }
//    }
//}

//class ViewModel: ObservableObject {
//    @Published var items: [NotificationsModelFirebase] = []
//
//    // @AppStorage for favorite item IDs
//    @AppStorage("favoriteItemIDs") var favoriteItemIDs: Set<String> = []
//
//    init() {
//        fetchItemsFromFirebase()
//    }
//
//    func fetchItemsFromFirebase() {
//
//        fetchItems { fetchedItems in
//            DispatchQueue.main.async {
//                self.items = fetchedItems
//            }
//        }
//    }
//
//    func toggleFavorite(item: NotificationsModelFirebase) {
//        if favoriteItemIDs.contains("") {
//            favoriteItemIDs.remove("")
//        } else {
//            favoriteItemIDs.insert("")
//        }
//    }
//    func fetchItems(completion: @escaping ([NotificationsModelFirebase]) -> Void) {
//        let db = Firestore.firestore()
//        db.collection("notifications").getDocuments { snapshot, error in
//            guard let documents = snapshot?.documents else {
//                print("Error fetching documents: \(String(describing: error))")
//                return
//            }
//
//            let items = documents.compactMap { document -> NotificationsModelFirebase? in
//                let data = document.data()
//                do{
//                    let jsonData = try JSONSerialization.data(withJSONObject: data)
//                    let item = try JSONDecoder().decode(NotificationsModelFirebase.self, from: jsonData)
//                    return item
//                }catch{
//                    print("Error decoding item: \(error)")
//                                    return nil
//                }
//
//                // return try? FirebaseDecoder().decode(NotificationsModelFirebase.self, from: data)
//            }
//
//            completion(items)
//        }
//    }
//}

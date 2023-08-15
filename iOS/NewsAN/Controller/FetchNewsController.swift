//
//  FetchNewsController.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import Firebase
import FirebaseFirestore
import Combine

struct Record {
    let title: String
    let urlLink : String
    //let description: String
    let timestamp: Timestamp
}

class FirestoreViewModel: ObservableObject {
    
    @Published var records: [Record] = []
    
    
    func readDataFromFirestore() {
        let db = Firestore.firestore()
        
        db.collection("news")
            .order(by: "publishedAt", descending: true)
            .getDocuments { (querySnapshot, error) in
                if let error = error {
                    print("Error getting documents: \(error)")
                } else {
                    guard let documents = querySnapshot?.documents else {
                        print("No documents found.")
                        return
                    }
                    
                    var records = [Record]()
                    for document in documents {
                        let data = document.data()
                        
                        
                        if let urlLink = data["url"] as? String,
                            
                            let timestamp = data["publishedAt"] as? Timestamp {
                            
                            let title = self.formatDate(from: timestamp.dateValue())
                            records.append(Record(title: title,urlLink: urlLink, timestamp: timestamp))
                        }
                        
                        
                    }
                    self.records = records
                    print(records)
                    
                    
                    
                }
            }
    }
    
    private func formatDate(from date: Date) -> String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "MMM d, yyyy"
        return dateFormatter.string(from: date)
    }
}

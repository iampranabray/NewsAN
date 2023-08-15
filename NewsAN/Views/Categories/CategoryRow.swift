//
//  CategoryRow.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI

struct CategoryRow: View {
    var categoryName: String
    var items: [NotificationsModel]
    @StateObject var viewModel = FirestoreViewModel()
    @Namespace var namespace
    
    init(categoryName: String, items: [NotificationsModel]) {
        
        self.categoryName = categoryName
        self.items = items
        
        
    }
    let columns: [GridItem] =
    //[GridItem(.adaptive(minimum: 300), spacing: 20)]
    Array(repeating: .init(.flexible()), count: 2) // Number of columns
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(categoryName)
                .font(.headline)
                .padding(.leading, 15)
                .padding(.top, 5)
            
            
            
            ScrollView {
                LazyVGrid(columns: columns, spacing: 16) {
                    ForEach(viewModel.records, id: \.timestamp) { records in
                        
                        NavigationLink{
                            
                            NewsContentView(urlLink: records.urlLink ).navigationTitle("News")
                                .navigationBarTitleDisplayMode(.inline)
                        }label: {
                            CategoryItem(namespace: namespace, record: records).frame(height: 200)
                            // CategoryItem(record: records)
                        }
                        
                        
                        
                        
                    }
                }
                .padding()
            }
            
            
        }
        .onAppear {
            viewModel.readDataFromFirestore() // Fetch data when the view appears
        }
    }
}

struct CategoryRow_Previews: PreviewProvider {
    static var landmarks = ModelData().notifications
    
    static var previews: some View {
        CategoryRow(
            categoryName: landmarks[0].category.rawValue,
            items: Array(landmarks.prefix(4))
        )
    }
}


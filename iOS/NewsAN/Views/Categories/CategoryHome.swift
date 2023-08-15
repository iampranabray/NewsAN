//
//  CategoryHome.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI

struct CategoryHome: View {
    
    
    var body: some View {
        
        HomePgeView()
        
    }
}

struct HomePgeView: View {
    @EnvironmentObject var modelData: ModelData
    @State private var showingProfile = false
    
    var body: some View {
        
        ZStack {
            Color("Background").ignoresSafeArea()
            
            NavigationView {
                
                ScrollView {
                    PageView(pages: modelData.features.map { FeatureCard(landmark: $0) })
                        .aspectRatio(3 / 2, contentMode: .fit)
                        .listRowInsets(EdgeInsets()).padding()
                    
                    CategoryRow(categoryName: "Latest News" , items: modelData.categories["Latest News"]!)
                        .listRowInsets(EdgeInsets())
                }
                
                
                .background(Image("Blob 1").offset(x: -180, y: 300))
                .background(Image("Blob 1").offset(x: -250, y: -500))
                .navigationBarTitle("News")
                .toolbar {
                    Button {
                        showingProfile.toggle()
                    } label: {
                        Label("User Profile", systemImage: "person.crop.circle")
                    }
                }
                .sheet(isPresented: $showingProfile) {
                    ProfileHost()
                        .environmentObject(modelData)
                }
                
                
            }
            .dynamicTypeSize(.large ... .xxLarge)
            .navigationViewStyle(.stack)
            
            
        } 
        
        
    }
    
    
}

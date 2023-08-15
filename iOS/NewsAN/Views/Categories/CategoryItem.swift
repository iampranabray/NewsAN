//
//  CategoryItem.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI

struct CategoryItem: View {
    var namespace: Namespace.ID
    var record: Record
    
    @EnvironmentObject var model: Model
    @Environment(\.horizontalSizeClass) var horizontalSizeClass
    
    var body: some View {
        VStack {
//            LogoView(image: course.logo)
//                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .topLeading)
//                .padding(20)
//                .matchedGeometryEffect(id: "logo\(course.index)", in: namespace)
            
            Spacer()
            
            VStack(alignment: .leading, spacing: 8) {
                Text(record.title)
                    .font(.title3).bold()
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .matchedGeometryEffect(id: "title\(record.timestamp)", in: namespace)
                    .foregroundColor(.white)
                
               
            }
            .padding(15)

        }
        .background(
            Image(systemName: "newspaper.fill")
                
                .resizable()
                .aspectRatio(contentMode: .fit)
                .foregroundColor(.white)
                .padding(60)
               
                .matchedGeometryEffect(id: "image\(record.timestamp)", in: namespace)

        )
        .background(
            Image("Background \(generateRandomNumberExcludingFourAndFive())")
                .resizable()
                .aspectRatio(contentMode: .fill)
                .disabled(true)
                .blur(radius: 25)
                .matchedGeometryEffect(id: "background\(record.timestamp)", in: namespace)
        )
        .mask(
            RoundedRectangle(cornerRadius: 30)
                .matchedGeometryEffect(id: "mask\(record.timestamp)", in: namespace)
        )
       
    }
}

func generateRandomNumberExcludingFourAndFive() -> Int {
    var randomNumber: Int
    repeat {
        randomNumber = Int.random(in: 1...10)
    } while randomNumber == 3 || randomNumber == 2 || randomNumber == 6 || randomNumber == 7 || randomNumber == 10
    return randomNumber
}

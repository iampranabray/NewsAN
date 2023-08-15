//
//  NewsContentView.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI

struct NewsContentView: View {
    @State private var isLoading = false
    @State private var isDownloaded: Bool = false
    var urlLink : String

    var body: some View {
        VStack {
            // PDF Viewer
            if isLoading {
                ProgressView("Loading...")
                
            } else {
                PDFViewerView(isLoading: $isLoading,urlLink: urlLink)
            }
        }
        .onAppear {
            isLoading = true
        }
    }
}

struct NewsContentView_Previews: PreviewProvider {
    static var previews: some View {
        NewsContentView(urlLink: "https://dt.andaman.gov.in/epaper/98202392253881.pdf")
    }
}

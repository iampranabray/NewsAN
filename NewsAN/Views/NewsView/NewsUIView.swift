//
//  NewsUIView.swift
//  NewsAN
//
//  Created by Pranab Ray on 14/08/23.
//

import SwiftUI
import UIKit
import PDFKit
import PencilKit
import WebKit


struct PDFViewerView: View {
    @Binding var isLoading: Bool
    var urlLink : String

    var body: some View {
        PDFKitView(url: URL(string: urlLink ), isLoading: $isLoading)
            .onAppear {
                // Simulate PDF loading delay
                DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                    isLoading = false
                }
            }
    }
}

struct PDFKitView: UIViewRepresentable {
    var url: URL?
    @Binding var isLoading: Bool

    func makeUIView(context: Context) -> PDFView {
        let pdfView = PDFView()
        pdfView.autoScales = true
        pdfView.autoScales = true
        pdfView.displaysAsBook = true
        pdfView.displayMode = .singlePageContinuous
        return pdfView
    }

    func updateUIView(_ uiView: PDFView, context: Context) {
        guard let url = url else { return }

        if isLoading {
            uiView.document = nil
        } else {
            isLoading = true
            DispatchQueue.global().async {
                if let document = PDFDocument(url: url) {
                    DispatchQueue.main.async {
                        uiView.document = document
                        isLoading = false
                    }
                }
            }
        }
    }
}

func isPDFDownloaded() -> Bool {
    let fileURL = FileManager.default
        .urls(for: .documentDirectory, in: .userDomainMask)
        .first?
        .appendingPathComponent("yourFilename.pdf")
    
    return FileManager.default.fileExists(atPath: fileURL?.path ?? "")
}

func downloadPDF(from url: URL, completion: @escaping (URL?, Error?) -> Void) {
    URLSession.shared.dataTask(with: url) { data, response, error in
        if let error = error {
            completion(nil, error)
            return
        }
        
        guard let data = data else {
            completion(nil, NSError(domain: "YourAppErrorDomain", code: 0, userInfo: nil))
            return
        }
        
        do {
            let fileURL = try FileManager.default
                .url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false)
                .appendingPathComponent("yourFilename.pdf")
            
            try data.write(to: fileURL)
            completion(fileURL, nil)
        } catch {
            completion(nil, error)
        }
    }.resume()
}

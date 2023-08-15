//
//  SplashView.swift
//  NewsAN
//
//  Created by Pranab Ray on 13/08/23.
//

import SwiftUI

struct SplashView: View {
    @Binding var isActive: Bool
    @State private var scale: CGFloat = 1.0
    @State private var yOffset: CGFloat = 0.0
    
    var body: some View {
        ZStack {
            //Color.accentColor.edgesIgnoringSafeArea(.all)
            LinearGradient(
                stops: [
                    Gradient.Stop(color: Color(red: 0.25, green: 0.1, blue: 0.75), location: 0.00),
                    Gradient.Stop(color: Color.accentColor, location: 1.00),
                ],
                startPoint: UnitPoint(x: 0.5, y: 0),
                endPoint: UnitPoint(x: 0, y: 0.98)
            ).edgesIgnoringSafeArea(.all)
            
            Image(systemName: "newspaper.circle")
                .font(.system(size: 100))
                .foregroundColor(.white)
                .scaleEffect(scale)
                .offset(y: yOffset)
            
        }
        
        .onAppear {
            animateJump()
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
                withAnimation(.spring()) {
                    scale = 2.0
                }
            }
            DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
                withAnimation {
                    isActive = true
                }
            }
        }
        
    }
    private func animateJump() {
        withAnimation(Animation.easeInOut(duration: 0.5).repeatForever(autoreverses: true)) {
            yOffset = -30 // Adjust this value for the jump height
        }
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
            isActive = true
        }
    }
}

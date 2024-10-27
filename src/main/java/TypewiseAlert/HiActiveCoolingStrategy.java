package com.boschremoteassist.tpaconnect.mobile.adapter;

public class HiActiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Infer breach
        System.out.println("High active cooling: Breach detected! Sending high message.");
        // Code to send high message
    }
}

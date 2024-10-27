package com.boschremoteassist.tpaconnect.mobile.adapter;

public class PassiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Classify as low risk
        System.out.println("Passive cooling: Low risk. Sending low message.");
        // Code to send low message
    }
}

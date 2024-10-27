package com.boschremoteassist.tpaconnect.mobile.adapter;

public class CoolingController {
    public void processCooling(String coolingType) {
        CoolingContext context = new CoolingContext();

        switch (coolingType) {
            case "Passive":
                context.setStrategy(new PassiveCoolingStrategy());
                break;
            case "Med_active":
                context.setStrategy(new MedActiveCoolingStrategy());
                break;
            case "hi_active":
                context.setStrategy(new HiActiveCoolingStrategy());
                break;
            default:
                throw new IllegalArgumentException("Invalid cooling type");
        }

        context.executeStrategy();
    }
}

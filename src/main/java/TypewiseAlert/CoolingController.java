package com.boschremoteassist.tpaconnect.mobile.adapter;

public class CoolingController {
    public void processCooling(String coolingType) {
        CoolingContext context = new CoolingContext();

        if(cooling == "Passive") {
		context.setStrategy(new PassiveCoolingStrategy());
	} else if(cooling == "Med_active") {
		context.setStrategy(new MedActiveCoolingStrategy());
	} else if(cooling == "hi_active") {
		context.setStrategy(new HiActiveCoolingStrategy());
	}

        context.executeStrategy();
    }
}

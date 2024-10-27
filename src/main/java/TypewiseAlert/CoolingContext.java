package com.TypewiseAlert;

public class CoolingContext {
    private CoolingStrategy strategy;

    public void setStrategy(CoolingStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.handleCooling();
        } else {
            throw new IllegalStateException("Strategy not set");
        }
    }
}

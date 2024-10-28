class HiActiveCoolingStrategyTest implements CoolingStrategy {
    private boolean handled = false;

    @Override
    public void handleCooling() {
        handled = true;
    }

    public boolean isHandled() {
        return handled;
    }

    public void reset() {
        handled = false;
    }
}
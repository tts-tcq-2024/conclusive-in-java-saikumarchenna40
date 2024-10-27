package TypewiseAlert;

public class MedActiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Classify and send a high/medium message
        System.out.println("Medium active cooling: Potential breach. Sending high message.");
        // Code to send high message
    }
}

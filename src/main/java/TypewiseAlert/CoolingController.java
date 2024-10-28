import java.util.HashMap;
import java.util.Map;

interface CoolingStrategy {
    void handleCooling();
}
 class PassiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Classify as low risk
        System.out.println("Passive cooling: Low risk. Sending low message.");
        // Code to send low message
    }
}
 class MedActiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Classify and send a high/medium message
        System.out.println("Medium active cooling: Potential breach. Sending high message.");
        // Code to send high message
    }
}
 
class HiActiveCoolingStrategy implements CoolingStrategy {
    @Override
    public void handleCooling() {
        // Infer breach
        System.out.println("High active cooling: Breach detected! Sending high message.");
        // Code to send high message
    }
}

public class CoolingController {
    private final Map<String, CoolingStrategy> strategyMap;

    public CoolingController() {
        strategyMap = new HashMap<>();
        strategyMap.put("Passive", new PassiveCoolingStrategy());
        strategyMap.put("Med_active", new MedActiveCoolingStrategy());
        strategyMap.put("hi_active", new HiActiveCoolingStrategy());
    }

    public void processCooling(String coolingType) {
        CoolingContext context = new CoolingContext();
        CoolingStrategy strategy = strategyMap.get(coolingType);
        
        if (strategy != null) {
            context.setStrategy(strategy);
            context.executeStrategy();
        } else {
            // Handle invalid cooling type if necessary
        }
    }
}

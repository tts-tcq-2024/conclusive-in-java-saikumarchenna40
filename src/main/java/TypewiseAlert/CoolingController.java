import java.util.HashMap;
import java.util.Map;
import com.typewisealert.PassiveCoolingStrategy;
import com.typewisealert.CoolingStrategy;
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

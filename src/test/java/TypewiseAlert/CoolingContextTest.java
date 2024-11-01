
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

class MockCoolingStrategy implements CoolingStrategy {
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


 
public class CoolingContextTest {
 
    private CoolingContext coolingContext;
    private CoolingStrategy mockStrategy; 
 
    @Before
    public void setUp() {
        coolingContext = new CoolingContext();
        mockStrategy = new CoolingStrategy() {
            @Override
            public void handleCooling() {
                System.out.println("Mock strategy handling cooling.");
            }
        };
    }
 
    @Test
    public void testExecuteStrategyWithStrategySet() {
        coolingContext.setStrategy(mockStrategy);
        coolingContext.executeStrategy();
    }
 
}

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

// Mock implementation of the CoolingStrategy interface for testing
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
    private CoolingStrategy mockStrategy; // A mock or dummy strategy
 
    @Before
    public void setUp() {
        coolingContext = new CoolingContext();
        mockStrategy = new CoolingStrategy() {
            @Override
            public void handleCooling() {
                // Mock behavior for testing
                System.out.println("Mock strategy handling cooling.");
            }
        };
    }
 
    @Test
    public void testExecuteStrategyWithStrategySet() {
        coolingContext.setStrategy(mockStrategy);
        coolingContext.executeStrategy(); // Should execute without exception
        // You may want to verify the output, but for simplicity, we focus on no exceptions here.
    }
 
    @Test
    public void testExecuteStrategyWithoutSettingStrategy() {
        try {
            coolingContext.executeStrategy();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Exception was thrown as expected
        }
    }
}

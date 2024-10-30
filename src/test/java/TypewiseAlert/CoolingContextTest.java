//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

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
    private CoolingContext context;
    private MockCoolingStrategy mockStrategy;

    @Before
    public void setUp() {
        context = new CoolingContext();
        mockStrategy = new MockCoolingStrategy();
    }

   // @Test
    //public void testExecuteStrategyWithoutSetting() {
      //IllegalStateException exception = assertThrows(IllegalStateException.class, new Executable() {
    //@Override
    //public void execute() {
      //  context.executeStrategy();
    //}
//});
  //      assertEquals("Strategy not set", exception.getMessage());
    //}

    @Test
    public void testExecuteStrategyWithValidStrategy() {
        context.setStrategy(mockStrategy);
        context.executeStrategy();
        assertTrue(mockStrategy.isHandled(), "The strategy should have been executed.");
    }

    @Test
    public void testSettingNewStrategy() {
        CoolingStrategy anotherStrategy = new MockCoolingStrategy();
        context.setStrategy(mockStrategy);
        context.executeStrategy();
        assertTrue(mockStrategy.isHandled(), "The first strategy should have been executed.");
        
        mockStrategy.reset(); // Reset for the next test
        context.setStrategy(anotherStrategy);
        context.executeStrategy();
        assertTrue(((MockCoolingStrategy) anotherStrategy).isHandled(), "The second strategy should have been executed.");
    }
}

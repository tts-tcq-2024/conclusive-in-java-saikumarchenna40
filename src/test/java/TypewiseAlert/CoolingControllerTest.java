import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoolingControllerTest {
    private CoolingController controller;
    private PassiveCoolingStrategy passiveStrategy;
    private MedActiveCoolingStrategy medActiveStrategy;
    private HiActiveCoolingStrategy hiActiveStrategy;

    @BeforeEach
    public void setUp() {
        controller = new CoolingController();
        passiveStrategy = new PassiveCoolingStrategyTest();
        medActiveStrategy = new MedActiveCoolingStrategyTest();
        hiActiveStrategy = new HiActiveCoolingStrategyTest();
    }

    @Test
    public void testProcessCoolingWithPassiveStrategy() {
        controller.processCooling("Passive");
        assertTrue(passiveStrategy.isHandled(), "Passive strategy should be executed.");
    }

    @Test
    public void testProcessCoolingWithMedActiveStrategy() {
        controller.processCooling("Med_active");
        assertTrue(medActiveStrategy.isHandled(), "Med_active strategy should be executed.");
    }

    @Test
    public void testProcessCoolingWithHiActiveStrategy() {
        controller.processCooling("hi_active");
        assertTrue(hiActiveStrategy.isHandled(), "Hi_active strategy should be executed.");
    }

    @Test
    public void testProcessCoolingWithInvalidStrategy() {
        controller.processCooling("InvalidType");
        // No assertion needed as we don't have a direct output, 
        // but we could verify the state of the controller or logs if needed.
        // Here we just assert that no exception is thrown.
        assertDoesNotThrow(controller.processCooling("InvalidType"));
    }
}

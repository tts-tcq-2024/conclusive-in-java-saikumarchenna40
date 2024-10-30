//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CoolingControllerTest {

    private CoolingController coolingController;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    
    @Before
    public void setUp() {
        coolingController = new CoolingController();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testProcessPassiveCooling() {
        coolingController.processCooling("Passive");
        String expectedOutput = "Passive cooling: Low risk. Sending low message.";
        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput);
    }

    @Test
    public void testProcessMedActiveCooling() {
        coolingController.processCooling("Med_active");
        String expectedOutput = "Medium active cooling: Potential breach. Sending high message.";
        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput);
    }

    @Test
    public void testProcessHiActiveCooling() {
        coolingController.processCooling("hi_active");
        String expectedOutput = "High active cooling: Breach detected! Sending high message.";
        assertTrue(outputStreamCaptor.toString().trim().contains(expectedOutput);
    }

    @Test
    public void testProcessInvalidCoolingType() {
        assertThrows(IllegalStateException.class, () -> {
            coolingController.processCooling("Invalid");
        });
    }

    @Test
    public void testProcessCoolingWithoutSettingStrategy() {
        CoolingContext context = new CoolingContext();
        assertThrows(IllegalStateException.class, context::executeStrategy);
    }
}

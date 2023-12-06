import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ColorTableTest {
    @Test
    public void testConstructorValidNumberOfColors() {
        // Test valid number of colors
        int validNumColors = 4;
        ColourTable colourTable = new ColourTable(validNumColors);
        assertEquals(validNumColors, colourTable.getNumberOfColors());
    }
}
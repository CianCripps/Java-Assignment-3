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

    @Test
    public void testConstructorInvalidNumberOfColors() {
        // Test invalid number of colors (not a power of two)
        int invalidNumColors = 7;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(invalidNumColors));

        // Test invalid number of colors (greater than 1024)
        int largeNumColors = 2048;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(largeNumColors));

        // Test invalid number of colors (less than 2)
        int smallNumColors = 1;
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(smallNumColors));
    }
}
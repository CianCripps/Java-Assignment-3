import java.util.Arrays;
public class ColourTable {
    private final int[] colorLookupTable;

    public ColourTable(int numColors) {
        // Creating a ColourTable object without specifying a valid palette size throws an exception
        if (!isValidNumberOfColors(numColors)) {
            throw new IllegalArgumentException("Number of colors must be a power of two and greater than 1, and less than 1025.");
        }
        this.colorLookupTable = new int[numColors];
        initializeColorTable();
    }

    private boolean isValidNumberOfColors(int numColors) {
        return numColors > 1 && numColors < 1025 && (numColors & (numColors - 1)) == 0;
    }

    private void initializeColorTable() {
        // Setting default color to black
        Arrays.fill(colorLookupTable, 0xFF000000);
    }

    // Method to set color at a specific index in the table
    public void setColorAtIndex(int index, int rgbValue) {
        if (index >= 0 && index < colorLookupTable.length) {
            colorLookupTable[index] = rgbValue;
        } else {
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }

    // Method to get color at a specific index in the table
    public int getColorAtIndex(int index) {
        if (index >= 0 && index < colorLookupTable.length) {
            return colorLookupTable[index];
        } else {
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }

    // Method to get the number of colors in the table
    public int getNumberOfColors() {
        return colorLookupTable.length;
    }

    public static void main(String[] args) {
        int numColors = 4; // RGB (3 colors and 1 for input)
        ColourTable colorTable = new ColourTable(numColors);

        // Set and get RGB colors at their indexes

        // Red at index 0
        colorTable.setColorAtIndex(0, 0xFF0000);
        // Green at index 1
        colorTable.setColorAtIndex(1, 0x00FF00);
        // Blue at index 2
        colorTable.setColorAtIndex(2, 0x0000FF);

        // Get color at index 0
        int colorAtIndex0 = colorTable.getColorAtIndex(0);
        // Get color at index 1
        int colorAtIndex1 = colorTable.getColorAtIndex(1);
        // Get color at index 2
        int colorAtIndex2 = colorTable.getColorAtIndex(2);

        System.out.println("Color at index 1: #" + Integer.toHexString(colorAtIndex0));
        System.out.println("Color at index 1: #" + Integer.toHexString(colorAtIndex1));
        System.out.println("Color at index 1: #" + Integer.toHexString(colorAtIndex2));
    }
}

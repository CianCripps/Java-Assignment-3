import java.util.Arrays;
/**
 * Represents a palette of RGB colors using a lookup table.
 */
public class ColourTable {
    private final int[] colorLookupTable;

    /**
     * Constructs a ColourTable object with a specified number of colors in the palette.
     *
     * @param numColors The number of colors in the palette (must be a power of two, greater than 1, and less than 1025)
     * @throws IllegalArgumentException If the provided palette size is invalid
     */
    public ColourTable(int numColors) {
        // Creating a ColourTable object without specifying a valid palette size throws an exception
        if (!isValidNumberOfColors(numColors)) {
            throw new IllegalArgumentException("Number of colors must be a power of two and greater than 1, and less than 1025.");
        }
        this.colorLookupTable = new int[numColors];
        initializeColorTable();
    }

    /**
     * Checks if the number of colors is valid.
     *
     * @param numColors The number of colors to validate.
     * @return True if the number of colors is greater than 1, less than 1025,
     *         and is a power of 2, else false.
     */
    private boolean isValidNumberOfColors(int numColors) {
        return numColors > 1 && numColors < 1025 && (numColors & (numColors - 1)) == 0;
    }

    /**
     * Initializes the color table with default color.
     */
    private void initializeColorTable() {
        // Setting default color to black
        Arrays.fill(colorLookupTable, 0xFF000000);
    }

    // Method to set color at a specific index in the table
    /**
     * Sets the color at a specific index in the table.
     *
     * @param index    The index in the table.
     * @param rgbValue The RGB color value to set.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public void setColorAtIndex(int index, int rgbValue) {
        if (index >= 0 && index < colorLookupTable.length) {
            colorLookupTable[index] = rgbValue;
        } else {
            // Exceeding the capacity of the ColourTable results in an exception
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }

    // Method to add a 24-bit RGB color to the table
    /**
     * Adds a 24-bit RGB color to the table.
     *
     * @param rgbValue The RGB color value to add.
     */
    public void add(int rgbValue) {
        boolean added = false;
        for (int i = 0; i < colorLookupTable.length; i++) {
            if (colorLookupTable[i] == 0xFF000000) { // If the slot is empty (black), add the color
                colorLookupTable[i] = rgbValue;
                added = true;
                break;
            }
        }
    }

    // Method to get color at a specific index in the table
    /**
     * Gets the color at a specific index in the table.
     *
     * @param index The index in the table.
     * @return The RGB color value at the specified index.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public int getColorAtIndex(int index) {
        if (index >= 0 && index < colorLookupTable.length) {
            return colorLookupTable[index];
        } else {
            throw new IllegalArgumentException("Index out of bounds.");
        }
    }

    // Method to get the number of colors in the table
    /**
     * Gets the number of colors in the table.
     *
     * @return The number of colors in the table.
     */
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

        // For use of developer to see their added color

        // Get color at index 0
        int colorAtIndex0 = colorTable.getColorAtIndex(0);
        // Get color at index 1
        int colorAtIndex1 = colorTable.getColorAtIndex(1);
        // Get color at index 2
        int colorAtIndex2 = colorTable.getColorAtIndex(2);

        System.out.println("Color at index 0: #" + Integer.toHexString(colorAtIndex0));
        System.out.println("Color at index 1: #" + Integer.toHexString(colorAtIndex1));
        System.out.println("Color at index 2: #" + Integer.toHexString(colorAtIndex2));
    }
}

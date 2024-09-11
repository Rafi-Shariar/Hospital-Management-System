import javax.swing.*;
import java.awt.*;

public class FontLister extends JFrame {

    public FontLister() {
        setTitle("Available Fonts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Center the window

        // Retrieve all available font family names
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        // Create a JList to display font names
        JList<String> fontList = new JList<>(fontNames);
        fontList.setCellRenderer(new FontCellRenderer());

        // Add the list to a scroll pane
        JScrollPane scrollPane = new JScrollPane(fontList);
        add(scrollPane);

        // Print font creation statements to the console
        printFontStatements(fontNames);

        setVisible(true);
    }

    /**
     * Prints font creation statements to the console in the format:
     * print Arial = new Font("Arial", Font.PLAIN, 12);
     *
     * @param fontNames Array of font family names
     */
    private void printFontStatements(String[] fontNames) {
        for (String fontName : fontNames) {
            // Replace spaces with underscores for variable naming (if needed)
            String variableName = fontName.replaceAll("\\s+", "");
            System.out.println("print " + variableName + " = new Font(\"" + fontName + "\", Font.PLAIN, 12);");
        }
    }

    /**
     * Custom cell renderer to display each font name in its own font.
     */
    private class FontCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list,
                                                      Object value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String fontName = (String) value;
            Font font = new Font(fontName, Font.PLAIN, 16);
            label.setFont(font);
            return label;
        }
    }

    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new FontLister());
    }
}

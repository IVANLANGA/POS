import javax.swing.*;

public class PointOfSaleGUI extends JFrame {
    private Inventory inventory;

    public PointOfSaleGUI() {
        super("Point Of Sale");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create an instance of the Inventory class
        inventory = new Inventory();

        // Add Stock, Purchase, and Total Sale buttons
        JButton addStockBtn = new JButton("Add Stock");
        JButton purchaseBtn = new JButton("Purchase");
        JButton totalSaleBtn = new JButton("Total Sale");
        JPanel topPanel = new JPanel();
        topPanel.add(addStockBtn);
        topPanel.add(purchaseBtn);
        topPanel.add(totalSaleBtn);

        // Add Item, Delete Item, and Show Item buttons
        JButton addItemBtn = new JButton("Add Item");
        JButton deleteItemBtn = new JButton("Delete Item");
        JButton showItemBtn = new JButton("Show Items");
        JPanel middlePanel = new JPanel();
        middlePanel.add(addItemBtn);
        middlePanel.add(deleteItemBtn);
        middlePanel.add(showItemBtn);

        // Sold Items and Exit buttons
        JButton soldItemsBtn = new JButton("Sold Items");
        JButton exitBtn = new JButton("Exit");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(soldItemsBtn);
        bottomPanel.add(exitBtn);

        // Set the action listener for each button
        ButtonHandler buttonHandler = new ButtonHandler(inventory);
        addStockBtn.addActionListener(buttonHandler);
        purchaseBtn.addActionListener(buttonHandler);
        totalSaleBtn.addActionListener(buttonHandler);
        addItemBtn.addActionListener(buttonHandler);
        deleteItemBtn.addActionListener(buttonHandler);
        showItemBtn.addActionListener(buttonHandler);
        soldItemsBtn.addActionListener(buttonHandler);
        exitBtn.addActionListener(buttonHandler);

        // Add panels to the window
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(topPanel);
        add(middlePanel);
        add(bottomPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PointOfSaleGUI();
    }
}


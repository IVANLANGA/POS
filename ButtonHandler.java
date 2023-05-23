import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonHandler implements ActionListener {
    private Inventory inventory;

    public ButtonHandler(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Add Stock")) {
            // handle Add Stock button click
            String name = JOptionPane.showInputDialog("Enter item name to add stock:");
            StockItem item = inventory.searchItem(name);
            if (item != null) {
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to add:"));
                item.setStockCount(item.getStockCount() + quantity);
                JOptionPane.showMessageDialog(null, "Stock added successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Item not found.");
            }
        } 
        
        else if (command.equals("Purchase")) {
            // handle Purchase button click
            boolean done = false;
            double totalBill = 0.0;
            while (!done) {
                String name = JOptionPane.showInputDialog("Enter item name to purchase:");
                StockItem item = inventory.searchItem(name);
                if (item != null) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to purchase:"));
                    if (quantity <= item.getStockCount()) {
                        totalBill += item.getPrice() * quantity;
                        inventory.updateStockCount(item, item.getStockCount() - quantity);
                        JOptionPane.showMessageDialog(null, "Purchase successful.");
                        inventory.setTotalSales(totalBill);

                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient stock.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found.");
                }
                int choice = JOptionPane.showConfirmDialog(null, "Continue purchasing?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    done = true;
                }
            }
            JOptionPane.showMessageDialog(null, "Total bill is: $" + totalBill);
        } 
        
        else if (command.equals("Total Sale")) {
            // handle Total Sale button click
             double totalSales = inventory.getTotalSales();
            JOptionPane.showMessageDialog(null, "Total Sales: $" + totalSales);
        } 
        
        else if (command.equals("Add Item")) {
            // handle Add Item button click
            String name = JOptionPane.showInputDialog("Enter item name:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter item price:"));
            int stockCount = Integer.parseInt(JOptionPane.showInputDialog("Enter item stock count:"));
            inventory.addItem(new StockItem(name, price, stockCount));
        } 
        
        else if (command.equals("Delete Item")) {
            // handle Delete Item button click
            String name = JOptionPane.showInputDialog("Enter item name to delete:");
            StockItem item = inventory.searchItem(name);
            if (item != null) {
                inventory.removeItem(item);
                JOptionPane.showMessageDialog(null, "Item deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Item not found.");
            }
        } 
        
        else if (command.equals("Show Items")) {
            // handle Show Item button click
            String message = "Inventory Items:\n";
            for (StockItem item : inventory.getStockItems()) {
                message += item.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);

        } 
        
        else if (command.equals("Sold Items")) {
             // handle Sold Item button click
            String message = "Sold Items:\n";
            
            JOptionPane.showMessageDialog(null, message);
        } 
        
        else if (command.equals("Exit")) {
            // handle Exit button click
            System.exit(0);
        }
    }
}

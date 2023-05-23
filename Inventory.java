import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<StockItem> stockItems;
    private double totalSales;
    public Inventory() {
        stockItems = new ArrayList<>();
        totalSales=0;
    }

    public void addItem(StockItem item) {
        stockItems.add(item);
    }

    public void removeItem(StockItem item) {
        stockItems.remove(item);
    }

    public void updateStockCount(StockItem item, int newCount) {
        item.setStockCount(newCount);
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public StockItem searchItem(String itemName) {
        for (StockItem item : stockItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    
    public void setTotalSales(double sales)
    {
        totalSales += sales;
    }
    
    public double getTotalSales()
    {
        return totalSales;
    }
}

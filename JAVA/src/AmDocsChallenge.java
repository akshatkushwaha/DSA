
import java.util.*;

class MenuItem {
    int itemId;
    String itemName;
    double sumOfRating;
    int numberOfUsersRated;
}

interface MenuListOperations {
    void addItem(int id, String itemName);

    void outOfStock(int id);

    void reStock(int id);

    void addRating(int id, double rating);

    void setDealOfTheDay(int id);

    MenuItem getRecommendation();
}

class MenuListOperation implements MenuListOperations {
    private Map<Integer, MenuItem> menu;
    private Set<Integer> outOfStockItems;
    private MenuItem dealOfTheDay = null;

    public MenuListOperation() {
        menu = new HashMap<>();
        outOfStockItems = new HashSet<>();
    }

    @Override
    public void addItem(int id, String itemName) {
        if (!menu.containsKey(id)) {
            MenuItem item = new MenuItem();
            item.itemId = id;
            item.itemName = itemName;
            item.sumOfRating = 0;
            item.numberOfUsersRated = 0;
            menu.put(id, item);
        }
    }

    @Override
    public void outOfStock(int id) {
        if (menu.containsKey(id)) {
            outOfStockItems.add(id);
        }
    }

    @Override
    public void reStock(int id) {
        if (menu.containsKey(id)) {
            outOfStockItems.remove(id);
        }
    }

    @Override
    public void addRating(int id, double rating) {
        if (menu.containsKey(id)) {
            MenuItem item = menu.get(id);
            item.sumOfRating += rating;
            item.numberOfUsersRated++;

            menu.put(id, item);
        }
    }

    @Override
    public void setDealOfTheDay(int id) {
        if (menu.containsKey(id)) {
            dealOfTheDay = menu.get(id);
        }
    }

    @Override
    public MenuItem getRecommendation() {
        if (dealOfTheDay != null && !outOfStockItems.contains(dealOfTheDay.itemId)) {
            return dealOfTheDay;
        } else {
            double maxRating = 0;
            MenuItem maxRatingItem = null;
            for (Map.Entry<Integer, MenuItem> entry : menu.entrySet()) {
                MenuItem item = entry.getValue();
                if (!outOfStockItems.contains(item.itemId)) {
                    double rating = item.numberOfUsersRated != 0 ? item.sumOfRating / item.numberOfUsersRated : 0;
                    if (rating > maxRating) {
                        maxRating = rating;
                        maxRatingItem = item;
                    }
                }
            }
            return (maxRating == 0) ? null : maxRatingItem;
        }
    }

}

public class AmDocsChallenge {
    public static void main(String[] args) {
        MenuListOperation menuListOperation = new MenuListOperation();
        menuListOperation.addItem(1, "Dosa");
        menuListOperation.addItem(2, "Idly");
        menuListOperation.addItem(3, "Vada");

        menuListOperation.addRating(1, 5);

        MenuItem recommedation = menuListOperation.getRecommendation();
        if (recommedation != null) {
            System.out.println(recommedation.itemName);
        } else {
            System.out.println("No recommendation");
        }

        menuListOperation.outOfStock(1);

        menuListOperation.addRating(1, 4);
        menuListOperation.addRating(1, 4);

        recommedation = menuListOperation.getRecommendation();
        if (recommedation != null) {
            System.out.println(recommedation.itemName);
        } else {
            System.out.println("No recommendation");
        }
    }
}
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.HashMap;

/**
 * Inventory
 */
public class Ledger {
    LinkedList<Device> items;
    HashMap<String, Device> nameMap;
    HashMap<String, LinkedList<Device>> brandMap;
    HashMap<String, LinkedList<Device>> categoryMap;

    public Ledger() {
        items = new LinkedList<>();
        nameMap = new HashMap<>();
        brandMap = new HashMap<>();
        categoryMap = new HashMap<>();
    }

    public LinkedList<Device> getItems() {
        return this.items;
    }

    public void addItem(Device item) {
        items.add(item);
        nameMap.put(item.getModel(), item);

        if (!brandMap.containsKey(item.getManufacturer()))
            brandMap.put(item.getManufacturer(), new LinkedList<>());

        brandMap.get(item.getManufacturer()).push(item);

        if (!categoryMap.containsKey(item.getCategory()))
            categoryMap.put(item.getCategory(), new LinkedList<>());

        categoryMap.get(item.getCategory()).push(item);
    }

    public Device findItemByID(int id) {
        for (Device item : items) {
            if (item.getYear() == id)
                return item;
        }
        return null;
    }

    public boolean deleteItem(int id) {
        Device item = findItemByID(id);

        if (item == null)
            return false;
        else {
            items.remove(item);

            nameMap.remove(item.getModel());
            brandMap.get(item.getManufacturer()).remove(item);

            categoryMap.remove(item.getCategory()).remove(item);
            return true;
        }
    }

    public LinkedList<Device> filterByCategory(String category) {
        return categoryMap.get(category);
    }

    public LinkedList<Device> filterByBrand(String brand) {
        return brandMap.get(brand);
    }

    public Device getItemByName(String name) {
        return nameMap.get(name);
    }

    public LinkedList<Device> matchByName(String name) {

        LinkedList<Device> filteredItems = new LinkedList<>();

        items.forEach(item -> {
            if (item.getModel().contains(name))
                filteredItems.add(item);
        });
        return filteredItems;
    }

    public Device getLowestPricedItem(LinkedList<Device> items) {
        MinHeap heap = new MinHeap(items.size());

        items.forEach(heap::insert);

        return heap.remove();
    }

    public LinkedList<Device> getSortedItems(LinkedList<Device> items) {
        MinHeap heap = new MinHeap(items.size());

        items.forEach(heap::insert);

        LinkedList<Device> sorted = new LinkedList<>();

        while (!heap.isEmpty()) {
            sorted.add(heap.remove());
        }
        sorted = sorted.stream().filter(item -> item.getModel() != "").collect(Collectors.toCollection(LinkedList::new));
        return sorted;
    }

    public LinkedList<Device> getSortedByPrice(LinkedList<Device> items) {
        items.sort(Comparator.comparing(Device::getPrice));
        items.sort(Comparator
                .comparing(Device::getPrice)
                .reversed()
                .thenComparing(Device::getPrice));
        return items;
    }

    public LinkedList<Device> getSortedByName(LinkedList<Device> items) {
        items.sort(Comparator.comparing(Device::getModel));
        items.sort(Comparator
                .comparing(Device::getModel)
                .reversed()
                .thenComparing(Device::getModel));
        return items;
    }

    public LinkedList<Device> getSortedByYear(LinkedList<Device> items) {
        items.sort(Comparator.comparing(Device::getYear));
        items.sort(Comparator
                .comparing(Device::getYear)
                .reversed()
                .thenComparing(Device::getYear));
        return items;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-----Available Electronics-----\n\n");

        items.forEach(item -> {
            builder.append(item.toString());
            builder.append("\n------------------------\n");
        });

        return builder.toString();
    }

}
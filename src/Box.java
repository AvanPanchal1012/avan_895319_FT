import java.util.ArrayList;
import java.util.List;

public class Box {
    private List<Object> contents;
    private int boxNumber;

    public Box(int capacity, int boxNumber) {
        contents = new ArrayList<>(capacity);
        this.boxNumber = boxNumber;
    }

    public void addItem(Object item) {
        contents.add(item);
    }

    public void displayContents() {
        for (Object item : contents) {
            if (item instanceof SingleObject) {
                System.out.println(((SingleObject) item).getName());
            } else if (item instanceof Box) {
                ((Box) item).displayContents();
            }
        }
    }

    public int find(String itemName) {
        for (Object item : contents) {
            if (item instanceof SingleObject && ((SingleObject) item).getName().equals(itemName)) {
                return boxNumber;
            } else if (item instanceof Box) {
                int result = ((Box) item).find(itemName);
                if (result > 0) {
                    return result;
                }
            }
        }
        return -1;
    }
}

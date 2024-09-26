import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambda {

    public static class GFG {
        public static void main(String... args)
        {

            List<HardwareItems> list = getItems();
            System.out.println("before sort:");
            list.forEach(System.out::println);

            // Apply sorting and
            // also apply thenComparingInt()
            Collections
                    .sort(
                            list,
                            Comparator
                                    .comparing(HardwareItems::getName).reversed()
                                    .thenComparingInt(HardwareItems::getPrice));

            System.out.println("after sort:");
            list.forEach(System.out::println);
        }

        private static List<HardwareItems> getItems()
        {
            return Arrays.asList(
                    new HardwareItems("Laptop", 40000),
                    new HardwareItems("Desktop", 20000),
                    new HardwareItems("Laptop", 45500),
                    new HardwareItems("Monitor", 10000),
                    new HardwareItems("Desktop", 22000));
        }

        private static class HardwareItems {
            private String name;
            private int price;

            public HardwareItems(String name, int price)
            {
                this.name = name;
                this.price = price;
            }

            public String getName()
            {
                return name;
            }

            public int getPrice()
            {
                return price;
            }

            @Override
            public String toString()
            {
                return "HardwareItems [name="
                        + name
                        + ", price="
                        + price + "]";
            }
        }
    }
}

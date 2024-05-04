import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item{
        int id;
        int profit;
        int weight;
        
        public Item(int id, int profit,int weight){
            this.id = id;
            this.profit = profit;
            this.weight = weight;
        }
    }

     static void sortByProfit(Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(item -> -(double)item.profit/(double)item.weight));
    }



    static void fillKnapsack(Item[] items, int knapsackCapacity) {
        sortByProfit(items);
        double[] fractions = new double[items.length];
        int currentWeight = 0;
        double totalProfit = 0;

        for (int i = 0; i < items.length; i++) {
            if (currentWeight + items[i].weight <= knapsackCapacity) {
                fractions[i] = 1;
                currentWeight += items[i].weight;
                totalProfit += items[i].profit;
            } else {
                fractions[i] = (double) (knapsackCapacity - currentWeight) / items[i].weight;
                currentWeight = knapsackCapacity;
                totalProfit += items[i].profit * fractions[i];
                break;
            }
        }

        System.out.println("Items in the knapsack:");
        for (int i = 0; i < items.length; i++) {
            if (fractions[i] > 0) {
                System.out.println("Item " + items[i].id + ": Fraction = " + fractions[i] + ", Profit = " + (items[i].profit * fractions[i]));
            }
        }

        System.out.println("Total Profit: " + totalProfit);
    }
    

    
    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(1, 60, 10);
        items[1] = new Item(2, 100, 20);
        items[2] = new Item(3, 120, 30);
     
        // for (int i = 3; i < items.length; i++) {
        //     items[i] = new Item(i + 1, 0, 0); 
        // }
        int knapsackCapacity = 50;
        fillKnapsack(items, knapsackCapacity);
    }
}

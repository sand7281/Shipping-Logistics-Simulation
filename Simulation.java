import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    private ArrayList<Item> items;
    private ArrayList<ShippingVehicle> truckU1;
    private ArrayList<ShippingVehicle> truckU2;
    private boolean hasLanded = true;
    private File phase1 = new File("phase-1.txt");
    private File phase2 = new File("phase-2.txt");

    public Simulation() {
    }

    public ArrayList<Item> loadItems(int phase) throws FileNotFoundException {

        if (phase == 1) {
            loadPerPhaseItems(phase1);
        } else {
            loadPerPhaseItems(phase2);
        }

        return items;
    }

    public void loadPerPhaseItems(File file) throws FileNotFoundException {
        items = new ArrayList<Item>();
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String string = fileScanner.nextLine();
            String[] separated = string.split("=");

            Item item = new Item(separated[0], Integer.parseInt(separated[1]));
            items.add(item);
        }
    }

    public ArrayList<ShippingVehicle> loadU1(List<Item> itemsU1) {
        System.out.println("Loading 1st shipping company...");
        truckU1 = new ArrayList<ShippingVehicle>();
        ShippingVehicle shippingvehicle = new Truck1();
        Iterator iterator = itemsU1.iterator();
        int i = 2;

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (shippingvehicle.canCarry(item)) {
                shippingvehicle.carry(item);
            } else {
                truckU1.add(shippingvehicle);
                shippingvehicle = new Truck1();
                System.out.println(i+" trucks used");
                shippingvehicle.carry(item);
                i++;
            }
            if (!iterator.hasNext()) {
                truckU1.add(shippingvehicle);
            }
        }

        return truckU1;
    }

    public ArrayList<ShippingVehicle> loadU2(ArrayList<Item> itemsU2) {
        System.out.println("Loading 2nd shipping company...");
        truckU2 = new ArrayList<ShippingVehicle>();
        ShippingVehicle shippingvehicle = new Truck1();
        Iterator iterator = itemsU2.iterator();
        int i = 2;

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            
            if (shippingvehicle.canCarry(item)) {
                shippingvehicle.carry(item);
            } else {
                truckU2.add(shippingvehicle);
                shippingvehicle = new Truck1();
                System.out.println(i+" trucks used");
                shippingvehicle.carry(item);
                i++;
            }
            if (!iterator.hasNext()) {
                truckU2.add(shippingvehicle);
            }
        }

        return truckU2;
    }

    public void runSimulation(ArrayList<ShippingVehicle> shippingvehicles, int i) {

        for (ShippingVehicle shippingvehicle : shippingvehicles) {

            while (!shippingvehicle.launch()) {
                launchSimulation(i);
            }

            while (!shippingvehicle.land()) {
                while (!shippingvehicle.launch()) {
                    launchSimulation(i);
                }
            }

        }
    }

    public void launchSimulation(int i) {

        if (i == 1) {
            int counter1 = Truck1.getTruckU1Counter();
            counter1++;
            Truck1.setTruckU1Counter(counter1);

        } else {
            int counter2 = Truck1.getTruckU2Counter();
            counter2++;
            Truck1.setTruckU2Counter(counter2);

        }
    }
   public void launchSimulation2(int i) {

        if (i == 1) {
            int counter1 = Truck1.getTruckU1Counter();
            counter1++;
            Truck1.setTruckU1Counter(counter1);

        } else {
            int counter2 = Truck1.getTruckU2Counter();
            counter2++;
            Truck1.setTruckU2Counter(counter2);

        }
    }
   public void runSimulation2(ArrayList<ShippingVehicle> shippingvehicles, int i) {
        for (ShippingVehicle shippingvehicle : shippingvehicles) {

            while (!shippingvehicle.launch()) {
                launchSimulation2(i);
            }

            while (!shippingvehicle.land()) {
                while (!shippingvehicle.launch()) {
                    launchSimulation(i);
                }
            }

        }
    }
}
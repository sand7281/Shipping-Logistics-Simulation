import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int phase1 = 1;
        final int phase2 = 2;

        double u1Cost;
        double u2Cost;

        ArrayList<Item> phase1Item;
        ArrayList<Item> phase2Item;

        Simulation simulation = new Simulation();

        phase1Item = simulation.loadItems(phase1);
        phase2Item = simulation.loadItems(phase2);
        

        System.out.println("=====Simulating Shipment 1=====Simulating Shipment 1=====Simulating Shipment 1=====");
        simulation.runSimulation(simulation.loadU1(phase1Item), 1);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");
     

        System.out.println("=====Simulating Shipment 2=====Simulating Shipment 2=====Simulating Shipment 2=====");
        simulation.runSimulation(simulation.loadU1(phase2Item), 1);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");
        
        

        System.out.println("===================================================================================\n===================================================================================\n");
        System.out.println("=====Simulating Shipment 1=====Simulating Shipment 1=====Simulating Shipment 1=====");
        simulation.runSimulation2(simulation.loadU2(phase1Item), 2);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");

        
        System.out.println("=====Simulating Shipment 2=====Simulating Shipment 2=====Simulating Shipment 2=====");
        simulation.runSimulation2(simulation.loadU2(phase2Item), 2);
        System.out.println("=====Simulation Done=====Simulation Done=====Simulation Done=====\n");

        
        System.out.println("A total of " + Truck1.getTruckU1Counter() + " trucks were used for the first group.");
        System.out.println("A total of " + Truck1.getTruckU2Counter() + " trucks were used for the second group.");
        
        
        u1Cost = Truck1.getTotalCost();
        u2Cost = Truck1.getTotalCost();
        
        
        System.out.println("\nTotal budget needed for Truck 1 is: " + u1Cost);
        System.out.println("Total budget needed for Truck 2 is: " + u2Cost);

        if (u1Cost > u2Cost) {
            System.out.println("Using Truck 2 is cheaper in this simulation");
        } else {
            System.out.println("Using Truck 1 is cheaper in this simulation");
        }

    }
}
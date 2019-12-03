import java.util.Random;

public class Truck1 extends ShippingVehicle {
    private static int truckU1Counter;
    private static int truckU2Counter;
   /* private final int maxCargo = 8000;
    private static final double cost = 3.1;
    private final int weight = 10000;*/
    private final double finalCost = 0;

    public Truck1() {
        this(8000, 3.1, 10000, 0);
        truckU1Counter++;
    }

    public Truck1(int maxCargo, double cost, int weight, int lastWeight) {
        setMaxCargo(maxCargo);
        setCost(cost);
        setWeight(weight);
        setCurrentWeight(lastWeight);
        System.out.println("-----------------------");
        System.out.println("| Max Cargo : "+maxCargo+" |\n| Cost : "+cost+" |\n| Weight : "+weight+" |");
        System.out.println("-----------------------");
    }
    
    /*public Truck2(int maxCargo, double cost, int weight, int lastWeight) {
        setMaxCargo(maxCargo);
        setCost(cost);
        setWeight(weight);
        setCurrentWeight(lastWeight);

        truckU2Counter++;
        System.out.println("------------------------------------");
        System.out.println(maxCargo+" "+cost+" "+weight);
    }*/
    public static int getTruckU1Counter() {
        return truckU1Counter;
    }
    public static int getTruckU2Counter() {
        return truckU2Counter;
    }

    public static void setTruckU1Counter(int truckU1Counter) {
        Truck1.truckU1Counter = truckU1Counter;
    }
    
    public static void setTruckU2Counter(int truckU2Counter) {
        Truck1.truckU2Counter = truckU2Counter;
    }

    @Override
    public boolean launch() {
        double cost = 3.1;
        System.out.println("\nDelivering...");
        Random rd = new Random();
        int distance = 1200;
        double time = 0;
        for(int i = 0; i < distance; i++) {
          double rand = rd.nextDouble();
          if (rand <= .90) {
            time++;
          }
          else {
            time++;
            i++; 
          }
        }
        
        System.out.println("Cargo: " + getCurrentWeight());
        System.out.println("Truck returned to distribution center!");
        System.out.println("Cost for this truck: " +(time*cost));
        return true;
    }


    public static double getTotalCost() {
       Random rd = new Random();
        int distance = 1200;
        double time = 0;
        double cost = 3.1;
        for(int i = 0; i < distance; i++) {
          double rand = rd.nextDouble();
          if (rand <= .90) {
            time++;
          }
          else {
            time++;
            i++; 
          }
        }
        return (double) time*cost;
    }

    /*public boolean launch2() {
        System.out.println("\nDelivering...");
        Random rd = new Random();
        int distance = 1800;
        double time = 0;
        double cost = 2.9;
        for(int i = 0; i < distance; i++) {
          double rand = rd.nextDouble();
          if (rand <= .85) {
            time++;
          }
          else {
            time++;
            i++; 
          }
        }
        
        System.out.println("Cargo: " + getCurrentWeight());
        System.out.println("Truck returned to distribution center!");
        System.out.println("Cost for this truck: " +(time*cost));
        return true;
    }

    public static double getTotalCost2() {
        Random rd = new Random();
        int distance = 1800;
        double time = 0;
        double cost = 2.9;
        for(int i = 0; i < distance; i++) {
          double rand = rd.nextDouble();
          if (rand <= .85) {
            time++;
          }
          else {
            time++;
            i++; 
          }
        }
        return (double) time * cost;      
    }*/

}
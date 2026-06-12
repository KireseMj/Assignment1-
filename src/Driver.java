
/**
 * Scripted demo of the Caribbean Cargo & Logistics System.
 * Creates 12 packages, packs and dispatches them, and prints reports.
 *
 * TODO M10: Complete this class so that running "java Driver" produces
 * the exact expected output shown in the README.
 */
public class Driver {

    public static void main(String[] args) {

        // Step 1: Create the terminal
        // TODO M10: Create a FreightTerminal named "Port of Spain Hub"
        FreightTerminal terminal = new FreightTerminal("Port of Spain Hub");

        // Step 2: Create and receive all 12 packages
        // TODO M10: Create these 12 packages in order (PKG-0001 through PKG-0012):
        Package p1 = new Package ("Alice", "Bob", 5.0, 40, 30, 20, "Trinidad");
        Package p2  = new Package ("Carol", "Dan", 2.0, 60, 40, 40, "Barbados", true, 500);
        Package p3 = new Package ("Eve", "Frank", 10.0, 30, 30, 30, "Jamaica");
        Package p4= new Package("Grace", "Hank", 3.5, 50, 50, 50, "Barbados", false, 200);
        Package p5= new Package ("Ivy", "Jack", 8.0, 20, 20, 20, "Trinidad", true, 1000);
        Package p6= new Package ("Kim", "Leo", 1.5, 100, 60, 40, "Antigua");
        Package p7= new Package ("Mia", "Noah", 15.0, 40, 40, 30, "Jamaica", true, 750);
        Package p8= new Package ("Olivia", "Pat", 6.0, 35, 25, 15, "Grenada");
        Package p9= new Package ("Quinn", "Ray", 4.0, 45, 35, 25, "Trinidad", false, 100);
        Package p10 = new Package("Sara", "Tim", 20.0, 80, 60, 50, "Barbados", true, 2000);
        Package p11 = new Package ("Uma","Vic", 0.5, 15, 10, 10, "Grenada");
        Package p12 = new Package ("Will", "Xia", 12.0, 50, 40, 30, "Antigua", true, 300);

        terminal.receivePackage(p1);
        terminal.receivePackage(p2);
        terminal.receivePackage(p3);
        terminal.receivePackage(p4);
        terminal.receivePackage(p5);
        terminal.receivePackage(p6);
        terminal.receivePackage(p7);
        terminal.receivePackage(p8);
        terminal.receivePackage(p9);
        terminal.receivePackage(p10);
        terminal.receivePackage(p11);
        terminal.receivePackage(p12);

        // Step 3: Print pending count
        // TODO M10: Print "=== Pending: 12 packages ==="
        System.out.println("== Pending: " + terminal.getPendingCount() + " packages ==");

        // Step 4: Print first package details for verification
        // TODO M10: Print p1.toString() and its shipping cost
        System.out.println(p1.toString());
        System.out.printf("Shipping cost: $%.2f%n", p1.getShippingCost());
        System.out.println();

        // Step 5: Pack containers
        // TODO M10: Call packContainers() and print "Packed into N containers"
        int numContainers = terminal.packContainers();
        System.out.println("Packed into " + numContainers + " containers");
        System.out.println();

        // Step 6: Print manifests for all active containers
        // TODO M10: Loop through getActiveContainers() and print each manifest
        for (Container c : terminal.getActiveContainers()){
            System.out.println(c.getManifest());
            System.out.println();
        }

        // Step 7: Dispatch all containers
        // TODO M10: Call dispatchAll() and print "Dispatched N containers"
        int dispatched = terminal.dispatchAll();
        System.out.println("Dsipatched " + dispatched + " containers");
        System.out.println();

        // Step 8: Print daily report
        // TODO M10: Call printDailyReport()
        terminal.
                printDailyReport();
        System.out.println();

        // Step 9: Find a package
        // TODO M10: Find "PKG-0005" and print "Found: " + result
        Package found = terminal.findPackage("PKG-0005");
        System.out.println ("Found: " + found);

        // Step 10: Try to find a non-existent package
        // TODO M10: Find "PKG-9999" and print "PKG-9999: Not found" if null
        Package notFound = terminal.findPackage("PKG-9999");
        if (notFound ==null){
            System.out.println("PKG-9999: Not found");
        }
    }
}

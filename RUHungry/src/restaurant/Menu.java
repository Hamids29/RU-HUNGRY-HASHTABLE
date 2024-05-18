package restaurant;
/**
 * Use this class to test your Menu method. 
 * This class takes in two arguments:
 * - args[0] is the menu input file
 * - args[1] is the output file
 * 
 * This class:
 * - Reads the input and output file names from args
 * - Instantiates a new RUHungry object
 * - Calls the menu() method 
 * - Sets standard output to the output and prints the restaurant
 *   to that file
 * 
 * To run: java -cp bin restaurant.Menu menu.in menu.out
 * 
 */
public class Menu {
    public static void main(String[] args) {

	// 1. Read input files
	// Option to hardcode these values if you don't want to use the command line arguments
	

        String inputFile = "menu.in"; //"menu.in"
        String inputfile2 = "stock.in";
        String outputFile = "menu.out";
        StdOut.println("Input file:" + inputFile); //menu
	StdOut.println("Output file:" + outputFile);//
        String transactionInputFile = "transaction1.in"; 

//         String orderInputFile = "order3.in"; //method 8 
//      String donationInputFile = "donate3.in"; //method 10
//  String restockInputFile = "restock3.in"; //Use to test method 11
        // 2. Instantiate an RUHungry object
        RUHungry rh = new RUHungry();

	// 3. Call the menu() method to read the menu
        rh.menu(inputFile);
        rh.createStockHashTable(inputfile2);
        rh.updatePriceAndProfit();
//     readOrders(orderInputFile, rh);
// readDonations(donationInputFile, rh);
//   readRestock(restockInputFile, rh);// method 11
        //readOrders(orderInputFile, rh);
        
        transactions("transaction1.in", rh); 

        StdOut.println("Called menu:" + inputFile);
	// 4. Set output file
	// Option to remove this line if you want to print directly to the screen
        StdOut.setFile(outputFile);

	// 5. Print restaurant
        rh.printRestaurant();

        
    }
//method 8 :<
    public static void readOrders (String fileName, RUHungry rh)
    {
        StdIn.setFile(fileName);
        int numOfOrders = Integer.parseInt(StdIn.readLine()); 
        for (int  i = 0; i<numOfOrders; i++)
        {
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.order(item, amount);
        }
    }
    //method 10 
      public static void readDonations (String fileName, RUHungry rh)
    {
        StdIn.setFile(fileName);
        int numOfDonations = Integer.parseInt(StdIn.readLine()); 
        for (int  i = 0; i<numOfDonations; i++)
        {
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.donation(item, amount);
        }
    }

      // method 11
    public static void readRestock (String fileName, RUHungry rh)
    {
        StdIn.setFile(fileName);
        int numOfRestock = Integer.parseInt(StdIn.readLine()); 
        for (int  i = 0; i<numOfRestock; i++)
        {
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.restock(item, amount);
        }
    }

     public static void readOrders2 (String dishName, int dishQuantity, RUHungry rh)
    {
        rh.order(dishName, dishQuantity);
    }



      public static void readDonations2 (String dishName, int dishQuantity, RUHungry rh)
    {
        
        rh.donation(dishName, dishQuantity);
        
    } 

    
      public static void readRestock2 (String dishName, int dishQuantity, RUHungry rh)
    {
           
        rh.restock(dishName, dishQuantity);

    } 

     //test transaction files
    public static void transactions (String fileName, RUHungry rh)
    {
        StdIn.setFile(fileName);
        int numOfTransactions = StdIn.readInt(); 
        StdIn.readLine();
        for (int i = 0; i<numOfTransactions; i++)
        {
                String type = StdIn.readString();
                StdIn.readChar();
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();

                if(type.equals("order"))
                {
                        readOrders2(item, amount, rh);
                }
                else if (type.equals("donation"))
                {
                        readDonations2(item, amount, rh);
                }
                else if (type.equals("restock"))
                {
                        readRestock2(item, amount, rh);
                }
           }
        } 


}

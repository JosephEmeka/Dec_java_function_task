import java.util.Scanner;
import java.util.Date; 
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class CheckOutApp{


	public static Scanner input = new Scanner(System.in);


	public static List<Item> itemList = new ArrayList<>();


	public static Calendar myCalender = Calendar.getInstance();


	public static String cashierName;

	public static String customerName;


	Item items;

	public static double vatPercentage = 17.50;


	public static double total;


	public static double discount;

	
	


		public static void main(String[] arg){


			startMenu();

		
		
		}



			public static void addPurchasedItem(List<Item> itemList, String itemBought, double price, int quantity) {

				double totalAmount = price * quantity;

        			Item items = new Item(itemBought, price, quantity, totalAmount);
				
				itemList.add(items);
				
    				
				}



			

			public static double subTotal() {

    				total = 0.0;

    				for (Item items : itemList) {

        				total += items.getTotalAmount();
					
    					}

				//System.out.println(total);

    				return total;

				
				}








			public static void startMenu(){


				System.out.println ("What is the customer's Name?  ");

					
				String myCustomerName = input.nextLine();

				setCustomerName(myCustomerName);



				System.out.println ("What did the user buy?  ");


				String itemBought = input.nextLine();


				System.out.println ("How many pieces?  ");


				int quantity = input.nextInt();


				System.out.println ("How much per unit?  ");


				double price = input.nextDouble();

				
				addPurchasedItem(itemList, itemBought, price, quantity);


				addMoreItem();

				}






			public static void addMoreItem(){

				Scanner input = new Scanner(System.in);

				System.out.println ("Add more Items? Type Yes or No  ");


				String moreItems = input.nextLine();
		
		
				if (moreItems.equalsIgnoreCase("yes")){

					repeatMenu();

					}


				if (moreItems.equalsIgnoreCase("No")){

					cashierNameMenu();

					} 	

				}






			public static void repeatMenu(){
				
				Scanner input = new Scanner(System.in);


				System.out.println ("What did the user buy?  ");


				String itemBought = input.nextLine();


				System.out.println ("How many pieces?  ");


				int quantity = input.nextInt();


				System.out.println ("How much per unit?  ");


				double costPerUnit = input.nextDouble();


				addPurchasedItem(itemList, itemBought, costPerUnit, quantity);


				addMoreItem();


			}

			
			
				
			public static void cashierNameMenu() {

				Scanner input = new Scanner(System.in);

				System.out.println ("What is your name?  ");

				String my_cashierName = input.nextLine();

				setCashierName(my_cashierName);

				System.out.println ("How much discount will he get?  ");

				double discount = input.nextDouble();

				customersInvoice();

			}



			public static void printItemDetails(){
    				for (Item items: itemList ) {
        			System.out.println("  " + items.getItemName() + "\t\t"+ items.getPrice() + "\t\t" + items.getQuantity() + "\t\t" + items.getTotalAmount());
   

	 			}
			}


			

			public static void setCashierName(String thisCashierName){

				cashierName = thisCashierName;

			
			}


			

			public static void setCustomerName(String thisCustomerName){

				customerName = thisCustomerName;

			
			}
			
			
			public static double calculateDiscount() {


    				for (Item items : itemList) {

        				total += items.getTotalAmount();

    					}

    			
			double myDiscount = (discount / 100) * total;
    
			return myDiscount;
		
			}




			public static double calculateVAT() {

				total = 0.0;

    				for (Item items : itemList) {

        				total += items.getTotalAmount();

    					}

    			return((vatPercentage/100) * total);

			}



			public static double totalBill() {

    				double subTotal = subTotal(); 
    
				double vat = calculateVAT(); 

    				double finalBill = subTotal  + vat;

			return finalBill;
			
				}


			public static void customersInvoice(){
				System.out.println("  		       ");
				System.out.println("                   ");
				System.out.println("                   ");
				System.out.println("  SEMICOLON  STORES");
				System.out.println("  MAIN BRANCH");
				System.out.println("  LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
				System.out.println("  TELL:  03293828343");
				System.out.println("  DATE: " + myCalender.getTime());
				System.out.println("  Cashier: " + cashierName);
				System.out.println("  Customer Name: " + customerName);
				System.out.println("==================================================================");
				System.out.println("  ITEM \t\tPRICE \t\tQTY \t\tTOTAL(NGN) ");
				System.out.println("-------------------------------------------------------------------");
				printItemDetails();
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t\t\tSub Total:        " + subTotal()); 
				System.out.println("\t\t\t\tDiscount:         " + calculateDiscount());
				System.out.println("\t\t\t\tVAT @ 17.50% :    " + calculateVAT());
				System.out.println("==================================================================");
				System.out.println("\t\t\t\tBill Total:        " + totalBill()); 
				System.out.println("==================================================================");
				System.out.println("THIS IS NOT A RECEIPT KINDLY PAY " + totalBill());
				System.out.println("==================================================================");
			}


			


}

			








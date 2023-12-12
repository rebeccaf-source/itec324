package itec324;
import java.util.Scanner;
/**
 * This is for Customer mode of the vending machine
 * @author Rebecca Fonseth
 * @version 1.0
 */
public class Customer 
{
	private static VendingMachine vc = new VendingMachine();
	private Coin coins = new Coin();
	private Item item = new Item();
	
	
	/**
	 * Constructor for Customer class
	 */
	public Customer()
	{ 
		this.optionsMenu();
	}
	
	/**
	 * shows the available products in the vending machine to the customer
	 */
	public void availableItems()
	{
		Scanner scan = new Scanner(System.in);
		item.displayMenu_Customer();
		System.out.println("Please enter the three digit code of the item you would like to purchase: ");
		int ans = scan.nextInt();
		this.selectItem(ans);
	}
	/**
	 * instructs the customer to insert money to pay for the item they chose
	 * 
	 * @param price the price of the item that they chose
	 * @param code the three-digit code of the item that they chose
	 */ 
	public void insertCoin(double price, int code)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("You can only insert one coin at a time. Please enter N when you're ready for the next coin type.");
		boolean num = true;
		while(num)
		{
			System.out.println("Would you like to insert a quarter? Y/N");
			String ans = scan.next().toUpperCase();
			if(ans.equals("N"))
			{
				num = false;
				break;
			}
			this.coins.inputQuarters(1);//method in coin class
		}
		num = true;
		while(num)
		{
			System.out.println("Would you like to insert a dime? Y/N");
			String ans = scan.next().toUpperCase();
			if(ans.equals("N"))
			{
				num = false;
				break;
			}
			coins.inputDimes(1);
		}
		num = true;
		while(num)
		{
			System.out.println("Would you like to insert a nickel? Y/N");
			String ans = scan.next().toUpperCase();
			if(ans.equals("N"))
			{
				num = false;
				break;
			}
			coins.inputNickels(1);
		}
		num = true;
		while(num)
		{
			System.out.println("Would you like to insert a penny? Y/N");
			String ans = scan.next().toUpperCase();
			if(ans.equals("N"))
			{
				num = false;
				break;
			}
			coins.inputPennies(1);
		}
		
		coins.pay(price, code);//method in coin class
	}
	/**
	 * takes the code that the user inputed and matches it the item in the items enum class
	 * 
	 * @param code the three-digit code to the item they chose
	 */
	public void selectItem(int code)
	{
		Items[] items = Items.values();
		for(Items item : items)
		{
			if(item.getCode() == code)
			{
				System.out.println("You have selected " + item.getName() + " to purchase.");
				System.out.printf("The price is $%.2f\n", item.getPrice(item));
				this.insertCoin(item.getPrice(item), item.getCode());
			}
		}
	}
	/**
	 * connects to methods that will be shown to the user as a menu
	 */
	public void optionsMenu()
	{
		this.toOperator();
		this.endTransaction();
		this.availableItems();
	}
	/**
	 * this method asks the customer if they would like to switch to operator mode or not
	 */
	public void toOperator()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to switch to Operator Mode? Y/N");
		String ans = scan.next().toUpperCase();
		if(ans.equals("Y"))
		{
			vc.operator.login();
		}
	}
	/**
	 * this method asks the customer if they would like to logout of the system
	 */
	public void endTransaction()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to logout? Y/N");
		String ans = scan.next().toUpperCase();
		if(ans.equals("Y"))
		{
			vc.logout();
		}
	}
}

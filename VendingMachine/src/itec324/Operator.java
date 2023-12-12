package itec324;
import java.util.Scanner;
/**
 * 
 * @author Rebecca Fonseth
 * @version 1.0
 */
public class Operator 
{
	private String password = "op";
	public Item item = new Item();
	
	public Coin coin = new Coin();
	
	/**
	 * constructor for the operator class that sets the prices of the items
	 */
	public Operator()
	{
		item.setInitialPrices();
	}
	
	/**
	 * the login for the operator class
	 */
	public void login()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What's the password?"); 
		String ans = scan.nextLine();
		if(ans.equals(this.password))
		{
			System.out.println("Welcome, Operator");
			this.optionsMenu();
		}
		else
		{
			System.out.println("Wrong password.");
			Customer cd = new Customer();
		}
		scan.close();
	}
	/**
	 * this displays the options menu for the operator to see what they can do
	 */
	public void optionsMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("------------------------------------");
		System.out.println("-----------Options Menu-------------");
		System.out.println("------------------------------------");
		System.out.println("1.   Remove Coins");
		System.out.println("2.   Restock Items");
		System.out.println("3.   Change Price of Items");
		System.out.println("4.   Go to Customer Mode");
		int ans = scan.nextInt();
		
		if(ans == 1)
		{
			this.removeCoins();
		}
		else if(ans == 2)
		{
			this.restock();
		}
		else if(ans == 3)
		{
			this.changePrice();
		}
		else if(ans == 4)
		{
			Customer cust = new Customer();
		}
		scan.close();
	}
	/**
	 * this is for the operator to remove coins from the machine
	 */
	public void removeCoins()
	{
		Scanner scan = new Scanner(System.in);
		coin.availableCoin();
		
		System.out.println("How many quarters would you like to remove?");
		int num = scan.nextInt();
		if(num > 0)
		{
			coin.removeQuarters(num);
		}
		
		System.out.println("How many dimes would you like to remove?");
		num = scan.nextInt();
		if(num > 0)
		{
			coin.removeDimes(num);
		}
		
		System.out.println("How many nickels would you like to remove?");
		num = scan.nextInt();
		if(num > 0)
		{
			coin.removeNickels(num);
		}
		
		System.out.println("How many pennies would you like to remove?");
		num = scan.nextInt();
		if(num > 0)
		{
			coin.removePennies(num);
		}
		
		this.optionsMenu();
		scan.close();
	}
	/**
	 * for the operator to restock the vending machine
	 */
	public void restock()
	{
		Scanner scan = new Scanner(System.in);
		item.displayMenu_Operator();
		System.out.println("Please enter the three digit code of the item you would like to restock: ");
		int code = scan.nextInt();
		System.out.println("How much of the item would you like to add?");
		int num = scan.nextInt();
		item.changeQuantity(code, num);
		this.optionsMenu();
		scan.close();
	}
	/**
	 * for the operator to change the price of an item
	 */
	public void changePrice()
	{
		Scanner scan = new Scanner(System.in);
		item.displayMenu_Operator();
		System.out.println("Please enter the three digit code of which item you would like to change the price of: ");
		int code = scan.nextInt();
		Items[] items = Items.values();
		for(Items i : items)
		{
			if(i.getCode() == code)
			{
				System.out.println("Please enter the price you would like to change it too: ");
				double price = scan.nextDouble();
				i.setPrice(i, price);//method in the enum
				this.optionsMenu();
			}
		}
		System.out.println("You entered an invalid code. ");
		this.optionsMenu();
		scan.close();
		
	}

}

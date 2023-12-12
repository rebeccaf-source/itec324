package itec324;
/**
 * This class will keep track of the money
 * @author Rebecca Fonseth
 * @version 1.0
 */
public class Coin 
{
	private Items[] items = Items.values();
	//these are for what are already in the vending machine
	public static int quarters = 10;
	public static int dimes = 10;
	public static int nickels = 10;
	public static int pennies = 10;
	
	//these are for what the customer private int customer_quarters = 0;
	private int customer_quarters = 0;
	private int customer_dimes = 0;
	private int customer_nickels = 0;
	private int customer_pennies = 0;
	
	
	
	/**
	 * for the operator to see what coins are currently in the vending machine
	 */
	public void availableCoin()
	{
		System.out.println("------------------------------------");
		System.out.println("--------Current Coin Stock----------");
		System.out.println("------------------------------------");
		System.out.printf("%-15s%d\n", "Quarters", quarters);
		System.out.printf("%-15s%d\n", "Dimes", dimes);
		System.out.printf("%-15s%d\n", "Nickels", nickels);
		System.out.printf("%-15s%d\n", "Pennies", pennies);
	}
	/**
	 * this method notifies the user whether they have paid enough money or not and returns change if they need too
	 * 
	 * @param price the price of the item that they chose
	 * @param code the three-digit code to the item that the customer chose
	 */
	public void pay(double price, int code)
	{
		Customer cd;
		Item item = new Item();
		double c_input = 0;
		c_input += this.customer_quarters * .25;
		c_input += this.customer_dimes * .1;
		c_input += this.customer_nickels * 0.05;
		c_input += this.customer_pennies * 0.01;
		System.out.printf("You have inputted $%.2f\n", c_input);
		
		if(c_input < price)
		{
			System.out.println("You have not inputted enough coin.");
			cd = new Customer();
		}
		else if(c_input == price)
		{
			quarters += this.customer_quarters;
			dimes += this.customer_dimes;
			nickels += this.customer_nickels;
			pennies += this.customer_pennies;
			this.customer_quarters = 0;
			this.customer_dimes = 0;
			this.customer_nickels = 0;
			this.customer_pennies = 0;
			System.out.println("Thank you for your purchase");
			item.changeQuantity(code, -1);
			cd = new Customer();
		}
		else
		{
			quarters += this.customer_quarters;
			dimes += this.customer_dimes;
			nickels += this.customer_nickels;
			pennies += this.customer_pennies;
			this.customer_quarters = 0;
			this.customer_dimes = 0;
			this.customer_nickels = 0;
			this.customer_pennies = 0;
			item.changeQuantity(code, -1);
			this.getChange(price, c_input);
			System.out.println("Thank you for your purchase");
		}
	}
	
	/**
	 * this method returns change when the user put in too much money
	 * 
	 * @param price the price of the item that they chose
	 * @param total the total amount of money that the user has inserted
	 */
	public void getChange(double price, double total)
	{
		double balance = total - price;
		
		balance = returnQuarters(balance);
		if(balance != 0)
		{
			balance = returnDimes(balance);
		}
		if(balance != 0)
		{
			balance = returnNickels(balance);
		}
		if(balance != 0)
		{
			balance = returnPennies(balance);
		}
		Customer cd = new Customer();//to get back to the options menu
		
	}
	/**
	 * this method counts how much of the change return is in quarters
	 * 
	 * @param balance how much of the total-price is left after change
	 * @return what's left of the balance after taking the quarters out
	 */
	public double returnQuarters(double balance)
	{
		int return_quarters = (int) (balance / .25);
		if(return_quarters > quarters)
		{
			return_quarters = quarters;
		}
		System.out.println("You've been returned " + return_quarters + " quarters.");
		quarters -= return_quarters;
		return balance - (return_quarters * .25);
	}
	
	/**
	 * this method counts how much of the change return is in dimes
	 * 
	 * @param balance how much of the total-price is left after previous change
	 * @return what's left of the balance after taking the dimes out
	 */
	public double returnDimes(double balance)
	{
		int return_dimes = (int)(balance / .1);
		if(return_dimes > dimes)
		{
			return_dimes = dimes;
		}
		System.out.println("You've been returned " + return_dimes + " dimes.");
		dimes -= return_dimes;
		return balance - (return_dimes * .1);
	}
	/**
	 * this method counts how much of the change return is in nickels
	 * 
	 * @param balance how much of the total-price is left after previous change
	 * @return what's left of the balance after taking the nickels out
	 */
	public double returnNickels(double balance)
	{
		int return_nickels = (int)(balance / 0.05);
		if(return_nickels > nickels)
		{
			return_nickels = nickels;
		}
		System.out.println("You've been returned " + return_nickels + " nickels.");
		nickels -= return_nickels;
		return balance - (return_nickels * 0.05);
	}
	/**
	 * this method counts how much of the change return is in pennies
	 * 
	 * @param balance how much of the total-price is left after previous change
	 * @return what's left of the balance after taking the pennies out
	 */
	public double returnPennies(double balance)
	{
		int return_pennies = (int)((Math.round(balance * 100.0)/100.0) * 100);
		if(return_pennies > pennies)
		{
			return_pennies = pennies;
		}
		System.out.println("You've been returned " + return_pennies + " pennies.");
		pennies -= return_pennies;
		return balance - (return_pennies * 0.01);
	}
	/**
	 * takes in the quarter input from the customer and saves it in the class
	 * 
	 * @param num the number of quarters being inputed by the customer
	 */
	public void inputQuarters(int num)
	{
		customer_quarters += num;
	}
	/**
	 * takes in the dimes input from the customer and saves it in the class
	 * 
	 * @param num the number of dimes being inputed by the customer
	 */
	public void inputDimes(int num)
	{
		customer_dimes += num;
	}
	/**
	 * takes in the nickels input from the customer and saves it in the class
	 * 
	 * @param num the number of nickels being inputed by the customer
	 */
	public void inputNickels(int num)
	{
		customer_nickels += num;
	}
	/**
	 * takes in the pennies input from the customer and saves it in the class
	 * 
	 * @param num the number of pennies being inputed by the customer
	 */
	public void inputPennies(int num)
	{
		customer_pennies += num;
	}
	/**
	 * for the operator to take out a certain of quarters
	 * 
	 * @param num the number of quarters being taken out
	 */
	public void removeQuarters(int num)
	{
		if(num > quarters)
		{
			System.out.println("You've inputted too high a number. Not enough coin to remove.");
		}
		else
		{
			quarters -= num;
			System.out.println("You have removed " + num + " quarters.");
		}
	}
	/**
	 * for the operator to take out a certain number of dimes
	 * 
	 * @param the number of dimes being taken out
	 */
	public void removeDimes(int num)
	{
		if(num > dimes)
		{
			System.out.println("You've inputted too high a number. Not enough coin to remove.");
		}
		else
		{
			dimes -= num;
			System.out.println("You have removed " + num + " dimes.");
		}
	}
	/**
	 * for the operator to take out a certain number of nickels
	 * 
	 * @param num the number of nickels being taken out
	 */
	public void removeNickels(int num)
	{
		if(num > nickels)
		{
			System.out.println("You've inputted too high a number. Not enough coin to remove.");
		}
		else
		{
			nickels -= num;
			System.out.println("You have removed " + num + " nickels.");
		}
	}
	/**
	 * for the operator to take out a certain number of pennies
	 * 
	 * @param num the number of pennies being taken out
	 */
	public void removePennies(int num)
	{
		if(num > pennies)
		{
			System.out.println("You've inputted too high a number. Not enough coin to remove.");
		}
		else
		{
			pennies -= num;
			System.out.println("You have removed " + num + " pennies.");
		}
	}

	
}

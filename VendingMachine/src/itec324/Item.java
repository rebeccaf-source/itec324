package itec324;
/**
 * The class of the products in the vending machine
 * @author Rebecca Fonseth
 * @version 1.0
 */
public class Item 
{
	public static int item1 = 10;
	public static int item2 = 10;
	public static int item3 = 10;
	public static int item4 = 10;
	public static int item5 = 10;

	
	/**
	 * this method outputs a menu for the customer, showing the code, name, and price of each item
	 */
	public void displayMenu_Customer()
	{
		System.out.println("------------------------------------");
		System.out.println("-------Vending Machine Items--------");
		System.out.println("------------------------------------");
		if(item1 > 0)
		{ 
			System.out.printf("%d  %-25s$%.2f \n", Items.DORITOS.getCode(), Items.DORITOS.getName(), Items.DORITOS.getPrice(Items.DORITOS));
		}
		if(item2 > 0)
		{
			System.out.printf("%d  %-25s$%.2f \n", Items.PEPSI.getCode(), Items.PEPSI.getName(), Items.PEPSI.getPrice(Items.PEPSI));
		}
		if(item3 > 0)
		{
			System.out.printf("%d  %-25s$%.2f \n", Items.GUM.getCode(), Items.GUM.getName(), Items.GUM.getPrice(Items.GUM));
		}
		if(item4 > 0)
		{
			System.out.printf("%d  %-25s$%.2f \n", Items.COKE.getCode(), Items.COKE.getName(), Items.COKE.getPrice(Items.COKE));
		}
		if(item5 > 0)
		{
			System.out.printf("%d  %-25s$%.2f \n", Items.CRACKERS.getCode(), Items.CRACKERS.getName(), Items.CRACKERS.getPrice(Items.CRACKERS));
		}
		System.out.println("------------------------------------");
	}
	/** 
	 * this method outputs a menu for the operator, showing the code, name, price, and quantity of each item
	 */
	public void displayMenu_Operator()
	{ 
		System.out.println("------------------------------------");
		System.out.println("-------Vending Machine Items--------");
		System.out.println("------------------------------------");

		System.out.printf("%-5d%-25s $%.2f   %d \n", Items.DORITOS.getCode(), Items.DORITOS.getName(), Items.DORITOS.getPrice(Items.DORITOS), item1);

		System.out.printf("%-5d%-25s $%.2f   %d \n", Items.PEPSI.getCode(), Items.PEPSI.getName(), Items.PEPSI.getPrice(Items.PEPSI), item2);

		System.out.printf("%-5d%-25s $%.2f   %d \n", Items.GUM.getCode(), Items.GUM.getName(), Items.GUM.getPrice(Items.GUM), item3);

		System.out.printf("%-5d%-25s $%.2f   %d \n", Items.COKE.getCode(), Items.COKE.getName(), Items.COKE.getPrice(Items.COKE), item4);

		System.out.printf("%-5d%-25s $%.2f   %d \n", Items.CRACKERS.getCode(), Items.CRACKERS.getName(), Items.CRACKERS.getPrice(Items.CRACKERS), item5);

		System.out.println("------------------------------------");
	}
	/** 
	 * this method allows the operator and system to change the quantity of an item
	 * 
	 * @param code the three-digit code of the item the user chose
	 * @param num the numer the quantity is changing by
	 */
	public void changeQuantity(int code, int num)
	{
		Items[] items = Items.values();
		for(Items item: items)
		{
			if(item.getCode() == code)
			{
				if(item.getName().equals("Doritos"))
				{
					if((num + item1) > 10)
					{
						System.out.println("Too much stock. Can only have 10 total.");
					}
					else
					{
						item1 += num;
					}
				}
				else if(item.getName().equals("Pepsi"))
				{
					if((num + item2) > 10)
					{
						System.out.println("Too much stock. Can only have 10 total.");
					}
					else
					{
						item2 += num;
					}
				}
				else if(item.getName().equals("Mint Gum"))
				{
					if((num + item3) > 10)
					{
						System.out.println("Too much stock. Can only have 10 total.");
					}
					else
					{
						item3 += num;
					}
				}
				else if(item.getName().equals("Coca Cola"))
				{
					if((num + item4) > 10)
					{
						System.out.println("Too much stock. Can only have 10 total.");
					}
					else
					{
						item4 += num;
					}
				}
				else if(item.getName().equals("Peanut Butter Crackers"))
				{
					if((num + item5) > 10)
					{
						System.out.println("Too much stock. Can only have 10 total.");
					}
					else
					{
						item5 += num;
					}
				}
				else
				{
					System.out.println("Invalid Item Code");
				}
			}
		}
	}

	/**
	 * this sets the initial prices for each item in the vending machine
	 */
	public void setInitialPrices()
	{
		Items[] items = Items.values();
		for(Items item : items)
		{
			if(item.getName().equals("Doritos"))
			{
				item.setPrice(item, 1.5);
			}
			else if(item.getName().equals("Pepsi"))
			{
				item.setPrice(item, 2.0);
			}
			else if(item.getName().equals("Mint Gum"))
			{
				item.setPrice(item, 0.75);
			}
			else if(item.getName().equals("Coca Cola"))
			{
				item.setPrice(item, 2.0);
			}
			else if(item.getName().equals("Peanut Butter Crackers"))
			{
				item.setPrice(item, 1.25);
			}
		}
	}
}

package itec324;
/**
 * Enum class for the products
 * @author Rebecca Fonseth
 * @version 1.0
 */
public enum Items 
{
	
	DORITOS(105, "Doritos"),
	PEPSI(205, "Pepsi"),
	GUM(305, "Mint Gum"),
	COKE(405, "Coca Cola"),
	CRACKERS(505, "Peanut Butter Crackers");
	 
	private String product;
	private int code;
	//each price of the items
	public static double price1;
	public static double price2;
	public static double price3;
	public static double price4;
	public static double price5;
	
	/**
	 * the contructor for the Items enum
	 * @param code the three-digit code that is assigned to each product
	 * @param name the name of each enum value
	 */
	private Items(int code, String name)
	{
		this.product = name;
		this.code = code;
		
	}
	/**\
	 * this is a getter method for the price variable
	 * @param item the item that the price is being asked of
	 * @return the price of the item
	 */
	public double getPrice(Items item)
	{
		
			if(item.getName().equals("Doritos"))
			{
				return price1;
			}
			else if(item.getName().equals("Pepsi"))
			{
				return price2;
			}
			else if(item.getName().equals("Mint Gum"))
			{
				return price3;
			}
			else if(item.getName().equals("Coca Cola"))
			{
				return price4;
			}
			else
			{
				return price5;
			}
	}
	/**
	 * a getter method for the name variable
	 * @return the name of the item
	 */
	public String getName()
	{
		return this.product;
	}
	/**
	 * a getter method for the three-digit code each item has
	 * @return the three-digit code
	 */
	public int getCode()
	{
		return this.code;
	}
	/**
	 * a setter method for the price of each method
	 * @param item the item whose price is being set
	 * @param nprice the new price
	 */
	public void setPrice(Items item, double nprice)
	{
		if(item.getName().equals("Doritos"))
		{
			price1 = nprice;
		}
		else if(item.getName().equals("Pepsi"))
		{
			price2 = nprice;
		}
		else if(item.getName().equals("Mint Gum"))
		{
			price3 = nprice;
		}
		else if(item.getName().equals("Coca Cola"))
		{
			price4 = nprice;
		}
		else if(item.getName().equals("Peanut Butter Crackers"))
		{
			price5 = nprice;
		}
	}
}

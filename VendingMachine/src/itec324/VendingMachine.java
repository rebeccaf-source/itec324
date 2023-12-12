package itec324;
import java.util.Scanner;
/**
 * The main class for starting the vending machine simulation
 * @author Rebecca Fonseth
 * @version 1.0
 */
public class VendingMachine 
{
	private Customer customer;
	public Operator operator;

	/**
	 * Constructor for vending machine class
	 */
	public VendingMachine()
	{
		operator = new Operator();
	}

	/**
	 * the initial login for the vending machine to start the customer mode process
	 */
	public void login()
	{
		System.out.println("Hello. This is the Vending Machine.");
		customer = new Customer();
	} 
	/**
	 * this is the logout to leave the vending machine system and end the simulation
	 */
	public void logout()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you sure you would like to logout? Y/N");
		String ans = scan.next().toUpperCase();
		if(ans.equals("Y"))
		{
			System.out.println("Good-bye!");
			System.exit(0);
		}
		else
		{
			this.login();
		}
	}
}

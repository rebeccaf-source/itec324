package itec324;
/**
 * this is the driver class for Project 4
 * @author Rebecca Fonseth
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Operations op = new Operations();
		System.out.println("Step 1: No output");
		op.insert3x(); //step 1
		System.out.print("Step 2: ");
		op.printForward();// step 2
		System.out.println("Step 3: No output");
		op.insertAdjacents3x_Non6x();//step 3
		System.out.print("Step 4: ");
		op.printForward();//step 4
		System.out.println("Step 5: No output");
		op.insertAdjacents6x();//step 5
		System.out.print("Step 6: ");
		op.printBackward();//step 6
		System.out.println("Step 7: No output");
		op.deleteNon4x();//step 7
		System.out.print("Step 8: ");
		op.printForward();//step 8
		
		

	}

}

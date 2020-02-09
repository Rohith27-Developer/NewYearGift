import java.text.DecimalFormat;
import java.util.*;
public class Calculator {
	 private static DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=null;
		Methods m=new Methods();
		System.out.println("Enter two numbers");
		int a=s.nextInt();
		int b=s.nextInt();
		do
		{
		System.out.println("Enter choice\n1.Add\n2.Subtract\n3.Multiply\n4.Divide");
		int n=s.nextInt();
		switch(n)
		{
		case 1:
			int c=m.Add(a,b);
			System.out.println("Addition of two  numbers:"+c);
			break;
		case 2:
			int d=m.Subtract(a,b);
			System.out.println("Subtraction of two  numbers:"+d);
			break;
		case 3:
			int e=m.Multiply(a,b);
			System.out.println("Multiplication of two  numbers:"+e);
			break;
		case 4:
			double f=m.Divide(a,b);
			String g=df.format(f);
			System.out.println("Division of two  numbers:"+g);
			break;
		default:
			System.out.println("Enter correct choice");
		}
		System.out.println("Do you want to continue(y/n)?");
		str=s.next();
		}while(str.equalsIgnoreCase("y"));
     System.out.println("Process Stopped");
	}

}

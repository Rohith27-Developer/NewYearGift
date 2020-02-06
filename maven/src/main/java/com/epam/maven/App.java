package com.epam.maven;
import java.util.*;
public class App 
{
	public static HashMap<String,Integer> sortByValue(HashMap<String,Integer> hm) 
	{ 
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(hm.entrySet()); 
		Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() { 
			public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) 
			{ 
				return (o1.getValue()).compareTo(o2.getValue()); 
			} 
		}); 
		HashMap<String, Integer> temp = new LinkedHashMap<String,Integer>(); 
		for (Map.Entry<String, Integer> aa : list) { 
			temp.put(aa.getKey(), aa.getValue()); 
		} 
		return temp; 
	} 
	public static void main( String[] args )
	{
		Scanner s=new Scanner(System.in);
		TreeMap tm=new TreeMap();
		System.out.println("Enter the total no of children");
		int n=s.nextInt();
		String name=null;
		int candies=0,sweets=0;
		Children obj[]=new Children[n];
		for(int i=0;i<n;i++)
		{
			obj[i]=new Children();
			System.out.println("Enter the children's name");
			name=s.next();
			System.out.println("Enter the number of candies");
			candies=s.nextInt();
			System.out.println("Enter the number of sweets");
			sweets=s.nextInt();
			obj[i].setName(name);
			obj[i].setNc(candies);
			obj[i].setNs(sweets);
			obj[i].setTotalqty(candies+sweets);
		}
		int q=candies+sweets;
		String str[]=new String[q];
		int a[]=new int[q];
		System.out.println("Enter chocolate names:\n");
		s.nextLine();
		for(int i=0;i<n;i++){
			str[i]=s.nextLine();
			a[i]=str[i].length();
			tm.put(str[i],a[i]);
			System.out.println("The cost of "+str[i]+" is "+a[i]);
		}
		System.out.println("\nSelect the sweet names from the list:\n1.Kaju Bharfi\n2.Palkova\n");
		String s1=null,s2=null;
		int f[]=new int[n];
		KajuBharfi k=new KajuBharfi();
		Palkova p=new Palkova();
		for(int i=0;i<n;i++) {
			int ch=s.nextInt();		
			switch(ch)
			{
			case 1:
				s1=k.sweetName();
				f[i]=k.sweetPrice();
				break;
			case 2:
				s2=p.sweetName();
				f[i]=p.sweetPrice();
				break;
			default:
				System.out.println("Incorrect choice");
			}
		}
		System.out.println("Name "+"   "+"Number of candies "+"   "+"Number of sweets");
		for(int i=0;i<n;i++)
		{
			System.out.println(obj[i].getName()+"\t"+
					obj[i].getNc()+"\t\t\t"+
					obj[i].getNs()+" ");
		}
		System.out.println("---------------------------------------------\n");
		System.out.println("Name  "+"   "+"Total price of chocolates"+"   "+"Total price of sweets");
		int price[]=new int[n];
		int z=0;
		int sum[]=new int[n];
		for(int i=0;i<n;i++)
		{
			z=(int) tm.get(str[i]);
			price[i]=(int) tm.get(str[i]);
			System.out.println(obj[i].getName()+"\t\t"+
					obj[i].getNc()*price[i]+"\t\t\t"+
					obj[i].getNs()*f[i]+" ");
			sum[i]=obj[i].getNc()*z+obj[i].getNs()*f[i];
			obj[i].setTotalcost(sum[i]);
		}
		System.out.println("---------------------------------------------\n");
		String choi="y";
		do
		{
			System.out.println("Enter choice to sort the candies:");
			System.out.println("1.By name\n2.By Price\n3.By Quantity");
			int choice=s.nextInt();
			switch(choice)
			{
			case 1:
				TreeMap<String,Integer> tm1=new TreeMap<String,Integer>();
				for(int i=0;i<n;i++)
					tm1.put(obj[i].getName(),obj[i].getTotalcost());
				System.out.println(tm1);
				break;
			case 2:
				HashMap<String,Integer> tm2=new HashMap<String,Integer>();
				for(int i=0;i<n;i++)
					tm2.put(obj[i].getName(),obj[i].getTotalcost());
				Map<String,Integer>hm1=sortByValue(tm2); 
				System.out.println(hm1);
				break;
			case 3:
				StringBuilder sb = new StringBuilder();
				HashMap<String,Integer> tm3=new HashMap<String,Integer>();
				for(int i=0;i<n;i++)
					tm3.put(obj[i].getName(),obj[i].getTotalqty());
				Map<String, Integer> hm2 = sortByValue(tm3); 
				System.out.println(hm2);
				break;
			default:
				System.out.println("Incorrect choice");
			}
			System.out.println("Do you want to sort again y/n?");
			choi=s.next();
		}while(choi.equalsIgnoreCase("y"));
	}
}





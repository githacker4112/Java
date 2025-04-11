package FileHandelling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEx {
	public static void create(String fname) throws IOException
	{
		File f=new File(fname);
		if(f.createNewFile())
		{
			System.out.println(fname+" is created successfully..");
		}
		else
		{
			System.out.println(fname+" is already exists..");
		}
		
	}
	public static void delete(String fname) throws IOException
	{
		File f=new File(fname);
		
		if(f.delete())
		{
			System.out.println(fname+" is Deleted successfully..");
		}
		else
		{
			System.out.println(fname+" is Not found..");
		}
		
	}
	public static void writeToFile(String fname) throws IOException
	{
		File f=new File(fname);
		try {
			if(f.exists())
			{
			FileWriter writer=new FileWriter(f);
			writer.write("Bye...");
			System.out.println("successfully written on "+fname);
			writer.close();
			}
			else
			{
				System.out.println(fname+" does not exists..");
			}
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
	}
	

	public static void readFromFile(String fname) throws IOException
	{
		FileReader f=new FileReader(fname);
		try {
		
				BufferedReader br=new BufferedReader(f);
				String data;
				System.out.println("Reading from file");
				while((data=br.readLine())!=null)
				{
					System.out.println(data);
				}
				
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
	}
	
	
	
	
public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter The Filename");
	String filename=sc.next();
	//create(filename);
	//delete(filename);
	//writeToFile(filename);
	//readFromFile(filename);
}
}

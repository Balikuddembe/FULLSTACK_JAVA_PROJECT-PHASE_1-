package com_lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe 
{
	public static final String projectfilesPath="D:\\FSJ_SIMPLILEARN\\LockedMeFiles";
	static final String errorMessage="Some error Ocurred.Please Contact:admin@lockedme.com";
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int ch;
		try
		{
		do
		{
			
			displayMenu();
			System.out.println("Enter your choice");
			ch = Integer.parseInt(sc.nextLine());
			
			switch(ch)
			{
			case 1:getAllFiles();
			break;
			
			case 2:createFiles();
			break;
			
			case 3:deleteFiles();
			break;
			
			case 4:searchFiles();
			break;
			
			//using exit()method of the System class to end a java program
			case 5:System.exit(0);
			break;
		
			default:System.out.println("Invalid Option.Please Try again:");
			break;
			}
		}
		while(ch>0);
		sc.close();
		
		}catch(Exception Ex)
		{
			System.out.println("Please enter the right option");
		}
	}
	public static void displayMenu()
	{
		System.out.println("=========================Welcome To ====================================");
		System.out.println("\t\tLockedMe.com Application");
		System.out.println("\t\tDeveloped by:Balikuddembe Emmanuel\n");
		System.out.println("\tBelow are the Business Level Operations\n");
		System.out.println("\t\t1.Display All the Files");
		System.out.println("\t\t2.Add a New File");
		System.out.println("\t\t3.Delete a File");
		System.out.println("\t\t4.Search a File");
		System.out.println("\t\t5.Exit");
	}
	/**
	 * This method will return all the files from the project directory
	 */
	public static void getAllFiles()
	{
		System.out.println("These are the files created in the project directory:\n");
		try
		{
		//Creating a File object for directory
		
	      File directoryPath = new File(projectfilesPath);
	      
	      //List of all files and directories
	      
	      File filesList[] = directoryPath.listFiles();
	      
	      if(filesList.length==0) 
	    	  System.out.println("No files exist in the directory");
	      else 
	      {
	    	  for(var l:filesList)
	    	  {
	    	  System.out.println(l.getName());
	    	  }
	       }
	     }
		catch(Exception ex)
		{
		System.out.println(errorMessage);
		}
	}
	      
	/**
	 * This method will create files in the project directory
	 */
	public static void createFiles()
	{
		try
		{
			String fileName;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the file name to create");
			fileName = sc.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file");
			
			linesCount=Integer.parseInt(sc.nextLine());
			
			FileWriter fw = new FileWriter(projectfilesPath + "\\"+ fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the file line");
				fw.write(sc.nextLine());
			}
			System.out.println("File created successfully");
			
			fw.close();
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	/**
	 * This method will delete the file name
	 */
	public static void deleteFiles()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
		String fileName;
		System.out.println("Enter the file name to be deleted:");
		fileName = sc.nextLine();
		File file = new File(projectfilesPath + "\\"+ fileName);
		if(file.exists())
		{
			file.delete();
		System.out.println("File deleted successfully");
		}
		else 
			{
				System.out.println("File does not exist");
			}
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	/**
	 * This method will search files from the directory
	 */
	
	public static void searchFiles()
	{
		Scanner sc = new Scanner(System.in);
		try
		{
		String fileName;
		System.out.println("Enter the file name to be searched:");
		fileName = sc.nextLine();
		
		File file = new File(projectfilesPath);
		File filesList[] = file.listFiles();
		
		LinkedList<String> filenames = new LinkedList<String>();
		
		for(var l:filesList)
			filenames.add(l.getName());
		if(filenames.contains(fileName))
			System.out.println("File is available");
		else
		
			System.out.println("File is not available");
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
}

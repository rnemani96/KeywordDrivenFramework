package exectionEngine;

import java.lang.reflect.Method;
import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {
	
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;

	public static Method method[];
 
	//Here we are instantiating a new object of class 'ActionKeywords'
	public DriverScript() throws NoSuchMethodException, SecurityException
	{
		actionKeywords = new ActionKeywords();
		
		method = actionKeywords.getClass().getMethods();
	}

	public static void main(String[] args) throws Exception {
		
	/*	String sPath =".\\dataEngine\\DataEngine.xlsx";
		
		ExcelUtils.setExcelFile(sPath, "Sheet1");
		for(int iRow= 0;iRow<=9;iRow++)
		{
			String sActionsKeyword = ExcelUtils.getCellData(iRow, 3);
			if(sActionsKeyword.equalsIgnoreCase("openbrowser"))
			{
				ActionKeywords.openBrowser();
			}
			else if(sActionsKeyword.equalsIgnoreCase("navigate"))
			{
				ActionKeywords.navigate();
			}
			else if(sActionsKeyword.equalsIgnoreCase("click_MyAccount"))
			{
				ActionKeywords.click_MyAccount();
			}
			else if(sActionsKeyword.equalsIgnoreCase("input_Username"))
			{
				ActionKeywords.input_Username();
			}
			else if(sActionsKeyword.equalsIgnoreCase("input_Password"))
			{
				ActionKeywords.input_Password();
			}
			else if(sActionsKeyword.equalsIgnoreCase("click_Login"))
			{
				ActionKeywords.click_Login();
			}
			else if(sActionsKeyword.equalsIgnoreCase("waitFor"))
			{
				ActionKeywords.waitFor();
			}
			else if(sActionsKeyword.equalsIgnoreCase("closeBrowser"))
			{
				ActionKeywords.closeBrowser();
			}
		}*/
		
		
	 
	   
	    	//Declaring the path of the Excel file with the name of the Excel file
	    	String sPath =  Constants.Path_TestData     //".//dataEngine//DataEngine.xlsx";
	 
	    	//Here we are passing the Excel path and SheetName to connect with the Excel file
	        //This method was created in the last chapter of 'Set up Data Engine' 		
	    	ExcelUtils.setExcelFile(sPath, "Test Steps");
	 
	    	//Hard coded values are used for Excel row & columns for now
	    	//In later chapters we will use these hard coded value much efficiently
	    	//This is the loop for reading the values of the column 3 (Action Keyword) row by row
			//It means this loop will execute all the steps mentioned for the test case in Test Steps sheet
	    	for (int iRow = 1;iRow <= 9;iRow++){
			    //This to get the value of column Action Keyword from the excel
	    		sActionKeyword = ExcelUtils.getCellData(iRow, 3);
	            //A new separate method is created with the name 'execute_Actions'
				//You will find this method below of the this test
				//So this statement is doing nothing but calling that piece of code to execute
	    		execute_Actions();
	    		}
	    	}
		
		//This method contains the code to perform some action
		//As it is completely different set of logic, which revolves around the action only,
		//It makes sense to keep it separate from the main driver script
		//This is to execute test step (Action)
	    private static void execute_Actions() throws Exception {
			//This is a loop which will run for the number of actions in the Action Keyword class 
			//method variable contain all the method and method.length returns the total number of methods
			for(int i = 0;i < method.length;i++){
				//This is now comparing the method name with the ActionKeyword value got from excel
				if(method[i].getName().equals(sActionKeyword)){
					//In case of match found, it will execute the matched method
					method[i].invoke(actionKeywords);
					//Once any method is executed, this break statement will take the flow outside of for loop
					break;
					}
				}
			}
		
		
		


}

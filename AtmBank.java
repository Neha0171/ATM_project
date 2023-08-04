package atmDb;
import java.sql.SQLException;
import java.util.Scanner;


public class AtmBank  {
    Scanner sc= new Scanner(System.in);
    ConnectToDataBase ctD;

   public static void main (String[]args)throws SQLException{
	   {
        AtmBank at1 = new AtmBank();
    	at1.login_Customer();
    }}
    //constructor
    public AtmBank() throws SQLException{
        
            //we're creating objects
            ctD = new ConnectToDataBase(); //we are creating objects

        }


        public void login_Customer()throws SQLException{ 
        
        	System.out.println("enter customer name: ");
        	String name=sc.next();
        	System.out.println("enter customer password- ");
        	String password=sc.next();
        	boolean flag=ctD.login(name,password);
        	if(flag)
        	{
        		System.out.println("Login Sucessfull!");
        		display_Menu();
        	}
        	else
        	{
        		System.out.println("Login Failed!, Try AGAIN!");
        		login_Customer();
        	}
        }
        public void display_Menu() throws SQLException{
        
        	System.out.println("-----------Menu----------");
        	System.out.println("1. Check Balance.");
        	System.out.println("2. Withdraw Money.");
        	System.out.println("3. Deposit Money.");
        	System.out.println("4. Logout.");
        	System.out.println("--------------------------");
        	System.out.println("Select your choice: ");
        	int choice=sc.nextInt();
        	switch(choice)
        	{
        	case 1: check_Balance();
        	break;
        	case 2: withdraw_Money();
        	break;
        	case 3: deposit_Money();
        	break;
        	case 4: log_out();
        	break;
    	default: System.out.println("please select a valid choice!");
    	
        	}
        }
        
        
        public void check_Balance() throws SQLException{
        {
        	int balance=ctD.getBalance(ctD.CusotmerId);
        	System.out.println("your total balance in your account is: "+balance);
        	display_Menu();
        }}
        public void withdraw_Money() throws SQLException{
        {
        	System.out.println("enter amount you want to withdraw: ");
        	int amount =sc.nextInt();
        	boolean flag=ctD.withDrawMoney(ctD.CusotmerId,amount);
        	if(flag)
        	{
        		System.out.println("take your money: "+amount);
        		display_Menu();
        	}
        	else
        	{
        		System.out.println("not enough money in your account!!");
        		display_Menu();
        	}
        }}
        public void deposit_Money() throws SQLException{
        
        	System.out.println("Enter the amount to Deposit: ");
    		int amount=sc.nextInt();
    		boolean flag=ctD.depositMoney(ctD.CusotmerId, amount);
    		if(flag) {
    			System.out.println("Amount deposited Sucessfully");
    			display_Menu();
    		}
        }
        public void log_out() throws SQLException
        {
        	System.out.println("logout successfully!");
        	System.out.println(" ");
        	System.out.println(" ");
        	System.out.println("-------------------------");
        //	System.exit(0);
        	login_Customer();
        	
        }
        /*public static void main(String[]args)throws SQLException{
        {
        
        }}*/
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
		
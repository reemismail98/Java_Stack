package BankAccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber="";
	private double checkingBalance=0.0;
	private double savingsBalance=0.0;
	private  static int numberOfAccount=0;
	private  static double totalAccountOfMoney=0;
	public BankAccount() {
		this.accountNumber=randomDigits();
		numberOfAccount++;
		}

	private String randomDigits() {
		String temp="";
     Random r=new Random(); 
     for(int i=0;i<10;i++) {
    	 temp+=r.nextInt(0+9);
     }
     return temp;
   }
	
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	
	public static int getNumberOfAccount() {
		return numberOfAccount;
	}
	public  double getCheckingBalance() {
		return checkingBalance;
	}
	public  double getSavingsBalance() {
		return savingsBalance;
	}
	
	public void deposit (String account,double money) {
		if(account == "checkingBalance") {
			this.checkingBalance +=money;}
		else if(account =="savingsBalance") {
			this.savingsBalance +=money;	
			}
		totalAccountOfMoney+=money;
		
	}
	public static double getTotalAmount() {
		return totalAccountOfMoney;
	}
    public  void getWithdraw(String account,double money) {
    		if(account == "checkingBalance" && money<=totalAccountOfMoney) {
    			this.checkingBalance -=money;
    			totalAccountOfMoney-=money;
    		}
    		else if(account =="savingsBalance" && money<=totalAccountOfMoney) {
    			this.savingsBalance -=money;
    			totalAccountOfMoney-=money;
    			}
    		else {
    			System.out.println("withdraw money greather than Total Account Money");
    		}
    		
    	}
	  
  
	}


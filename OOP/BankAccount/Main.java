package BankAccount;

public class Main {

	public static void main(String[] args) {
    BankAccount b=new BankAccount();
    System.out.println(b.getAccountNumber());
    System.out.println(BankAccount.getNumberOfAccount());
    System.out.println(b.getCheckingBalance());
    System.out.println(b.getSavingsBalance());
    b.deposit("checkingBalance", 1000);
    b.deposit("savingsBalance", 1000);
    System.out.println("total Account Of Money After Deposit: "+b.getTotalAmount());
    b.getWithdraw("checkingBalance", 100);
    b.getWithdraw("savingsBalance", 400);
    System.out.println("total Account Of Money After Withdraw: "+b.getTotalAmount());


    


    

}}

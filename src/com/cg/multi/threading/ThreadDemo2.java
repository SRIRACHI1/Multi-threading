package com.cg.multi.threading;

class BankCustomer
{
	double amt =1000;
	synchronized void withdraw(double amount)
	{
		System.out.println(" I am gng to wwithdraaw");
		if(this.amt<amount)
		{
			System.out.println("less balance , kindly deposit");
		}
		try
		{
			wait();
		}catch(Exception e)
		{
			
		}
		this.amt=this.amt-amount;
		System.out.println(this.amt + " "+"remining");
		
	}
	
	synchronized public void deposit(double amount)
	{
		System.out.println("depositing....");
		this.amt=this.amt+amount;
		System.out.println("deposited");
		notify();
	}
}

class AccountHolder1 extends Thread
{
	BankCustomer customer;
	
	public AccountHolder1(BankCustomer customer)
	{
		this.customer=customer;
	}
	public  void run()
	{
		customer.withdraw(15000.00);
	}
}


public class ThreadDemo2 {
	public static void main(String[] args) {
		
		
		BankCustomer cust = new BankCustomer();
		AccountHolder1 ac1=new AccountHolder1(cust);
		ac1.start();
		/*new Thread()
		{
			public void run()
			{
				cust.withdraw(15000.0);
			}
		}.start();*/
		
		new Thread()
		{
			public void run() 
			{
				cust.deposit(5000.0);
			}
		}.start();
		
	}

}
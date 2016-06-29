package com.swadesibank.transaction.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swadesibank.transaction.bean.Account;
import com.swadesibank.transaction.service.AccountService;

public class SawdesiBank {

	public static void main(String[] args) {
		
		ApplicationContext appContext=new ClassPathXmlApplicationContext("spring-config.xml");
		AccountService accountService=appContext.getBean("accountService",AccountService.class);
		
		//Create Account:
		Account anilkumar=new Account();
		anilkumar.setAccountno(10013);
		anilkumar.setBalance(123450.0);

		Account rajivverma=new Account();
		rajivverma.setAccountno(10014);
		rajivverma.setBalance(1250.0);
		
		Account priyagill=new Account();
		priyagill.setAccountno(10015);
		priyagill.setBalance(35000.0);
		
		/*accountService.createAccount(anilkumar);
		accountService.createAccount(rajivverma);
		accountService.createAccount(priyagill);*/
		
		//Transferring funds..
		Account fromAccount=null;
		Account toAccount=null;
		
		//----------------------------User Input ------------------
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Debit Account No:");
		Integer debitAccount=scan.nextInt();
		System.out.println("Enter credit Account No:");
		Integer creditAccount=scan.nextInt();
		System.out.println("Enter Transfer amount:");
		Double transferAmount=scan.nextDouble();
		//---------------------------------------------------------
		
		/*fromAccount=accountService.getAccount(debitAccount);
		toAccount=accountService.getAccount(creditAccount);
		
		accountService.fundTransfer(fromAccount, toAccount, transferAmount);
		
		fromAccount=accountService.getAccount(debitAccount);
		toAccount=accountService.getAccount(creditAccount);
		
		accountService.printAccountInfo(fromAccount, toAccount);*/
		
		
		fromAccount=accountService.getAccount(debitAccount);
		toAccount=accountService.getAccount(creditAccount);
		try {
			accountService.fundTransferWithException(fromAccount, toAccount, transferAmount);
		} catch (Exception e) {
			System.out.println("Fund tranfer failed..transaction rollbacked by transaction manager..");
			e.printStackTrace();
		}
		
		fromAccount=accountService.getAccount(debitAccount);
		toAccount=accountService.getAccount(creditAccount);
		
		accountService.printAccountInfo(fromAccount, toAccount);
		
	}

}

//ATM INTERFACE IN JAVA

import java.util.*;
import java.io.*;

class atmaccount
{
  float balance = 0f;
  String name, user_name, password;

  int no_of_transactions = 0;

  String transaction_history = "";

  public void details ()
  {
    Scanner input = new Scanner (System.in);

      System.out.println ("Enter your name: ");

      this.name = input.nextLine ();

      System.out.println ("Enter your user_name: ");

      this.user_name = input.nextLine ();

      System.out.println ("Enter your password: ");

      this.password = input.nextLine ();

      System.out.println ("\n----Registration completed successfuly!----");
  }


  public boolean login_check ()
  {
    boolean logined = false;

    Scanner input = new Scanner (System.in);


    while (!logined)
      {
	System.out.println ("Enter your username: ");

	String username_check = input.nextLine ();

	if (username_check.equals (user_name))
	  {
	    while (!logined)
	      {
		System.out.println ("Enter your password: ");

		String password_check = input.nextLine ();

		if (password_check.equals (password))
		  {
		    System.out.println ("\n-You have logined successfully--");

		    logined = true;
		  }
		else

		  System.out.println ("lncorrect Password.");
	      }
	  }
	else

	  System.out.println ("Username not Registered.");
      }
    return logined;
  }

  public void withdraw ()
  {
    System.out.println ("Enter the amount to withdraw: ");

    Scanner input = new Scanner (System.in);

    float amount = input.nextFloat ();

    if (balance >= amount)
      {
	no_of_transactions++;
	balance -= amount;

	System.out.println ("You have withdrawn " + amount +
			    " successfully!");

	String total_history = "Withdrawed amount was: " + amount;
	transaction_history = transaction_history.concat (total_history);
      }
    else

      System.out.println ("Sorry! No balance available");
  }

  public void deposit ()
  {
    System.out.println ("Note:You can deposit maximum 50000 at a time");

    System.out.println ("Enter the amount to deposit: ");

    Scanner input = new Scanner (System.in);

    float amount = input.nextFloat ();
    if (amount <= 50000)
      {
	no_of_transactions++;

	balance += amount;

	System.out.println ("You have deposited " + amount +
			    " successfully!!");

	String total_history = "Deposited amount is:" + amount;

	transaction_history = transaction_history.concat (total_history);
      }
    else


      System.out.println ("Amount limit over 25000(should be <= 25000)");
  }

  public void transfer ()
  {
    System.out.
      println ("Enter the name to whom to transfer for verification: ");

    Scanner input = new Scanner (System.in);

    String to_transfer_name = input.nextLine ();

    System.out.println ("Enter the amount to transfer: ");
    float amount = input.nextFloat ();

    if (balance >= amount)
      {
	if (amount <= 50000)

	  {
	    no_of_transactions++;

	    balance -= amount;

	    System.out.println ("You have transfered " + amount + " to " +
				to_transfer_name + " successfully!!");

	    String total_history =
	      "You sent " + amount + " to " + to_transfer_name;
	    transaction_history = transaction_history.concat (total_history);
	  }
	else
	  System.out.println ("Amount limit over 25000(should be <= 25000)");
      }
    else

      System.out.println ("Sorry!! No balance available");
  }

  public void transactionsHistory ()
  {
    if (no_of_transactions == 0)

      System.out.println ("No transactions were done!");

    else

      System.out.println ("Your transactions history list:-  " +
			  transaction_history);

  }

  public void balance_check ()
  {
    System.out.println ("Your available balance is: " + balance);
  }
}

public class Main
{
  public static int enter (int limit)
  {
    int inp = 0;
    boolean flag = false;
    while (!flag)
      {
	Scanner input = new Scanner (System.in);
	  inp = input.nextInt ();
	  flag = true;
	if (flag && inp > limit || inp < 0)
	  {
	    System.out.println ("Choose the number between 1 to " + limit);
	    flag = false;

	  }
      }
    return inp;
  }

  public static void main (String args[])
  {
    Scanner input = new Scanner (System.in);
    System.out.println ("----ATM INTERFACE----");
    System.out.println ("1.Register yourself\n2.Exit");
    System.out.println ("Enter your choice:-");
    int choice = enter (2);
    if (choice == 1)
      {
	atmaccount ac = new atmaccount ();
	ac.details ();
	while (true)
	  {
	    System.out.println ("1.Login\n2.Exit");
	    System.out.println ("Enter your choice:- ");

	    int c = enter (2);
	    if (c == 1)
	      {
		if (ac.login_check ())
		  {
		    System.out.println ("\n\n*---- WELCOME BACK " + ac.name +
					"-----*");

		    boolean isFinish = false;
		    while (!isFinish)
		      {
			System.out.
			  println
			  ("1.Deposit\n2.Withdraw\n3.Transfer\n4.Balance Amount\n5.Transaction History\n6.Exit");
			System.out.println ("Enter your choice:- ");
			int ch = enter (61);
			switch (ch)
			  {
			  case 1:
			    {
			      ac.deposit ();
			      break;

			    }
			  case 2:
			    {
			      ac.withdraw ();

			      break;
			    }
			  case 3:
			    {
			      ac.transfer ();

			      break;
			    }
			  case 4:
			    {
			      ac.balance_check ();

			      break;

			    }

			  case 5:
			    {
			      ac.transactionsHistory ();

			      break;
			    }
			  case 6:
			    {
			      System.out.println ("Thankyou " + ac.name +
						  " for using our service!");

			      System.exit (0);
			      break;
			    }
			  }
		      }
		  }
	      }
	    else
	      {
		System.out.println ("Thankyou " + ac.name +
				    " Have a nice day!!!!");
		System.exit (0);
	      }
	  }
      }
    else
      {
	System.out.println ("Thankyou Have a nice day!!!!");
	System.exit (0);
      }
  }
}

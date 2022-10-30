import java.util.Scanner;

public class NumberGuessing
{
public static void main(String args[])
{
int no_of_attempts=5;

int input_number;

Scanner inputScanner = new Scanner(System.in);

int computer_number = (int) (100 * Math.random()) + 1;

System.out.println("Number should in between 1 to 100 only. You will get 5 trials to guess a right number.\n----Best of Luck----");

int i;
for(i=0;i<no_of_attempts;i++)
{
System.out.println("Guess the number:");

input_number=inputScanner.nextInt();

if(input_number==computer_number)
{
System.out.println("You Won! The number you guessed is right.");

break;
}
else if(computer_number>input_number && i!=no_of_attempts-1)
{
System.out.println("The number is greater than "+input_number);
}
else if(computer_number<input_number && i!=no_of_attempts-1)
{
System.out.println("The number is less than "+input_number);
}
}
if(i==no_of_attempts)
{
System.out.println("Your all attempts are ended.  The right number was: "+computer_number);
}
}
}




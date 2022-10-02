//Author: Logan Markley
//Description: Craps Game WITH SINGLE ROLL BETS
//Date Last Edited: 3/5/18

import java.text.*;
import java.util.*;
public class Markley_CrapsOPTIONAL
{
    static Scanner s = new Scanner(System.in);
    static Random r = new Random(); 

    static int money;
    static int bet;
    static int singlerollbetmoney;
    static int engageroll; //just to see if they press 1 to roll the dice

    static int firstroll; 
    static int secondroll;
    static int followingroll1;
    static int followingroll2;

    static int startpoints;
    static int rolltotal;
    static int thePOINT;

    static int srbplaycompare;
    static int srbplaycompare2;
    static int srbchoice;
    static int srbchoice2;

    public static void main (String args[])
    {
        System.out.println("Welcome to Craps! How much money do you want to cash in?");
        money = s.nextInt();
        System.out.println();

        bet();
    }

    public static void bet ()
    {
        System.out.println("You currently have: $"+money);
        System.out.println("How much do you want to bet?");
        bet = s.nextInt();

        if ((bet > money) || (bet <= 0)) //checks to see if user bet more than they have or if they bet $0 or less
        {
            System.out.println("You can't bet that amount, try again");
            bet();
        }

        System.out.println();

        singlerollbets1();
    }

    public static void singlerollbets1 ()
    {
        String srbplaychoice;           
        String srbplaychoicecompare = "y";

        s.nextLine();

        System.out.println("Would you like to place any single roll bets? (Y/N)");
        srbplaychoice=s.nextLine();

        srbplaycompare=srbplaychoice.compareToIgnoreCase(srbplaychoicecompare);
        if (srbplaycompare == 0)
        {
            System.out.println("What type of single roll bet would you like to place? \n (1 for: any 7) \n (2 for: any craps) \n (3 for: a 2) \n (4 for: a 3) \n (5 for: a 11) \n (6 for: a 12)");
            srbchoice=s.nextInt();
            if (srbchoice > 6 || srbchoice < 1)
            {
                System.out.println("That is not a valid bet number, try again");
                singlerollbets1();
            }
            System.out.println("How much would you like to bet on this single roll?");
            singlerollbetmoney=s.nextInt();

            if (singlerollbetmoney > money)
            {
                System.out.println("You cannot bet more money than you have! \n Please bet again:");
                singlerollbetmoney=s.nextInt();
                if (singlerollbetmoney > money)
                {
                    System.out.println("You cannot bet more money than you have! \n Please bet again:");
                    singlerollbetmoney=s.nextInt();
                }
            }
            
            roll();
        }

        System.out.println("Alright, proceeding to normal Craps ...");
        roll();
    }

    public static void roll ()
    {
        

        System.out.println("Press 1 to roll the dice...");
        engageroll = s.nextInt();

        if (engageroll != 1) //if they did not press 1, they get sent to roll again
        {
            System.out.println();
            roll();
        }

        try {
            Thread.sleep(2000);                 //2 second delay
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        startpointstotal(); 

    }

    public static void startpointstotal ()
    { 
        firstroll = r.nextInt(6)+1; //randomizes the first die
        secondroll = r.nextInt(6)+1; //randomizes the second die

        startpoints = firstroll + secondroll; //their point total
        System.out.println();
        System.out.println("The dice landed on "+firstroll+" and "+secondroll+", for a total of "+startpoints+".");

        try {
            Thread.sleep(2000);                 //2 second delay
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        if (srbplaycompare == 0)
        {   
            if (srbchoice == 1)
            {
                if (startpoints == 7)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 4);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 2)
            {
                if ( (startpoints == 2) || (startpoints == 3) || (startpoints == 12) )
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 7);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 3)
            {
                if (startpoints == 2)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 30);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 4)
            {
                if (startpoints == 3)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 15);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 5)
            {
                if (startpoints == 11)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 15);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 6)
            {
                if (startpoints == 12)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 30);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
        }

        if ( (startpoints ==  7) || (startpoints == 11) ) //see if they won on come-out roll
        {
            System.out.println("Congratulations! You have won on the come-out roll!");
            money = money + bet; //adds their bet to their money
            System.out.println("You now have: $"+money);
            again();
        }
        if ( (startpoints ==  2) || (startpoints == 3) || (startpoints == 12) ) //see if they lost on the come-out roll
        {
            System.out.println("Sorry! You have lost on the come-out roll!");
            money = money - bet; //subtracts their bet from their money
            System.out.println("You now have: $"+money);
            again();
        }

        thePOINT = startpoints; //thePOINT is the variable that checks to see if the user wins on the following rolls
        singlerollbets2();
    }

    public static void singlerollbets2 ()
    {
        String srbplaychoice2;           
        String srbplaychoicecompare2 = "y";

        s.nextLine();

        System.out.println("Would you like to place any single roll bets? (Y/N)");
        srbplaychoice2=s.nextLine();

        srbplaycompare2=srbplaychoice2.compareToIgnoreCase(srbplaychoicecompare2);
        if (srbplaycompare2 == 0)
        {
            System.out.println("What type of single roll bet would you like to place? \n (1 for: any 7) \n (2 for: any craps) \n (3 for: a 2) \n (4 for: a 3) \n (5 for: a 11) \n (6 for: a 12)");
            srbchoice2=s.nextInt();
            if (srbchoice > 6 || srbchoice < 1)
            {
                System.out.println("That is not a valid bet number, try again");
                singlerollbets2();
            }
            System.out.println("How much would you like to bet on this single roll?");
            singlerollbetmoney=s.nextInt();

            if (singlerollbetmoney > money)
            {
                System.out.println("You cannot bet more money than you have! \n Please bet again:");
                singlerollbetmoney=s.nextInt();
                if (singlerollbetmoney > money)
                {
                    System.out.println("You cannot bet more money than you have! \n Please bet again:");
                    singlerollbetmoney=s.nextInt();
                }
            }
            continueplay();
        }

        System.out.println("Alright, continuing play ...");
        continueplay();
    }

    public static void continueplay ()
    {
        

        System.out.println();
        System.out.println("Press 1 to roll the dice again...");
        engageroll = s.nextInt();

        if (engageroll != 1) //if they don't press 1, they roll again
        {
            System.out.println();
            continueplay();
        }

        try {
            Thread.sleep(2000);                 //2 second delay
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        followingroll1 = r.nextInt(6)+1;
        followingroll2 = r.nextInt(6)+1;
        rolltotal = followingroll1 + followingroll2;

        System.out.println("The dice landed on "+followingroll1+" and "+followingroll2+", for a total of "+rolltotal+".");
        System.out.println();

        if (srbplaycompare == 0)
        {   
            if (srbchoice == 1)
            {
                if (startpoints == 7)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 4);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 2)
            {
                if ( (startpoints == 2) || (startpoints == 3) || (startpoints == 12) )
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 7);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 3)
            {
                if (startpoints == 2)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 30);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 4)
            {
                if (startpoints == 3)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 15);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 5)
            {
                if (startpoints == 11)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 15);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
            if (srbchoice == 6)
            {
                if (startpoints == 12)
                {
                    System.out.println("Congratulations! You have successfully won the single roll bet!");
                    money = money + (singlerollbetmoney * 30);
                    System.out.println("You now have: $"+money);
                }
                else
                {
                    System.out.println("Sorry! You have lost the single roll bet!");
                    money = money - singlerollbetmoney;
                    System.out.println("You now have: $"+money);
                }
            }
        }

        if (rolltotal == thePOINT) //if the total that they get matches their point they rolled earlier, they win
        {
            System.out.println("Congratulations you have won!!");
            money = money + bet;
            System.out.println("You now have: $"+money);
            again();
        }
        if (rolltotal == 7) //if the total that they get matches 7, they lose
        {
            System.out.println("Sorry, You have lost!");
            money = money - bet;
            System.out.println("You now have: $"+money);
            again();
        }


        try {
            Thread.sleep(2000);                 //2 second delay
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        continueplay(); //this restarts this method making a loop until 1 of the 2 if statements above are used
    }

    public static void again ()
    {
        String moneychoice;
        String moneychoicecompare = "y";
        s.nextLine();

        if (money == 0) //this if statement checks to see if the user has run out of money and asks if they would like to add in more money
        {
            System.out.println("You have run out of money! Would you like to deposit more money? (Y/N)");
            moneychoice = s.nextLine();
            int moneycompare=moneychoice.compareToIgnoreCase(moneychoicecompare); //compares what the user entered above to the letter "y" 
            if ( moneycompare == 0 ) //this checks to see if their chose yes and if they did then it restarts the program and asks them how much money they would like to put in
            {
                System.out.println("Ok, restarting...");
                try {
                    Thread.sleep(3000);                 //2 second delay
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                main(null);
            }
            else
            {
                System.out.println("Ok, bye!");
                System.exit(0);
            }
        }

        String againchoice;           
        String againchoicecompare = "y";

        System.out.println("Would you like to play again?? (Y/N)");
        againchoice = s.nextLine();

        int compare=againchoice.compareToIgnoreCase(againchoicecompare);

        if ( compare == 0 )
        {
            System.out.println("Ok, restarting...");
            try {
                Thread.sleep(3000);                 //2 second delay
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            bet();
        }
        else
        {
            System.out.println("Ok, bye!");
            System.exit(0);
        }
    }
}


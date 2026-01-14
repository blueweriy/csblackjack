import java.util.Scanner;
public class BlackJack
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);  
    System.out.println("Welcom to the Casino! What is your name? ");
    String name = input.next();
    System.out.println("What is your age? ");
    int age = input.nextInt();
    Player a = new Player(name, age);
    
    System.out.println("You have $ "+a.getMoney());
    
    System.out.println("""
    What would you like to do?
    - play
    - money
    - quit
    """);
    String want = input.next();
    want = want.toLowerCase();
    if (want.equals("play"))
    {
        System.out.println("how much would you like to bet?");
    }
    else if (want.equals("money"))
    {
        System.out.println("You have $ "+a.getMoney()); 
    }
    else if (want.equals("quit"))
    {
        System.out.println("you gained nothing");
    }
    

    
    int bet = input.nextInt();
    
    
    }
    }

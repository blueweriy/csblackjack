import java.util.Scanner;
public class Player
{
    Scanner input = new Scanner(System.in);
    
    private String name;
    private int age;
    private int money;
    private double winRate;
    
    public Player(String n, int a)
    {
        name = n;
        age = a;
        money = 1000;
        if (a<18)
        {
            System.out.println("you are too young to play, good bye");
            System.exit(0);        
        }
    }
    
    public Player(int a, String n)
    {
        name = n;
        age = a;
        money = 1000;
        if (a<18)
        {
            System.out.println("you are too young to play, good bye");
            System.exit(0);        
        }
    }
    
    public int getMoney() 
    {
        return money;
    }
    
    public void play()
    {
        System.out.println("how much would you like to bet?");
        
        
        
        
        
    }
    
    }
    
    

//Sandy Jiang (sxj409) and Samantha Frankum (srf48)


import java.util.Stack;
import java.util.Scanner;

public class TodoList
{
  public static void main (String[] args)
  {
    System.out.println("This is our list of classes that need to be taken");
    Scanner stdin = new Scanner(System.in);
    String expression;
    System.out.println("What major are you?");
    
    System.out.print("Your major: ");
    expression = stdin.nextLine( ).toUpperCase( );
    if (rightMajor(expression ))
    {
      System.out.println("Wow a computer science major! We only support BS majors for software engineering track! ");
      query(stdin, "Is that okay?");
    }
    
    else
      System.out.println("That major is not supported by our code currently");
    
    do
    {
     System.out.print("Name 1 computer science class you have taken: ");
     expression = stdin.nextLine( ).toUpperCase( );
     if (addingClasses(expression))
        System.out.println("Class added!");
     else
        System.out.println("That's not a computer science class!");
    }
    while (query(stdin, "Do you have another class?"));
    
    System.out.println("Thanks for letting us help!");
  }//end main
  
  public static boolean query(Scanner input, String prompt)
  {
    String answer;
    
    System.out.print(prompt + " [Y or N]: ");
    answer = input.nextLine( ).toUpperCase( );
    while (!answer.startsWith("Y") && !answer.startsWith("N"))
    {
      System.out.print("Invalid response. Please type Y or N: ");
      answer = input.nextLine( ).toUpperCase( );
    }
    
    return answer.startsWith("Y");
    
  }//end query
  
  //write all your code here
  public static boolean rightMajor(String expression )
  {
    if(expression.equalsIgnoreCase("computer science"))
      return true;
    else
      return false;
  }
  
  public static boolean addingClasses(String expression)
  {
    
    String[] allClasses = {"EECS 132", "EECS 233", "EECS 281", "EECS 302", "EECS 340", "EECS 395", "CHEM 111", "ENGR 145","MATH 121", "MATH 122","MATH 223", "MATH 224","PHYS 121", "PHYS 122","ENGR 398"};
    return false;
    
  }//end addingClasses
  
  
}

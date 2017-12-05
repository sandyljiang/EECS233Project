//Sandy Jiang (sxj409) and Samantha Frankum (srf48)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;



public class TodoList
{
  
  public static String[] allClasses = new String[100] ;
  public static void main (String[] args) throws IOException
  {
    File file = new File("/Users/Sandy/Desktop/EECS233.txt");
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
    
    allClasses = creatingArray(file);
    do
    {
      System.out.print("Name 1 comp sci class you have taken: ");
      expression = stdin.nextLine( ).toUpperCase( );
      if (removingClasses(expression, allClasses))
      {
        System.out.println("Class Removed!");
        
      }
      
      else
        System.out.println("That's not a comp sci class!");
    }
    while (query(stdin, "Do you have another class?"));
    
    
    System.out.println("Thanks for letting us help! Here is your class list!");
    computeClassRecommendations(allClasses);
  }
  
    
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
    
  }

  public static boolean rightMajor(String expression )
  {
    if(expression.equalsIgnoreCase("computer science"))
      return true;
    else
      return false;
  }
  
  public static boolean removingClasses(String expression, String[] array)
  {
    if(Arrays.asList(array).contains(expression))
    {
      for (int i = 0; i < array.length; i++)
      {
        if (array[i] == expression)
        {
          String[] n = new String[array.length - 1];
          System.arraycopy(array, 0, n, 0, i);
          System.arraycopy(array, i+1, n, i, array.length - i);
          array = n;
        }
        allClasses = array;
        return true;
      }
      allClasses = array;
      return false;
    }
    allClasses = array;
    return false;
  }
  
  
  private static String[] creatingArray(File fin) throws IOException 
  {
    int numberOfClasses = 0;
    
    FileInputStream fis = new FileInputStream(fin);
    String[] array = new String[1000];
    
    //Construct BufferedReader from InputStreamReader
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    
    String line = null;
    while ((line = br.readLine()) != null) {
      array[numberOfClasses] = line;
      numberOfClasses++;
    }
    
    br.close();
    return array;
    
  }
  
  
  public static void computeClassRecommendations(String[] all)
  {
      System.out.println(Arrays.toString(all));
  }


}
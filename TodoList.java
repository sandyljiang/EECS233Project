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

  public static void main (String[] args) throws IOException
  {

    File file = new File("C:\\Users\\samor\\Documents\\NetBeansProjects\\SecondEECS233\\src\\FinalProject\\ClassList.txt");
    System.out.println("This is our list of classes that need to be taken");    

    String[] allClasses;
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
        long start, end;
        start = System.currentTimeMillis();
        allClasses = removing(expression, allClasses);  
        end = System.currentTimeMillis();
        System.out.println("It took " + (end-start) + " milliseconds to finish last task");
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
      return true;
    }
    return false;

  }

  

  public static String[] removing(String expression, String[] array)
  {
    int count = 0;
    String[] n = new String[array.length - 1];
     for (int i = 0; i < array.length; i++)
     { 
       if(array[i] == null){
           return n;
       }
       else if (!array[i].equals(expression))
       {
         n[count] = array[i];
         count++;
       }
     }

     return n;
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
      int count = 0;
      while(all[count] != null)
      {
          System.out.print(all[count] + ", ");
          count++;
      }
          
  }

}

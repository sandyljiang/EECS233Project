
//Sandy Jiang (sxj409) and Samantha Frankum (srf48)

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.Scanner;


public class ToDoHashTable<K,E>

{
  
  public static void main (String[] args) throws IOException
  {
    
    File file = new File("/Users/Sandy/Desktop/EECS233.txt");
      System.out.println("This is our list of classes that need to be taken");

    Scanner stdin = new Scanner(System.in);
    String expression;
    System.out.println("What major are you?");

    System.out.print("Your major: ");
    expression = stdin.nextLine( ).toUpperCase( );
    if (!rightMajor(expression))
    {
      System.out.println("That major is not supported by our code currently");
    }
    else{
      System.out.println("Wow a computer science major! We only support BS majors for software engineering track! ");
      query(stdin, "Is that okay?");
    
    
    Hashtable hash = creatingHashTable(file);
    do{
     System.out.print("Name 1 computer science class you have taken: ");
     expression = stdin.nextLine( ).toUpperCase( );
     
     boolean removed = false;
     
     for(int i = 0; i<hash.size(); i++)
     {
     removingClasses(expression,i, hash);
     }
     if(removed)
       System.out.println("Class removed from recommended class list!");
     else
        System.out.println("That's not a computer science class!");
    } 
    while (query(stdin, "Do you have another class?"));
    
    System.out.println("Thanks for letting us help! Here is your class list!");
    computeClassRecommendations(hash);
    }
  }//end main

  public static boolean removingClasses(String expression, int key, Hashtable hash){
      if(hash.get(key) != null){
          hash.remove(key);
          return true;
      }
      return false;
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
  }//end query

  //write all your code here

  public static boolean rightMajor(String expression )
  {
    if(expression.equalsIgnoreCase("computer science"))
      return true;
    else
      return false;

  }

  
  private static Hashtable creatingHashTable(File fin) throws IOException {
    FileInputStream fis = new FileInputStream(fin);
    Hashtable<Integer,String> hash = new Hashtable<Integer,String>();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));

    int i = 0;
    String line = null;
    while ((line = br.readLine()) != null) {
      hash.put(i, line);
      i++;
    }
   
    br.close();
    return hash;
  }
  
  public static void computeClassRecommendations(Hashtable hash){
      System.out.println(hash.toString());
  }

}

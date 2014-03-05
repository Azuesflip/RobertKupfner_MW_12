
/**
   This program is used to take an input file and put the first 20
   items. Then it will put it into order from largest to smallest 
   while also outputting its original position of how it's inputed.
   If the list is larger than 20 integers it will flush the rest
   to keep them from the array and prevent bugs.
   
   Robert Kupfner
   Program #12, CS 1050, MW
   Java 7.4, Lenovo Ideapad y400, Windows 8
 */

package robertkupfner_mw_12;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;



public class RobertKupfner_MW_12
{


    public static void main(String[] args) throws Exception
    {
        //File declarations
        final String INPUT_FILE = "C:\\School\\CS 1050\\AA.txt";
        final String OUTPUT_FILE = "C:\\School\\CS 1050\\Output.txt";
        
        //Scanner declarations for inputs and outputs
        Scanner inputFile = input_File(INPUT_FILE);
        Scanner inputFile2 = input_File(INPUT_FILE);
        PrintWriter outputFile = outputPrintFile(OUTPUT_FILE);
        outputFile.print(inputStrings(inputFile));
        
        //Class method set-up
        ArrayList<HoldingClass> students = loopStudents(inputFile2);
        
        //Method calls to print to output file
        outputFile.println(heading());
        outputFile.println(outputBody(students));
        outputFile.print(outputFooter(inputLines (students), gpaAverage(students), 
                                                           totalCredits(students)));
        outputFile.close();
        
    }
    // *******************************************************************

   // Replace <bracketed items>

   /** input_File
       Creates a Scanner for the input file to be used in creating arrays
            
       Spec Reference

       Input
         @param INPUT_FILE The input file string to be converted
         
       Process    1. Takes in the input file
                  2. Converts file into a Scanner to use
         
       Output
         @return people
         
       Note
   */
    public static ArrayList<HoldingClass> loopStudents(Scanner inputFile)
    {
      
      ArrayList<HoldingClass> people = new ArrayList<>();
      
      
      while (inputFile.hasNextLine())
      { 
        people.add(lineToPerson(inputFile.nextLine()));
      }
      
      return people;
      
    }
    //***************************************************************************
    
    /** outputBody
       Method to print out the table body
            
       Spec Reference

       Input
         @param students
         
       Process    1. Creates a String variable with the table body
                  2. Returns the body for output
                  
         
       Output
         @return outputString
       Note
   */
    public static String outputBody(ArrayList students)
    {
        Iterator<HoldingClass> it = students.iterator();
        HoldingClass s;
        String outputString = "";
        
        while (it.hasNext())
        {
          s = it.next();
          outputString += "|" + rightPad(s.getName(),12," ") + "|" + 
                                 leftPad(s.getGPA(),8,"##.0"," ") + "|" + 
                                 leftPad(s.getCredits(),8,"##"," ") + "|" + "\n";
        }
        return outputString;
    }
    //****************************************************************************
    
    /** gpaAverage
       Method to calculate the GPA averages for the students
            
       Spec Reference

       Input
         @param gpaTotal to sum up GPAs to find average
         @param counter to keep track of GPAs to find average
         @param gpaAvg to hold final average to return
         
       Process    1. Cycles through GPA data to accrue total and number of GPAs
                     processed
                  2. Calculates the average once while loop has run its course
                  
         
       Output
         @return gpaAvg
       Note
   */
    public static double gpaAverage(ArrayList students)
    {
        Iterator<HoldingClass> it = students.iterator();
        HoldingClass s;
        double gpaTotal = 0;
        int counter = 0;
        double gpaAvg = 0;
        
        while(it.hasNext())
        {
            s = it.next();
            gpaTotal += s.getGPA();
            counter++;
        }
        
        gpaAvg = gpaTotal/counter;
        
        return gpaAvg;        
    }
    //****************************************************************************
    
    /** totalCredits
       Method to determine the amount of credits
            
       Spec Reference

       Input
         @param creditsOutput to hold total credits
         
       Process    1. Cycles through credits while continuously adding them
                     to a running total
                  
         
       Output
         @return creditsOutput
       Note
   */
    public static int totalCredits(ArrayList students)
    {
        Iterator<HoldingClass> it = students.iterator();
        HoldingClass s;
        int creditsOutput = 0;
        
        while(it.hasNext())
        {
            s = it.next();
            creditsOutput += s.getCredits();
        }
        
        return creditsOutput;       
    }
    //****************************************************************************
    
    /** inputStrings
       Takes in the input file and forms an output string form.
            
       Spec Reference

       Input
         @param inp Scanner of the input file to use in printing out the
                    original array.
         @param arrayLength gives length of the input array to use
         
       Process    1. Creates a header for the output
                  2. Inputs the files grades into an array to printout
                  3. goes through the array and formats the output table
                     to print the first page table
                     
         
       Output
         @return outputString
         
       Note
   */
    public static String inputStrings (Scanner inp)
    {
        String outputString = "";
        int nRead = 0;
        
        while (inp.hasNext())
        { 
            if(nRead <= 9)
            {
              outputString += inp.nextLine() + "\n";
            }
            nRead++;
        }
        
        return outputString;
    }
    //***************************************************************************
    
    /** inputLines
       Takes in the input file and keeps a counter going for students.
            
       Spec Reference

       Input
         @param students
         
       Process    1. Counts the students with a running total
                     
         
       Output
         @return counter
         
       Note
   */
    public static int inputLines (ArrayList students)
    {
        Iterator<HoldingClass> it = students.iterator();
        HoldingClass s;
        int counter = 0;
                
        while(it.hasNext())
        {
            s = it.next();
            counter++;
        }
        
        return counter;
    }
    //****************************************************************************
    
    /** outputFooter
       Method to print out the table footer
            
       Spec Reference

       Input
         None
         
       Process    1. Creates a String variable with the table heading
                  2. Returns the heading for output
                  
         
       Output
         
       Note
   */
    public static String outputFooter(int people, double gpaAvg, int totCredits)
    {
        return "________________________________________" + "\n" +
                "Number of students: " + people + "\n" +
                "Averag GPA: " + gpaAvg + "\n" +
                "Number of credits passed: " + totCredits + "\n";
    }
    //****************************************************************************
    
    /** heading
       Method to print out the table heading
            
       Spec Reference

       Input
         None
         
       Process    1. Creates a String variable with the table heading
                  2. Returns the heading for output
                  
         
       Output
         
       Note
   */
    public static String heading()
    {
        return "|         Name        |  GPA   | Credits|\n" +
                "________________________________________";
    }
    //****************************************************************************
    
    /** HoldingClass lineToPerson
       
            
       Spec Reference

       Input
         @param line parameter to split
         
       Process    1. Split the line into the name from the left and an
                     array of values from the right
                  
         
       Output
         
       Note
   */
    public static HoldingClass lineToPerson(String line)
    {
      StringTokenizer st;
      String name, pairs[];
      double gradeVal, gradePoints;
      int hours;
      
      // Split the line into the name from the left and 
      // an array of values from the right
      st = new StringTokenizer(line);
      name = st.nextToken("#");
      pairs = st.nextToken().split(" ");
      gradePoints = hours = 0;
      
      for (int i=1;i<pairs.length-1;i+=2)
      {
        gradeVal = gradeValue(pairs[i+1]);
        if (gradeVal == -1)
          continue;
        else
        {
          gradePoints += gradeVal*Integer.parseInt(pairs[i]);
          hours += Integer.parseInt(pairs[i]);
        }
      }
      return (new HoldingClass(name,hours==0?0:gradePoints/hours,hours));
    }
    //*************************************************************************
    
    /** input_File
       Creates a Scanner for the input file to be used in creating arrays
            
       Spec Reference

       Input
         @param INPUT_FILE The input file string to be converted
         
       Process    1. Takes in the input file
                  2. Converts file into a Scanner to use
         
       Output
         @return inputFile
         
       Note
   */
    public static Scanner input_File(String INPUT_FILE) throws Exception
    {
        File inputDataFile = new File(INPUT_FILE);
        
        Scanner inputFile = new Scanner(inputDataFile);
        
        return inputFile;
    }
   // *******************************************************************

   /** outputPrintFile
       Create a PrintWriter to create  or append a file and add information
            
       Spec Reference

       Input
         @param outputFileLocation file location to create or append
         
       Process    1. Takes in file location String
                  2. converts the string to make a file and print to it
         
       Output
         @return outputFile
         
       Note
   */
   public static PrintWriter outputPrintFile(String outputFileLocation) 
           throws Exception
   {
       
        FileWriter outputDataFile = new 
                     FileWriter(outputFileLocation, false);
        
        PrintWriter outputFile = new PrintWriter(outputDataFile);
        return outputFile;
   }
   //***************************************************************************
   
   /** gradeValue
       Determine grade using switch

       Spec Reference   

       Input
         @param   g   Variable holding the grade to determine case
         
       Process    1. Determine case and return result
         
       Output
         
       Note
   */
   public static int gradeValue(String g)
   {
     switch (g)
     {
       case "A":
         return 4;
       case "B":
         return 3;
       case "C":
         return 2;
       case "D":
         return 1;
       case "F":
         return 0;
       default:
         return -1;
     }
   }
   //***********************************************************************
   
   /** rightPad
       Convert a number to a string and pad it on the left

       Spec Reference   Introduced in Assignment 7

       Input
         @param   number   A double number to be formatted
         @param   width    The width of the formatted number after padding
         @param   mask     The DecimalFormat mask to use
         @param   padding  The string to use for padding, usually a space
         
       Process    1. Convert the number to a string
                  2. Use padItString to finish the job
         
       Output
         @return  strPad   The formatted number, padded if necessarray
         
       Note
   */
   public static String rightPad(String str, int width, String padLeft)
   {
      String strPad;               // String to be returned

      strPad = padItString(str, width, padLeft, "");
      return strPad;
   } // end rightPad()
   //****************************************************************************
   
   /** padItString
       Convert a number to a string and pad it on the left

       Spec Reference   Introduced in Assignment 7

       Input
         @param   number   A double number to be formatted
         @param   width    The width of the formatted number after padding
         @param   mask     The DecimalFormat mask to use
         @param   padding  The string to use for padding, usually a space
         
       Process    1. Convert the number to a string
                  2. Use padItString to finish the job
         
       Output
         @return  strPad   The formatted number, padded if necessarray
         
       Note
   */
   public static String padItString(String str, int width, 
                                    String padLeft, String padRight)
   {
      String strPad = str;         // String to be returned, starts as the param
      int charsToPad;              // The number of charactes to pad
   
      // Using the length of the String str, calculate
      // the number of characters to pad on the left
      charsToPad = width - strPad.length();
   
      // Pad str by spaces on the left and/or right so that the
      // resulting length of strPad is 'width' characters
      for (int i = 0;  i < charsToPad;  i++)
      {
         strPad = padLeft + strPad + padRight;
      }
      return strPad;
   } // end padItNumber()
   
   // *******************************************************************

    /** leftPad
       Convert a number to a string and pad it on the left

       Spec Reference   Introduced in Assignment 7

       Input
         @param   number   A double number to be formatted
         @param   width    The width of the formatted number after padding
         @param   mask     The DecimalFormat mask to use
         @param   padding  The string to use for padding, usually a space
         
       Process    1. Convert the number to a string
                  2. Use padItString to finish the job
         
       Output
         @return  strPad   The formatted number, padded if necessary
         
       Note
   */
    
    public static String leftPad (double number, int width, 
                                 String mask, String padding)
   {
         final int DEFAULT_WIDTH = 8; // If 'width' is out of range
         final int MIN_WIDTH = 3;     // Minimum width allowed
         String strPad;               // String to be returned
         int charsToPad;              // The number of charactes to pad

         //  Convert number to a String
         DecimalFormat fmt = new DecimalFormat(mask);
         strPad = fmt.format(number);

         // Use the default width if the width parameter is no good.
         // Using the length of the String str, calculate
         // the number of characters to pad on the left
         if (width < MIN_WIDTH) width = DEFAULT_WIDTH;
         charsToPad = width - strPad.length();

         // Pad str by spaces on the left so that the resulting length 
         // of str is 'width' characters
         for (int i = 0;  i < charsToPad;  i++)
         {
               strPad = padding + strPad;
         }
         return strPad;
   } // end leftPad()
}
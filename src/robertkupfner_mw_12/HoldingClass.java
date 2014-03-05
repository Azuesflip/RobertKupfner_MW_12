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

public class HoldingClass 
{
    //Private declarations used within class methods
    private String name;
    private double gpa;
    private int credits;
    
    /** HoldingClass
       Class method holding information from the input file for processing
            
       Spec Reference

       Input
         @param name    holds names read from input file
         @param gpa     holds gpa read from input file
         @param credits holds credits read from input file
         
       Process    1. Takes in the input file
                  2. Stores input data for use in main program
         
       Output
         
       Note
   */
    public HoldingClass(String name, double gpa, int credits)
    {
        this.name = name;
        this.gpa = gpa;
        this.credits = credits;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getGPA()
    {
        return gpa;
    }
    
    public int getCredits()
    {
        return credits;
    }
}
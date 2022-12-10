/**
 * Takes input from user about mail details & outputs service cost information or error based on input
 *
 * @author Iris Carrigg
 * @version 8/31/2022
 */

import java.util.Date;
import java.util.Scanner;

public class Project1 {
    public static void main ( String[] args ) {
        //follow the instructions in the comments exactly
        //do not delete the comments
        
        //1. DATE AND TIME YOU FIRST START WORKING ON THIS ASSIGNMENT (date AND time): <--------------------
        //ANSWER:  8/31/2022 10:49AM              <--------------------
        
        
        System.out.println( "Welcome to the Ankh-Morpork Post Office!" );
        
        //2. declare a scanner object, call it keyboard; you'll have to import the Scanner class too
        Scanner keyboard = new Scanner(System.in);
        
        
        //3. ask the user what (s)he's shipping today
        System.out.print("Are you shipping a letter or a package?    ");
        
        
        String typeOfMail;
        
        //4. read the input in the typeOfMail variable
        
        typeOfMail = keyboard.next();
        
        //5. trim the typeOfMail of leading and trailing spaces
        
        typeOfMail = typeOfMail.trim();
        
        //6. make typeOfMail all lower case letters
        
        typeOfMail = typeOfMail.toLowerCase();
        
        //this is logic that says "if you're not shipping a letter 
        //or a package, terminate the program with a message
        //and an error code of -1" 
        if ( !typeOfMail.equals( "package" ) && !typeOfMail.equals( "letter" ) ){ 
            System.out.println( "We don't ship " + typeOfMail + ". Goodbye." );
            System.exit( -1 );
        }
        
        //7. create a Mail object with the standard constructor
        
        Mail mail = new Mail();
        
        //8. set type of mail instance variable in the mail object
        mail.setType(typeOfMail); 
        
        //9. ask the user how many pieces of that type of mail they're sending
        
        System.out.printf("How many %ss are you mailing?   ",mail.getType() );
        
        int piecesOfMail = 0;
        
        //10. read the user input about how many pieces of mail they're 
        //    sending in the piecesOfMail variable declared above
        piecesOfMail = keyboard.nextInt();
        
        
        //this code checks if the number of mail pieces entered is valid
        if ( typeOfMail.equals( "letter" ) && ( piecesOfMail <= 0 || piecesOfMail > 100 ) ){ 
            System.out.println( piecesOfMail + " is not a valid number of letters. Goodbye." );
            System.exit( -2 );
        }
        else if ( typeOfMail.equals( "package" ) && ( piecesOfMail <= 0 || piecesOfMail > 10 ) ){ 
            System.out.println( piecesOfMail + " is not a valid number of packages. Goodbye." );
            System.exit( -3 );
        }
            
        //11. set the units instance variable in the Mail object to piecesOfMail
        
        mail.setUnits(piecesOfMail);
        
        //this code prompts the user for destination input
        //reads the input and checks it for validity, then gives it back to you
        //when the line executes, the destination variable will hold the 
        //string value of what you input for destination
        String destination = chooseDestination( keyboard );
            
        //12. set the destination instance variable in the mail object
        
        mail.setDestination(destination);
        
        //this code calculates postage for you given the type of mail and destination
        //when the lione executes, the postage variable will hold the price of mail
        //the price doesn't uinclude tax
        double postage = calculatePostage( typeOfMail, destination );
            
        //13. set the postageperUnit instance variable in the mail object
        
        mail.setPostagePerUnit(postage);
        
        //14. move to the printReceipt method below and finish it according to the directions
        printReceipt( mail );
    }
    
    /* finish this method! <-----------
     * 
     * printReceipt - this method prints the formatted receipt
     * 
     * @param Mail mail - the Mail object with values set in the main
     * @return nothing
     */
    public static void printReceipt( Mail mail ) {
        //15. all the user entered data read in the main should be in the object called mail
        //    use getter methods from the Mail class with the mail object to print the formatted receipt
        
        //new Date object
        Date now = new Date();
        
        System.out.println(".....................................................");
        
        System.out.printf(": Date: %s%17c%n:", now, ':');
        
        System.out.printf("%52c%n: ", ':');
        
        System.out.printf("PRODUCT & DESTINATION         COST%17c%n: ",':',"---------------------------------------------",':');
        
        System.out.printf("%s%6c%n: ","---------------------------------------------",':');
        
        System.out.printf("%-3d %7ss to %-13s Price $%7.2f%7c%n: ", mail.getUnits(), mail.getType(), mail.getDestination(),mail.getPostagePerUnit() * mail.getUnits(), ':'); 
        
        System.out.printf("                                Tax $%7.2f%7c%n: ", (mail.getPostagePerUnit() * mail.getUnits()) * .06, ':');
        
        System.out.printf("                              TOTAL $%7.2f%7c%n:",(((mail.getPostagePerUnit() * mail.getUnits()) * .06) + (mail.getPostagePerUnit() * mail.getUnits())), ':');
        
        System.out.printf("%52c%n: ", ':');        
        
        System.out.println("Thank you for using the Ankh-Morpork Post Office! :");
        
        System.out.println(".....................................................");
        
        //16. delete the 3 instructions below when you're done
        
        
    }
    
    /* do not change this method!
     * 
     * chooseDestination - this method checks for a valid destination
     * 
     * @param Scanner kbrd - stream to read from keyboard
     * @return String - the destination of the cargo with the correct format
     */
    private static String chooseDestination( Scanner kbrd ) {
        System.out.print( "Enter the destination:  " );
        String dest = kbrd.next();
        
        switch ( dest.trim().toLowerCase() ) {
            case "ankh-morpork": return "Ankh-Morpork";
            case "pseudopolis": return "Pseudopolis";
            case "ueberwald": return "Ueberwald";    
            default:
                System.out.println( "We don't ship to " +  dest + ". Goodbye." );
                System.exit( -2 );     
        }
        
        return "";
    }
    
    /* do not change this method!
     * 
     * calculatePostage - this method calculates postage given the type and 
     *                    detination of the cargo
     * 
     * @param String type - the type of cargo
     * @param String dest - the destination
     * @return double - the price of cargo (without tax)
     */
    private static double calculatePostage( String type, String dest ) {        
        if ( dest.trim().equalsIgnoreCase( "Ankh-Morpork" ) && type.trim().equalsIgnoreCase( "letter" ) ) return 1.50;
        else if ( dest.trim().equalsIgnoreCase( "Ankh-Morpork" ) && type.trim().equalsIgnoreCase( "package" ) ) return 12.85;
        else if ( dest.trim().equalsIgnoreCase( "Pseudopolis" ) && type.trim().equalsIgnoreCase( "letter" ) ) return 13.12;
        else if ( dest.trim().equalsIgnoreCase( "Pseudopolis" ) && type.trim().equalsIgnoreCase( "package" ) ) return 40.20;
        else if ( dest.trim().equalsIgnoreCase( "Ueberwald" ) && type.trim().equalsIgnoreCase( "letter" ) ) return 50.00;
        else if ( dest.trim().equalsIgnoreCase( "Ueberwald" ) && type.trim().equalsIgnoreCase( "package" ) ) return 151.23;
        else{
            System.out.println( "Something went wrong. Panic!" );
            System.exit( -3 );     
        }

        return -1;
    }
}


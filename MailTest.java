/* This class tests your Mail class
 * @author Iris Carrigg
 * @version 8/31/2022
*/ 
public class MailTest {
    public static void main( String[] args ) {
        Mail m1 = new Mail();
        assert m1.getDestination().equals( "" ) : "constructor destination value fail";
        assert m1.getUnits() - 0 == 0 : "constructor units value fail";
        assert m1.getPostagePerUnit() - 0.0 < 0.001 : "constructor postagePerUnit value fail";
        assert m1.getType().equals( "" ) : "constructor package type fail";
        System.out.println( "standard constructor is correct" );
        
        Mail m2 = new Mail();
        m2.setDestination( "Pseudopolis" );
        m2.setUnits( 3 ); 
        m2.setPostagePerUnit( 1.20 );
        m2.setType( "letter" );
        
        assert m2.getDestination().equals( "Pseudopolis" ) : "get or set destination fail";
        System.out.println( "getter and setter for destination instance variable are correct" );

        assert m2.getUnits() - 3 == 0 : "get or set units fail";
        System.out.println( "getter and setter for units instance variable are correct" );
        
        assert m2.getPostagePerUnit() - 1.20 < 0.001 : "get or set postagePerUnit fail";
        System.out.println( "getter and setter for postagePerUnit instance variable are correct" );
        
        assert m2.getType().equals( "letter" ) : "get or set package type fail";
        System.out.println( "getter and setter for type instance variable are correct" );
    }
}

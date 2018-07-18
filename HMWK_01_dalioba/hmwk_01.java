// Dalio, Brian A.
// abc1234
// 2018-07-11

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hmwk_01 {
  public static void processToken( String token )
  {
	  
	Pattern INTmatch = Pattern.compile("[1-9][0-9]*");
	Pattern IDmatch = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]*");
    Pattern FPmatch = Pattern.compile("[0-9]+.[0-9]+");  
	  
	Matcher INT_MATCH =INTmatch.matcher(token);
	Matcher ID_MATCH =IDmatch.matcher(token);
	Matcher FP_MATCH =FPmatch.matcher(token);
	
	boolean INT_TRUE = INT_MATCH.matches();
	boolean ID_TRUE = ID_MATCH.matches();
	boolean FP_TRUE = FP_MATCH.matches();
	
	if (INT_TRUE) {
		System.out.println(">" + token + "< matches INT");
	}
	else if  (ID_TRUE) {
		System.out.println(">" + token + "< matches ID");
	}
	else if  (FP_TRUE) {
		System.out.println(">" + token + "< matches FP");
	}
	else {
		System.out.println(">" + token + "< does not match");
	}
  }

  public static void main( String[] args )
  {
    System.out.println( "processing tokens from " + args[ 0 ] + " ..." );

    try {
      Files.lines( Paths.get( args[ 0 ] ) ).forEachOrdered(
        line -> Arrays.stream( line.split( "\\s+" )  )
            .forEachOrdered( token -> processToken( token ) ) );
    } catch ( java.io.IOException e ) {
      e.printStackTrace();
    }
  }
}

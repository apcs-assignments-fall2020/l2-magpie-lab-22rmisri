/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
     public int findWord(String str, String word) {
        String str2 = str.toLowerCase();
        int index = str2.indexOf(word);
        int len = word.length();
        if (index != -1) {
            if (index == 0) {
                if (str2.charAt((index + len)) == ' ') {
                    return index;
                }
            }
            else if (str2.length() - len == index) {
                return index;
            }
            if ( (str2.charAt(index - 1) == ' ') && (str2.charAt((index + len)) == ' ') ) {
                return index;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }
    public String getResponse(String statement)
    {
        int len = statement.trim().length();
        String response = "";
        if (findWord(statement, "no") >= 0)
        {
            response = "I don't like nos";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if ( ((findWord(statement, "cat") >= 0)) || (findWord(statement, "dog")) >= 0 ) {
            System.out.println("Tell me more about your pets");
        }
        else if ( ((findWord(statement, "Nathan") >= 0))  ) {
            System.out.println("He sounds like a great teacher!");
        }
        else if ( len == 0) {
            System.out.println("Say something please");
        }
        else if ( findWord(statement, "brother") >= 0 ) {
            System.out.println("You have a brother?");
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4) {
            response = "Wow, cool";
        }
        else if(whichResponse == 5) {
            response = "Okay then";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
   

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String[] words = statement.split("\\s+");
        String new_string = "Would you really be happy if you had " + words[2] + "?";
        return new_string;
        }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String [] words = statement.split("\\s+");
        String new_string = "Why do you " + words[1] + " me?";
        return new_string;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String new_string = "";
        for (int i = 10; i < (statement.length()); i++) {
            char index = statement.charAt(i);
            new_string += index;
        }
        String want = "What would it mean to " + new_string + "?";
        return want;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        int you = statement.indexOf("you");
        int start = you + 4;
        int end = statement.length() - 3;
        String new_string = "";
        for (int i = start; i < end; i++) {
            char index = statement.charAt(i);
            new_string += index;
        }
        String want = "What makes you think that I " + new_string + " you?";
        return want;
    }
}
public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String test = "   First tWo wordS";
        System.out.println(camelCase(test));
    //    System.out.println( lowerCase('W'));
    //    System.out.println( lowerCase('a'));
    //    System.out.println( upperCase('W'));
    //    System.out.println( upperCase('a'));
    }
    
    

     public static char lowerCase (char letter) {
       
        if(letter <= 'Z' && letter >= 'A')
            return (char)(letter+32);
        else return letter;
    }

    public static char upperCase (char letter) {
        
        if(letter <= 'z' && letter >= 'a')
            return (char)(letter-32);
        else return letter;
    }

    public static boolean IsVowel (char letter) {
        
        if(letter == 'o' || letter == 'i' ||letter == 'a' ||letter == 'e' ||letter == 'u')
            return true;
        if(letter == 'O' || letter == 'I' ||letter == 'A' ||letter == 'E' ||letter == 'U')
            return true;
        else return false;
    }

    public static String capVowelsLowRest (String string) {
        int length = string.length();
        String temp = "";

        if(IsVowel(string.charAt(0)))
        {
            temp += upperCase(string.charAt(0));
            temp += string.substring(1);
        }
        else 
        {
            temp += lowerCase(string.charAt(0));
            temp += string.substring(1);
        }
        for(int i =1; i<length-1 ; i++)
        {   string = temp;
            temp = "";
            if(IsVowel(string.charAt(i)))
            {
                temp += string.substring(0, i);
                temp += upperCase(string.charAt(i));
                temp += string.substring(i+1);
            }
            else 
            {
                temp += string.substring(0, i);
                temp += lowerCase(string.charAt(i));
                temp += string.substring(i+1);
            }
        }
        string = temp;
        temp = "";
        if(IsVowel(string.charAt(length -1)))
        {
            temp += string.substring(0, length-1);
            temp += upperCase(string.charAt(length -1));
            
        }
        else 
        {
            temp += string.substring(0, length-1);
            temp += lowerCase(string.charAt(length -1));
        }
        return temp;

    }
    public static int nextWhiteSpace (String string)
    {
        int i=0;
        while(string.charAt(i)!= ' ' && i != string.length()-1)
        {
            i++;
        }
        return i;
    }

    public static String camelCase (String string) {
        int j=0;
        while(string.charAt(j)== ' ')
            j++;
        
        int firstWhiteSpace = j + nextWhiteSpace(string.substring(j));//5
        int i=j;
        String newString = "";
        while(i< firstWhiteSpace)
        {
            newString+= lowerCase(string.charAt(i));
            i++;
        }

        int nextWhiteSpace = firstWhiteSpace;

        while(nextWhiteSpace!= string.length()-1)
        {
            newString+= upperCase(string.charAt(nextWhiteSpace+1));
            int tempIndex = nextWhiteSpace +2;
            nextWhiteSpace += nextWhiteSpace(string.substring(nextWhiteSpace+2)) +2;
            i = tempIndex;
            while(i<nextWhiteSpace)
            {
                newString+= lowerCase(string.charAt(i));
                i++;
            }
            //newString+= string.substring(tempIndex, nextWhiteSpace);
        }
        newString+= lowerCase(string.charAt(string.length()-1));
        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        // Write your code here:
        return new int[1];
    }
}

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
        String test = "MMMM";
        //System.out.println(test.length());
       int [] array = allIndexOf(test,'M');
       int i=0;
       while(i<array.length)
       {
        System.out.println(array[i]);
        i++;
       }
        //System.out.println(test.length());
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
        while(string.length() !=0 && string.charAt(i)!= ' ' && i != string.length()-1)
        {
            i++;
        }
        return i;
    }

    public static int AmountWhiteSpace (String string)
    {
        int i=0;
        while(string.length()!= 0 && string.charAt(i)== ' ' && i != string.length()-1)
        {
            i++;
        }
        return i;
    }

    // public static String removeExtraWhiteSpaces (String s)
    // {
    //     String s2 = "";
    //     int i=0;
    //     while(i < s.length())
    //     {
    //         if(s.charAt(i)!= ' ')
    //             s2+= s.charAt(i);
    //         i++;
    //     }
    //     return s2;
    // }
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
            int whiteSpaces = AmountWhiteSpace(string.substring(nextWhiteSpace));
            // if(nextWhiteSpace + whiteSpaces == string.length())
            //     break;
            newString+= upperCase(string.charAt(nextWhiteSpace + whiteSpaces));
            int tempIndex = nextWhiteSpace +whiteSpaces +1;
            nextWhiteSpace += nextWhiteSpace(string.substring(nextWhiteSpace + whiteSpaces)) +whiteSpaces;
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

        int count =0;
        for(int i=0; i< string.length(); i++)
        {  
           // System.out.println("first loop " + i);
            if(string.charAt(i) == chr)
                count++;
          
        }
        int [] array = new int[count];
        int arrayIndex = 0;
        int i =0;
        while(i < string.length() && arrayIndex != array.length)
        {
            //System.out.println("second loop " + i);
            if(string.charAt(i)== chr)
            {
                array[arrayIndex] = i;
                arrayIndex++;
            }
            i++;
        }
        return array;
    }
}

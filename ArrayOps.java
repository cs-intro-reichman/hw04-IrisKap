public class ArrayOps {
    public static void main(String[] args) {

      int [] array1 =     {3, -4, 1, 5};
      int [] array2 =    {1, 3, -4, 5, 2, 9, 5, 3};
      boolean result = containsTheSameElements(array1 , array2);
      System.out.println(result);
        
    }
    
    public static int findMissingInt (int [] array) {
        int length = array.length;
        int num;
        boolean[] isInArrey = new boolean[length+1];
        for(int i = 0; i < length; i++)
        {
            num = array[i];
            isInArrey[num] = true;
        } 
        int i = 0;
        while(isInArrey[i])
        {
            i++;
        }
        return i;
    }

    public static int secondMaxValue(int [] array) {
        int max1 = Math.max(array[0],array[1]);
        int max2 = Math.min(array[0],array[1]);

        for(int i=2 ; i< array.length; i++ )
        {   
            if(array[i] > max2)
            {
                if(array[i]> max1)
                {
                    max2 = max1;
                    max1 = array[i];
                }
                else max2 = array[i];
            }

        }
        return max2;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int i =0;
        boolean foundFirst = true;
        while(i < array1.length && foundFirst == true)
        {   
            foundFirst = false;
            int j =0;
            while(foundFirst == false && j < array2.length)
            {
                if(array2[j] == array1[i])
                {
                    foundFirst = true;
                }
                j++;

            }
            i++;
        }
        i =0;
        boolean foundSecond = true;
        while(i < array2.length && foundSecond == true)
        {   
            foundSecond = false;
            int j =0;
            while(foundSecond == false && j < array1.length)
            {
                if(array1[j] == array2[i])
                {
                    foundSecond = true;
                }
                j++;

            }
            i++;
        }
        return foundFirst && foundSecond;
    }

    public static boolean isSorted(int [] array) {
        boolean sorted = true;
        boolean increasing = false;
        boolean decreasing = false;
        int i=0;
        while(!increasing && !decreasing && i< array.length-1)
        {
            if(array[i]> array[i+1])
                decreasing = true;
            else if(array[i]< array[i+1])
                increasing = true;
            i++;
        }
        while(increasing && sorted && i< (array.length-1))
        {
            if(array[i] > array [i+1])
                sorted = false;
            i++;
        }
        while(decreasing && sorted && i< (array.length-1))
        {
            if(array[i] < array [i+1])
                sorted = false;
            i++;
        }
        return sorted;
    }

}

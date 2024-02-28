package Feb_27_Assignment;

import java.util.Scanner;

public class Q2_WildCard_Pattern
{
    public boolean wildCard_Pattern(String str , String pattern , int i , int j)
    {
        if(i<0 && j<0)// string and pattern both are consume
        {
            //return 1 ;
            return true;
        }
        if(i>=0 && j<0)//j is fully consume but i still remains
        {
           // return 0;
            return false;
        }
        if(i<0 && j>=0) // i is fully consumed but j still remains
        {
         for(int k=0;k<=j;k++)
         {
             if( pattern.charAt(k) != '*') // check if there is anything except * then return false
             {
              return false;
             }
         }
         return true;// but in case there is * remains then print true because * can be empty
        }
        if(str.charAt(i)==pattern.charAt(j) || pattern.charAt(j) =='?')// if the element in i is equal to j or j==?
        {
            return wildCard_Pattern(str ,pattern,i-1,j-1);// call the method and decrease i and j by 1
        }
        else if(pattern.charAt(j)=='*')// if j == *
        {
            return (wildCard_Pattern(str , pattern , i-1,j)||wildCard_Pattern(str,pattern,i,j-1));
            // call the function and decrease i by 1 but j will be same because in case if we consider * is empty then i move but j still at same position
            //or i remain same but j decrease by 1 because in case we replace *with character
        }
        else
        {
            return false;// return false when any of the word remain
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String str = sc.next(); // take string as input
        System.out.println("enter pattern");
        String pattern = sc.next(); // take pattern as input
        int i = str.length()-1;
        int j = pattern.length()-1;
        Q2_WildCard_Pattern obj = new Q2_WildCard_Pattern();// create obj of class
        boolean ans = obj.wildCard_Pattern(str ,pattern,i , j); // call the function store the return in ans
       if(ans==true)// if the ans is true then print 1
       {
           System.out.println("1");
       }
       else   // print 0
       {
           System.out.println("0");
       }


    }
}

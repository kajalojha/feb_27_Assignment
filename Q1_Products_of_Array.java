package Feb_27_Assignment;

import java.util.Scanner;

public class Q1_Products_of_Array
{
    public int[] arrayProducts( int n ,int arr[])
    {
        int product =1;//initially we take product as 1
        int rarr[] = new int[n];// empty arr
        int i;
        for( i =0;i<n;i++)//loop upto length of arr
        {

            product = product*arr[i];// multiply arr[i] into product

        }
        for(  i=0 ;i<n;i++)// another loop for inserting element into empty arr that is rarr
        {
            rarr[i] = product /arr[i]; // divide the product by arr[i] // 1st product=24 ,1*2*3*4=24/1=24
            // 24/2=12 , 24/3 =8 , 24/4=6 in this way we put element in empty arr that is rarr
        }

        return rarr; // return rarr[]
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size");
        int n = sc.nextInt();// size
        int[] arr = new int[n];// array created
        for(int i=0 ;i<n;i++)
        {
            arr[i] = sc.nextInt();// put the element in arr[i]
        }
        Q1_Products_of_Array obj = new Q1_Products_of_Array();// create object
       int[] result = obj.arrayProducts(n ,arr);// with the help of object call function arrayProduct
       for(int i=0 ;i<result.length;i++)//loop for printing the rarr
       {
           System.out.print(result[i]  );
       }

    }
}

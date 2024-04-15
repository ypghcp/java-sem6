import java.util.*;
class ColorTree
{
     public static void main(String a[])
     {
          Scanner scan = new Scanner(System.in);
          TreeSet<String> t = new TreeSet<>();
          System.out.println("Enter no of colors add: ");
          
          int n = scan.nextInt();
          System.out.println("Enter Colors:");
          for (int i=0;i<n;i++)
          {
             t.add(scan.next());
          }
          System.out.println("Colors in TreeSet are: ");
          for (String ab : t)
               System.out.println(ab);
          scan.close();     
     }
}

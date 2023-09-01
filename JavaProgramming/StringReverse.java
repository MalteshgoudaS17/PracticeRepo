class StringReverse
{
 
public static void main(String args[])
{
     String sentence="Java is Object oriented prog lang";
     String[] sp=sentence.split(" ");
     System.out.println(sp.lenght());

     for(int i=sp.lenght-1;i>=0;i--)
     {
            System.out.println(sp[i]+" ");
     }
}
}
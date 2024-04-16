class threadPrint extends Thread
{
    String msg="";
    int n;
    threadPrint (String msg,int n)
    {
       this.msg=msg;
       this.n=n;
    }
    public void run()
    {
         try
         {
            for (int i=1;i<=n;i++)
                System.out.println(msg+" "+i+"times");            
         }
         catch (Exception e)
         {
         }
    }
    
}
class print
{
     public static void main(String a[])
     {
        threadPrint t1 = new threadPrint("COVID19",10);
           t1.run();
           threadPrint t2 = new threadPrint("LOCKDOWN2020",20);
           t2.run();
           threadPrint t3 = new threadPrint("VACCINATED2021",30);
           t3.run();
     }
}

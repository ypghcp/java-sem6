class Ass_seta3 extends Thread
{
            String msg="";
                        int  n;
                        Ass_seta3(String msg,int n)
                        {
                                    this.msg=msg;
                                                this.n=n;
                        }
            public void run()
            {
                        try
                        {           for(int i=1;i<=n;i++)
                                    {
                                                System.out.println(msg+" "+i+" times");
                                    }
                                    System.out.println("\n ");
                        }
                        catch(Exception e){}
            }
}
class A1
{
            public static void main(String a[])
            {
                        int n=10;
                                    Ass_seta3 t1=new Ass_seta3("I am in FY",n);
                                    t1.start();
                                    Ass_seta3 t2=new Ass_seta3("I am in SY",n+10);
                                    t2.start();
                                    Ass_seta3 t3=new Ass_seta3("I am in TY",n+20);
                                    t3.start();
            }
}
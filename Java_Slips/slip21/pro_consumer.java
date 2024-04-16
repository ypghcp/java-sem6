class shop
{
     int mat;
     boolean flag=false;
     
     public synchronized int get()
     {
           while(flag==false)
           {
                try
                {
                   wait();
                }
                catch (Exception e)
                {
                     e.getStackTrace();
                }
           }
           flag=false;
           notify();
           return mat;
     }     
     
     public synchronized void put(int val)
     {
           while(flag==true)
           {
                try
                {
                   wait();
                }
                catch (Exception e)
                {
                      e.getStackTrace();
                }
               
           }
           mat=val;
           flag=true;
           notify();
     }
}
     
    

 class Consumer extends Thread
  {
     	shop sh;
     	int no;
     	public Consumer(shop shp,int no)
     	{
               sh=shp;
       	       this.no=no;
        }
     	public void run()
     	{
           int val=0;
           for (int i=1;i<=10;i++)
           {
                val=sh.get();
                System.out.println("Consumer #"+this.no+" get: "+val);
           }
     	}
     }

class Producer extends Thread
{
     	shop sh;
     	int no;
     	public Producer(shop s,int no)
     	{
               sh=s;
       	       this.no=no;
         }
     	public void run()
     	{
           int val=0;
           for (int i=1;i<=10;i++)
           {
                sh.put(i);
                System.out.println("Producer #"+this.no+" put: "+i);
                try
                {
                   sleep(1000);
                }
                catch (Exception e)
                {
                      e.getStackTrace();
                }
           }
     	}
}



class pro_consumer
{
      public static void main(String a[])
      {
            shop s = new shop();
            Producer p = new Producer(s,1);
            p.start();
            Consumer c = new Consumer(s,1);
            
            c.start();
      }
}

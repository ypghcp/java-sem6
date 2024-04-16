public class Threadname extends Thread {
    public void run()
    {
        System.out.println("Thread Name is:"+Thread.currentThread().getName());
    }    
    public static void main(String a[])
    {
        Threadname t1 = new Threadname();
        Threadname t2 = new Threadname();
        Threadname t3 = new Threadname();
        Threadname t4 = new Threadname();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

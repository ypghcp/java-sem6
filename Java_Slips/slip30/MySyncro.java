class mythread extends Thread {
    String msg[] = { "Java", "Supports", "Multithreading", "Concept" };

    mythread(String name) {
        super(name);
    }

    public void run() {
        display(getName());
        System.out.println("Exit from " + getName());
    }

    synchronized void display(String name) // Synchrinized method
    {
        for (int i = 0; i < msg.length; i++) {
            System.out.println(name + msg[i]);
        }
    }
}

class MySynchro {
    public static void main(String args[]) {
        mythread t1 = new mythread("Thread 1: ");
        mythread t2 = new mythread("Thread 2: ");
        t1.start();
        t2.start();
        System.out.println("Main thread exited");
    }
}

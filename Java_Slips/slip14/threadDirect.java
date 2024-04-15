
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class Mythread extends Thread 
{
    String str;
    String filename;

    Mythread(String str, String filename) 
    {
        this.str = str;
        this.filename = filename;
    }

    public void run() {
        try {
            int flag = 0;
            File f = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            int cnt=0;
            while ((line = br.readLine()) != null) 
            {
                cnt++;
                if (line.contains(str) == true) 
                {
                    flag = 1;
                    
                    break;
                }
            }
            if (flag == 1) 
            {
                System.out.println("String found in file :" + filename+" at line no:"+cnt);
            } else 
            {
                System.out.println("String not found in file :" + filename);
            }
            br.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
class threadDirect 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Search string :");
        String str = sc.nextLine();

        String dirname = "mydir";
        File d = new File(dirname);
        if (d.isDirectory()) 
        {
            String s[] = d.list();
            for (int i = 0; i < s.length; i++) 
            {
                File f = new File(dirname + "/" + s[i]);
                if (f.isFile() && s[i].endsWith(".txt")) 
                {
                    Mythread t = new Mythread(str, dirname + "/" + s[i]);
                    t.start();
                }
            }
        }
        sc.close();
    }
}


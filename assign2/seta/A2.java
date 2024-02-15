public class A2 {
	public static void main(String[] args) {
		try {
			Thread t = Thread.currentThread();
			t.setName("Reverse Thread");
			System.out.println(t);
			for (int i = 100; i >= 1; i--) {
				System.out.println(i);
				Thread.sleep(6000);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
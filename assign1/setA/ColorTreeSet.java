import java.util.TreeSet;

public class ColorTreeSet {
    public static void main(String[] args) 
    {
        TreeSet<String> colors = new TreeSet<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");
        colors.add("Orange");  

        System.out.println("Colors in the TreeSet:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}

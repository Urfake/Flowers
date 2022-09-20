import java.util.*;

public class Main {

    public static void main(String[] args) {
        WhiteRose whiteRose = new WhiteRose(60, 20, 120);
        WhiteRose whiteRose1 = new WhiteRose(40, 40, 220);
        WhiteRose whiteRose2 = new WhiteRose(10, 70, 320);

        List<WhiteRose> bouquet = new ArrayList<>();

        bouquet.add(whiteRose);
        bouquet.add(whiteRose1);
        bouquet.add(whiteRose2);

        Collections.sort(bouquet, new Comparator<WhiteRose>() {
            @Override
            public int compare(WhiteRose o1, WhiteRose o2) {
                return o1.getFreshness() - o2.getFreshness();
            }
        });
        for (WhiteRose w:
                bouquet
             ) {
            System.out.println(w.getFreshness());
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = in.nextInt();
        System.out.println("Введите второе число: ");
        int b = in.nextInt();
        List<WhiteRose> array = new ArrayList<>();
        for (WhiteRose w:
                bouquet
             ) {
            int c = w.getStem_length();
            if (c<b && c>a){
                array.add(w);
            }
        }
        for (WhiteRose w: array
             ) {
            System.out.println(w.getStem_length());
        }
    }
}

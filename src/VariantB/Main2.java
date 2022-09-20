package VariantB;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Eldik eldik = new Eldik("Стандарт", 200, 40);
        Eldik eldik1 = new Eldik("Бизнес", 400, 70);
        Eldik eldik2 = new Eldik("Билим", 100, 10);

        List<Eldik> bouquet = new ArrayList<>();

        bouquet.add(eldik);
        bouquet.add(eldik1);
        bouquet.add(eldik2);

        Collections.sort(bouquet, new Comparator<Eldik>() {
            @Override
            public int compare(Eldik o1, Eldik o2) {
                return o1.getPayment() - o2.getPayment();
            }
        });
        for (Eldik w:
                bouquet
        ) {
            System.out.print(bouquet.indexOf(w)+1+" ");
            System.out.println(w.getName());
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = in.nextInt();
        System.out.println("Введите второе число: ");
        int b = in.nextInt();
        List<Eldik> array = new ArrayList<>();
        for (Eldik w:
                bouquet
        ) {
            int c = w.getParameter();
            if (c<=b && c>=a){
                array.add(w);
            }
        }
        for (Eldik w: array
        ) {
            System.out.print("Находится в диапазоне ");
            System.out.println(w.getName());
        }
    }
}

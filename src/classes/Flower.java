package classes;

import enums.EFlowerCategory;
import enums.EFlowerColor;
import interfaces.FlowerForSale;

public class Flower extends AFlower implements FlowerForSale, Comparable <Flower> {

    private int flowerCode;

    private String flowerName;

    private EFlowerColor flowerColor;

    private String flowerColorName;

    private EFlowerCategory flowerCategory;

    private String flowerCategoryName;


    private float flowerCost;

    public Flower (int flowerCode, String flowerName,
                   String flowerColorName, EFlowerColor flowerColor,
                   String flowerCategoryName, EFlowerCategory flowerCategory,
                   float flowerCost) {
        // вызываем родительский конструктор для создания объекта
        super(flowerCode, flowerName, flowerColorName, flowerColor, flowerCategoryName, flowerCategory);

        // заносим значение цены цветка
        this.flowerCost = flowerCost;
    }

    public float getFlowerCost() {
        return flowerCost;
    }


    public void setFlowerCost(float flowerCost) {
        this.flowerCost = flowerCost;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Flower)) return false;

        Flower flower = (Flower) obj;

        if (this.flowerCode != flower.flowerCode) return false;
        if (this.flowerCategory != flower.flowerCategory) return false;
        if (!this.flowerCategoryName.equals(flower.flowerCategoryName)) return false;
        if (this.flowerColor != flower.flowerColor) return false;
        if (!this.flowerColorName.equals(flower.flowerColorName)) return false;
        if (!this.flowerName.equals(flower.flowerName)) return false;
        if (this.flowerCost != flower.flowerCost) return false;

        return true;
    }


    @Override
    public String toString() {
        return getClass().getName() + " "
                + "Code: " + getFlowerCode()
                + " Категория и цвет: " + getFlowerName() + " (" + getFlowerColorName()+ ")"
                + " Цена:" + getFlowerCost();
    }

    @Override
    public int compareTo(Flower obj) {
        return Float.compare(this.flowerCost, obj.flowerCost);
    }

}
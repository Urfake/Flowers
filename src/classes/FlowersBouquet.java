package classes;

import java.util.ArrayList;
import java.util.List;

public class FlowersBouquet implements Comparable <FlowersBouquet> {

    // Код букета цветов
    private int flowersBouquetCode;

    // список цветов в букете
    private List<Flower> flowersBouquetList = new ArrayList<Flower>();

    // стоимсоть букета цветов
    private float fullCost = 0.00f;

    public FlowersBouquet() {
    }

    public FlowersBouquet(int flowersBouquetCode) {
        this.flowersBouquetCode = flowersBouquetCode;
    }

    public FlowersBouquet(int flowersBouquetCode, List<Flower> fbl) {
        this.flowersBouquetCode = flowersBouquetCode;
        this.flowersBouquetList = fbl;
    }

    public List<Flower> getFlowersBouquetList() {
        return flowersBouquetList;
    }

    public void setFlowersBouquetList(List<Flower> fal) {
        this.flowersBouquetList = fal;
    }

    public void addFlower(Flower flw) {
        flowersBouquetList.add(flw);
        calculateBouquetCost();
    }


    public void removeFlower(int indexFlower) {
        flowersBouquetList.remove(indexFlower);
        calculateBouquetCost();
    }

    public void calculateBouquetCost() {
        float tmpCost = 0.00f;

        if (flowersBouquetList.size() > 0) {
            for (Flower flower : flowersBouquetList) {
                tmpCost += flower.getFlowerCost();
            }
        }

        this.fullCost = tmpCost;
    }

    public Flower getFlowerByItemIndex(int itemIndex) {
        return flowersBouquetList.get(itemIndex);
    }

    public int getFlowersBouquetCount() {

        return this.flowersBouquetList.size();
    }

    public float getFullCost() {
        return fullCost;
    }

    public int getFlowersBouquetCode() {
        return flowersBouquetCode;
    }

    public void setFlowersBouquetCode(int flowersBouquetCode) {
        this.flowersBouquetCode = flowersBouquetCode;
    }

    @Override
    public int compareTo(FlowersBouquet obj) {
        return Float.compare(this.fullCost, obj.fullCost);
    }

    @Override
    public String toString() {
        return getClass().getName()
                + " Code: " + getFlowersBouquetCode()
                + " Количество цветов в букете: " + getFlowersBouquetCount()
                + " Общая стоимость цветов в букете: " + getFullCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowersBouquet)) return false;

        FlowersBouquet that = (FlowersBouquet) o;

        if (flowersBouquetCode != that.flowersBouquetCode) return false;
        if (Float.compare(that.fullCost, fullCost) != 0) return false;

        return true;
    }


    public void printFlowersFromBouquet() {
        StringBuilder printInfo = new StringBuilder().append("\nСписок цветов в букете № " + this.getFlowersBouquetCode() + ": ");

        for (Flower flower : this.flowersBouquetList) {
            printInfo.append("\nCode: " + flower.getFlowerCode())
                    .append(" Категория и цвет: " + flower.getFlowerName() + " (" + flower.getFlowerColorName()+ ")")
                    .append(" Цена:" + flower.getFlowerCost() + "\n");
        }

        System.out.println(printInfo);
    }
}
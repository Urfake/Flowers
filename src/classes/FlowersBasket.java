package classes;

import java.util.ArrayList;
import java.util.List;

public class FlowersBasket implements Comparable <FlowersBasket> {

    // Код корзины цветов
    private int flowersBasketCode;

    // Наименование корзины цветов
    private String flowersBasketName;

    // список цветов в корзине
    private List<Flower> flowersBasketList = new ArrayList<Flower>();

    // стоимость цветов в корзине
    private float fullCost = 0.00f;

    public FlowersBasket() {
    }

    public FlowersBasket(int flowersBasketCode, String flowersBasketName) {
        this.flowersBasketCode = flowersBasketCode;
        this.flowersBasketName = flowersBasketName;
    }

    public FlowersBasket(int flowersBasketCode, String flowersBasketName, List<Flower> fbl) {
        this.flowersBasketList = fbl;
        this.flowersBasketCode = flowersBasketCode;
        this.flowersBasketName = flowersBasketName;
    }


    public List<Flower> getFlowersBasketList() {
        return flowersBasketList;
    }


    public void setFlowerBasketList(List<Flower> fal) {
        this.flowersBasketList = fal;
    }


    public void addFlower(Flower flw) {
        flowersBasketList.add(flw);

        calculateBasketCost();
    }


    public void removeFlower(int indexFlower) {
        flowersBasketList.remove(indexFlower);

        calculateBasketCost();
    }


    public Flower getFlowerByItemIndex(int itemIndex) {
        return flowersBasketList.get(itemIndex);
    }


    public void calculateBasketCost() {
        float tmpCost = 0.00f;

        if (flowersBasketList.size() > 0) {
            for (Flower flower : flowersBasketList) {
                tmpCost += flower.getFlowerCost();
            }
        }

        this.fullCost = tmpCost;
    }


    public int getFlowersBasketCount() {
        return this.flowersBasketList.size();
    }


    public float getFullCost() {
        return fullCost;
    }

    /*
     * Переопределенный метод для сравнения стоимости корзины текущего объекта
     * со стоимостью корзины объекта переданного для сравнения
     */
    @Override
    public int compareTo(FlowersBasket obj) {
        return Float.compare(this.fullCost, obj.fullCost);
    }

    public String getFlowersBasketName() {
        return flowersBasketName;
    }

    public void setFlowersBasketName(String flowersBasketName) {
        this.flowersBasketName = flowersBasketName;
    }

    public int getFlowersBasketCode() {
        return flowersBasketCode;
    }

    public void setFlowersBasketCode(int flowersBasketCode) {
        this.flowersBasketCode = flowersBasketCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowersBasket)) return false;

        FlowersBasket that = (FlowersBasket) o;

        if (flowersBasketCode != that.flowersBasketCode) return false;
        if (Float.compare(that.fullCost, fullCost) != 0) return false;
        if (!flowersBasketName.equals(that.flowersBasketName)) return false;

        return true;
    }


    @Override
    public String toString() {
        return getClass().getName()
                + " Code: " + getFlowersBasketCode()
                + " Наименование корзины: " + getFlowersBasketName()
                + " Количество цветов в корзине: " + getFlowersBasketCount()
                + " Общая стоимость цветов в корзине: " + getFullCost();
    }

    public void printFlowersFromBasket() {
        StringBuilder printInfo = new StringBuilder();

        printInfo.append("Список цветов в корзине " + getFlowersBasketName() + ": \n");
        for (Flower flower : this.flowersBasketList) {
            printInfo.append("Code: " + flower.getFlowerCode())
                    .append(" Категория и цвет: " + flower.getFlowerName() + " (" + flower.getFlowerColorName() + ")")
                    .append(" Цена:" + flower.getFlowerCost() + "\n");
        }

        System.out.println(printInfo);
    }
}
package classes;

import enums.EFlowerCategory;
import enums.EFlowerColor;

import java.util.ArrayList;
import java.util.List;

public class FlowersBasketsBouquetsFabric {

    // список букетов цветов
    private List<FlowersBouquet> flowersBouquetList = new ArrayList<FlowersBouquet>();

    // список корзин цветов для формирования букетов
    private List<FlowersBasket> flowersBasketList = new ArrayList<FlowersBasket>();

    /**
     * Конструктор фабрики по умолчанию
     */
    public FlowersBasketsBouquetsFabric() {

    }

    public List<FlowersBouquet> getFlowersBouquetList() {
        return flowersBouquetList;
    }

    public void setFlowersBouquetList(List<FlowersBouquet> flowersBouquetList) {
        flowersBouquetList = flowersBouquetList;
    }

    public List<FlowersBasket> getFlowersBasketList() {
        return flowersBasketList;
    }

    public void setFlowersBasketList(List<FlowersBasket> flowersBasketList) {
        flowersBasketList = flowersBasketList;
    }

    /*
    Метод создает объект цветок для корзины цветов
     */
    public Flower CreateFlower(int flowerCode, String flowerName,
                               String flowerColorName, EFlowerColor flowerColor,
                               String flowerCategoryName, EFlowerCategory flowerCategory,
                               float flowerCost) {
        return new Flower(flowerCode, flowerName, flowerColorName, flowerColor, flowerCategoryName, flowerCategory, flowerCost);
    }

    /*
     Метод создает объект корзину цветов и помещает его в список корзин цветов текущей фабрики объектов
     */
    public FlowersBasket CreateFlowersBasket(int flowersBasketCode, String flowersBasketName) {
        FlowersBasket result = new FlowersBasket(flowersBasketCode, flowersBasketName);

        flowersBasketList.add(result);

        return result;
    }

    /*
     Метод создает объект букет цветов и помещает его в список букетов текущей фабрики объектов
     */
    public FlowersBouquet CreateFlowersBouquet(int flowersBouquetCode) {
        FlowersBouquet result = new FlowersBouquet(flowersBouquetCode);

        flowersBouquetList.add(result);

        return result;
    }

    public float calculateFlowersBasketListCost() {
        float result = 0.00f;

        if (flowersBasketList.size() > 0) {
            for (FlowersBasket basket : flowersBasketList) {
                result += basket.getFullCost();
            }
        }

        return result;
    }

    public float calculateFlowersBouquetListCost() {
        float result = 0.00f;

        if (flowersBouquetList.size() > 0) {
            for (FlowersBouquet bouquet : flowersBouquetList) {
                result += bouquet.getFullCost();
            }
        }

        return result;
    }

    /*
    Метод возвращает индекс корзины в списке корзин цветов
     */
    public static int searchBasketIndexByCode(List<FlowersBasket> flowersBasketList, int fCode) {
        int i = -1;

        if (flowersBasketList.size() > 0) {
            i = 0;

            for (FlowersBasket basket : flowersBasketList) {
                if (fCode == basket.getFlowersBasketCode()) {
                    break;
                }
                i++;
            }
        }

        return i;
    }

    /*
    Метод возвращает индекс букета в списке букетов цветов
     */
    public static int searchBouquetIndexByCode(List<FlowersBouquet> flowersBouquetList, int fCode) {
        int i = -1;

        if (flowersBouquetList.size() > 0) {
            i = 0;

            for (FlowersBouquet bouquet : flowersBouquetList) {
                if (fCode == bouquet.getFlowersBouquetCode()) {
                    break;
                }
                i++;
            }
        }

        return i;
    }

    /*
    Метод для поиска цветка определенной категории, цвета и стоимости в указанной корзине цветов
     */
    public static int searchFlowerIndexFromFlwBasket(FlowersBasket fromFlwBasket, EFlowerCategory fCategory,
                                                     String fFlowerName, EFlowerColor fColor, String fColorName, float fCost) {
        int i = -1;

        if (fromFlwBasket.getFlowersBasketList().size() > 0) {
            i = 0;

            for (Flower flower : fromFlwBasket.getFlowersBasketList()) {
                if (fColor == EFlowerColor.OTHER_COLOR) {
                    if (flower.getFlowerCategory()== fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerColor() == fColor
                            && flower.getFlowerColorName().equals(fColorName)
                            && flower.getFlowerCost() == fCost) {

                        break;
                    }
                } else {
                    if (flower.getFlowerCategory()== fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerColor() == fColor
                            && flower.getFlowerCost() == fCost) {

                        break;
                    }
                }

                i++;
            }
        }

        return i;
    }

    /*
     Метод для поиска цветка определенной категории, цвета и стоимости в указанном букете цветов
     */
    public static int searchFlowerIndexFromFlwBouquet(FlowersBouquet fromFlwBouquet, EFlowerCategory fCategory,
                                                      String fFlowerName, EFlowerColor fColor, String fColorName, float fCost) {
        int i = -1;

        if (fromFlwBouquet.getFlowersBouquetList().size() > 0) {
            i = 0;

            for (Flower flower : fromFlwBouquet.getFlowersBouquetList()) {
                if (fColor == EFlowerColor.OTHER_COLOR) {
                    if (flower.getFlowerCategory()== fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerColor() == fColor
                            && flower.getFlowerColorName().equals(fColorName)
                            && flower.getFlowerCost() == fCost) {

                        break;
                    }
                } else {
                    if (flower.getFlowerCategory()== fCategory
                            && flower.getFlowerName().equals(fFlowerName)
                            && flower.getFlowerColor() == fColor
                            && flower.getFlowerCost() == fCost) {

                        break;
                    }
                }

                i++;
            }
        }

        return i;
    }

    /*
    Метод добавляет цветы из указанной корзины в букет
     */
    public static void addFlowerToBouquet(FlowersBasket fromFlwBasket, FlowersBouquet toFlwBouquet,
                                          EFlowerCategory fCategory, String fFlowerName, EFlowerColor fColor, String fColorName,
                                          float fCost, int fCount) {

        int currentIndexFlower;

        for (int i = 0; i < fCount; i++) {
            currentIndexFlower = searchFlowerIndexFromFlwBasket(fromFlwBasket, fCategory, fFlowerName, fColor, fColorName, fCost);

            if (currentIndexFlower == -1) {
                System.out.println("Цветок с такими параметрами отсутствует в корзине!");
                break;
            } else {
                // добавим цветок из корзины в букет
                toFlwBouquet.addFlower(fromFlwBasket.getFlowerByItemIndex(currentIndexFlower));
                // удалим из корзины этот цветок
                fromFlwBasket.removeFlower(currentIndexFlower);
            }
        }
    }


    public static void backFlowerToBasket(FlowersBouquet fromFlwBouquet, FlowersBasket toFlwBasket,
                                          EFlowerCategory fCategory, String fFlowerName,
                                          EFlowerColor fColor, String fColorName, float fCost, int fCount) {

        int currentIndexFlower;

        for (int i = 0; i < fCount; i++) {
            currentIndexFlower = searchFlowerIndexFromFlwBouquet(fromFlwBouquet, fCategory, fFlowerName, fColor, fColorName, fCost);

            if (currentIndexFlower == -1) {
                System.out.println("Цветок с такими параметрами отсутствует в букете!");
                break;
            } else {
                // добавим цветок из букета в корзину цветов
                toFlwBasket.addFlower(fromFlwBouquet.getFlowerByItemIndex(currentIndexFlower));
                // удалим из букета этот цветок
                fromFlwBouquet.removeFlower(currentIndexFlower);
            }
        }
    }

    /*
     * Метод выводит в консоль информацию о списке корзин цветов
     */
    public void printBasketsFromListBasket() {
        StringBuilder printInfo = new StringBuilder();

        printInfo.append("\nВсего корзин с цветами: ")
                .append(flowersBasketList.size())
                .append("\nОбщая стоимость корзин с цветами: ")
                .append(calculateFlowersBasketListCost())
                .append(" \nСписок корзин состоит из: ");

        for (FlowersBasket basket : this.flowersBasketList) {
            printInfo.append("\n Code: ")
                    .append(basket.getFlowersBasketCode())
                    .append(" Наименование корзины: ")
                    .append(basket.getFlowersBasketName())
                    .append(" Количество цветов в корзине: ")
                    .append(basket.getFlowersBasketCount())
                    .append(" Стоимость корзины: ")
                    .append(basket.getFullCost());
        }

        System.out.println(printInfo);
    }

    /*
     * Метод выводит в консоль информацию о списке букетов цветов
     */
    public void printBouquetFromListBouquet() {
        StringBuilder printInfo = new StringBuilder();

        printInfo.append("\nВсего букетов с цветами: ")
                .append(flowersBouquetList.size())
                .append("\nОбщая стоимость букетов с цветами: ")
                .append(calculateFlowersBouquetListCost())
                .append("\nСписок букетов состоит из: ");

        for (FlowersBouquet bouquet : this.flowersBouquetList) {
            printInfo.append("\nCode: ")
                    .append(bouquet.getFlowersBouquetCode())
                    .append(" Количество цветов в букете: ")
                    .append(bouquet.getFlowersBouquetCount())
                    .append(" Стоимость букета: ")
                    .append(bouquet.getFullCost());
        }

        System.out.println(printInfo);
    }

}
package util;


import classes.Flower;
import classes.FlowersBasket;
import enums.EFlowerCategory;
import enums.EFlowerColor;

import java.io.*;
import java.util.Properties;

public class PropertiesFilesUtils {
    /*
     * Метод загружает данные для дальнейшего использования из файла определенного формата
     */
    public static void loadFlowersToBasketByPropertiesFile (String fileName, FlowersBasket flowersToBasket, String rowValue) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(fileName);

            prop.load(input);

            autoLoadFlowersToBasket(prop, flowersToBasket, rowValue);
            flowersToBasket.calculateBasketCost();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    Метод загрузки данных(цветов) в корзину цветов из файла
     */
    private static void autoLoadFlowersToBasket (Properties prop, FlowersBasket flowersToBasket, String rowValue) {
        // инициализация переменных для загрузки
        Integer fCount = Integer.valueOf(prop.getProperty("flowerCount" + rowValue));

        Integer fCategory = 4;
        Integer fColor = 4;

        Flower flw;
        EFlowerCategory flowerCategory;
        EFlowerColor flowerColor;

        int tmpFirstIndex = flowersToBasket.getFlowersBasketList().size() + 1;
        fCount = (tmpFirstIndex - 1) + fCount;

        for (int i = tmpFirstIndex; i <= fCount; i++) {

            fCategory = Integer.valueOf(prop.getProperty("flowerCategory" + rowValue));
            switch (fCategory) {
                case 0:
                    flowerCategory = EFlowerCategory.ROSE;
                    break;
                case 1:
                    flowerCategory = EFlowerCategory.LILIA;
                    break;
                case 2:
                    flowerCategory = EFlowerCategory.FIALKA;
                    break;
                case 3:
                    flowerCategory = EFlowerCategory.ASTRA;
                    break;
                case 4:
                    flowerCategory = EFlowerCategory.OTHER_CATEGORY;
                    break;
                default:
                    flowerCategory = EFlowerCategory.OTHER_CATEGORY;
            }

            fColor = Integer.valueOf(prop.getProperty("flowerColor" + rowValue));
            switch (fColor) {
                case 0:
                    flowerColor = EFlowerColor.WHITE;
                    break;
                case 1:
                    flowerColor = EFlowerColor.BLACK;
                    break;
                case 2:
                    flowerColor = EFlowerColor.RED;
                    break;
                case 3:
                    flowerColor = EFlowerColor.YELLOW;
                    break;
                case 4:
                    flowerColor = EFlowerColor.OTHER_COLOR;
                    break;
                default:
                    flowerColor = EFlowerColor.OTHER_COLOR;
            }

            // используем для загрузки конструктор, который реализован в классе Flower
            flw = new Flower(i, prop.getProperty("flowerName" + rowValue),
                    prop.getProperty("flowerColorName" + rowValue),
                    flowerColor,
                    prop.getProperty("flowerCategoryName" + rowValue),
                    flowerCategory,
                    Float.valueOf(prop.getProperty("flowerCost" + rowValue)));

            // добавим цветок в указанную корзину
            flowersToBasket.addFlower(flw);
        }
    }

    /*
     Метод подготовки данных для сохранения в файл (для дальнейшей загрузки из файла)
     */
    private static void saveFlowerCategoryForStartup (Properties prop, String[] rowData, String rowValue) {
        prop.setProperty("flowerName" + rowValue, rowData[0].toString());
        prop.setProperty("flowerCategory" + rowValue, rowData[1].toString());
        prop.setProperty("flowerCategoryName" + rowValue, rowData[2].toString());
        prop.setProperty("flowerColor" + rowValue, rowData[3].toString());
        prop.setProperty("flowerColorName" + rowValue, rowData[4].toString());
        prop.setProperty("flowerCount" + rowValue, rowData[5].toString());
        prop.setProperty("flowerCost" + rowValue, rowData[6].toString());
    }

    /*
     Метод подготавливает и сохраняет данные для автотестов программы в файл
     */
    public static void savePropertiesStartupToFile (String fileName) {
        System.out.println("\nСоздаем файл с данными для автозагрузки в приложение");

        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream(fileName);

            String[] row0 = {"Роза голландская", "0", "Роза", "0", "Белая", "10", "500.00"};
            saveFlowerCategoryForStartup(prop, row0, "0");
            prop.store(output, null);
            prop.clear();

            String[] row1 = {"Роза местная", "0", "Роза", "1", "Черная", "20", "350.00"};
            saveFlowerCategoryForStartup(prop, row1, "1");
            prop.store(output, null);
            prop.clear();

            String[] row2 = {"Астра", "3", "Астра", "0", "Белая", "50", "200.00"};
            saveFlowerCategoryForStartup(prop, row2, "2");
            prop.store(output, null);
            prop.clear();

            String[] row3 = {"Лилия китайская", "1", "Лилия", "4", "Бело-розовая", "15", "1000.00"};
            saveFlowerCategoryForStartup(prop, row3, "3");
            prop.store(output, null);
            prop.clear();

            String[] row4 = {"Георгин местный", "4", "Георгин", "4", "Бордо", "30", "450.00"};
            saveFlowerCategoryForStartup(prop, row4, "4");
            prop.store(output, null);
            prop.clear();
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

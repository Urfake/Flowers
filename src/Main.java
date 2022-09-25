import classes.FlowersBasketsBouquetsFabric;

import java.util.*;

import static util.ApplicationUtils.*;
import static util.PropertiesFilesUtils.savePropertiesStartupToFile;

public class Main {

    public static void main(String[] args) {
        // загружаем автопараметры для запуска приложения в файл типа Properties
        savePropertiesStartupToFile("load.properties");

        // создадим фабрику объектов для работы приложения
        FlowersBasketsBouquetsFabric myFabric = createMyFabric();

        // демонстрация работы со списком объектов, содержащего корзины цветов
        workBasketsByMyFabric(myFabric);

        // демонстрация работы со списком объектов, содержащего букеты цветов
        workBouquetsByMyFabric(myFabric);
    }
}

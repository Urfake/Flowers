package interfaces;

import enums.EFlowerCategory;
import enums.EFlowerColor;

public interface IFlower {

    int flowerCode = 0;

    String flowerName = "";

    EFlowerColor flowerColor = EFlowerColor.OTHER_COLOR;

    String flowerColorName = "";

    EFlowerCategory flowerCategory = EFlowerCategory.OTHER_CATEGORY;

    String flowerCategoryName = "";


    public String getFlowerColorName();

    public void setFlowerColorName(String flowerColorName);


    public String getFlowerCategoryName();

    public void setFlowerCategoryName(String flowerCategoryName);


    public String getCategoryNameByCategory(EFlowerCategory fc);

    public String getColorNameByColor(EFlowerColor fc);

}
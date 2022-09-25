package classes;

import enums.EFlowerCategory;
import enums.EFlowerColor;
import interfaces.IFlower;

public abstract class AFlower implements IFlower {

    int flowerCode;

    String flowerName;

    EFlowerColor flowerColor;

    String flowerColorName;


    EFlowerCategory flowerCategory;

    String flowerCategoryName;


    public AFlower() {
    }

    public AFlower(int flowerCode, String flowerName, EFlowerColor flowerColor, EFlowerCategory flowerCategory){
        this.flowerCode = flowerCode;
        this.flowerName = flowerName;
        this.flowerColor = flowerColor;
        this.flowerCategory = flowerCategory;
    }

    public AFlower(int flowerCode, String flowerName,
                   String flowerColorName, EFlowerColor flowerColor,
                   String flowerCategoryName, EFlowerCategory flowerCategory){
        this.flowerCode = flowerCode;
        this.flowerName = flowerName;
        this.flowerColor = flowerColor;
        this.flowerColorName = flowerColorName;
        this.flowerCategory = flowerCategory;
        this.flowerCategoryName = flowerCategoryName;
    }


    public int getFlowerCode() {
        return flowerCode;
    }


    public void setFlowerCode(int flowerCode) {
        this.flowerCode = flowerCode;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }


    public EFlowerColor getFlowerColor() {
        return flowerColor;
    }


    public void setFlowerColor(EFlowerColor flowerColor) {
        this.flowerColor = flowerColor;
    }


    public String getFlowerColorName() {
        return flowerColorName;
    }


    public void setFlowerColorName(String flowerColorName) {
        if (this.flowerColorName == null || this.flowerColorName.isEmpty())
            this.flowerColorName = getColorNameByColor(this.flowerColor);
        else this.flowerColorName = flowerColorName;
    }


    public EFlowerCategory getFlowerCategory() {
        return flowerCategory;
    }


    public void setFlowerCategory(EFlowerCategory flowerCategory) {
        this.flowerCategory = flowerCategory;
    }


    public String getFlowerCategoryName() {
        return flowerCategoryName;
    }


    public void setFlowerCategoryName(String flowerCategoryName) {
        if (this.flowerCategoryName == null || this.flowerCategoryName.isEmpty())
            this.flowerCategoryName = getCategoryNameByCategory(this.flowerCategory);
        else this.flowerCategoryName = flowerCategoryName;
    }


    public String getCategoryNameByCategory(EFlowerCategory fc) {
        return EFlowerCategory.getNameByCategory(fc);
    }


    public String getColorNameByColor(EFlowerColor fc) {
        return EFlowerColor.getColorNameByColor(fc);
    }

    /**
     * Метод позволяет сравнить на идентичность текущий объект класса цветок с переданным для сравнения
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AFlower)) return false;

        AFlower aFlower = (AFlower) obj;

        if (flowerCode != aFlower.flowerCode) return false;
        if (flowerCategory != aFlower.flowerCategory) return false;
        if (!flowerCategoryName.equals(aFlower.flowerCategoryName)) return false;
        if (flowerColor != aFlower.flowerColor) return false;
        if (!flowerColorName.equals(aFlower.flowerColorName)) return false;
        if (!flowerName.equals(aFlower.flowerName)) return false;

        return true;
    }
}
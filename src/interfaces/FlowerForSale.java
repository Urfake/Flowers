package interfaces;

public interface FlowerForSale extends IFlower {
    // цена цветка
    float flowerCost = 0.00f;

    float getFlowerCost();

    void setFlowerCost(float flowerCost);
}
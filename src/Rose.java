public class Rose {
    private int freshness, stem_length, price;

    public Rose(int freshness, int stem_length, int price) {
        this.freshness = freshness;
        this.stem_length = stem_length;
        this.price = price;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    public int getStem_length() {
        return stem_length;
    }

    public void setStem_length(int stem_length) {
        this.stem_length = stem_length;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

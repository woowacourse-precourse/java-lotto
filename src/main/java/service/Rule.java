package service;

public enum Rule {
    PER_LOTTO(1000, 1, 45, 6);

    private int price;
    private int minNumber;
    private int maxNumber;
    private int count;

    Rule(int price, int minNumber, int maxNumber, int count) {
        this.price = price;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.count = count;
    }

    public int getPrice() {
        return this.price;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getCount() {
        return count;
    }

}

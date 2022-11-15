package lotto;

public enum Mathing {
    th(3,5000),rd(4,50000),nd(5,1500000),exp(-1,30000000),st(6,2000000000);
    private final int num;
    private final int price;
    Mathing(int num,int price) {
        this.num=num;
        this.price=price;
    }

    public int getNum() {
        return num;
    }

    public int getPrice() {
        return price;
    }
}

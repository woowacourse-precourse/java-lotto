package lotto;

public enum Winning {
    first(2000000000, "6개 일치 (2,000,000,000원)"),
    second(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    third(1500000, "5개 일치 (1,500,000원)"),
    fourth(50000, "4개 일치 (50,000원)"),
    fifth(5000, "3개 일치 (5,000원)"),
    ;

    final private int price;
    final private String describe;

    public int getPrice() {
        return price;
    }

    public String getDescribe() {
        return describe;
    }

    Winning(Integer price, String describe) {
        this.price = price;
        this.describe = describe;
    }
}

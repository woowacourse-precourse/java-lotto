package lotto.domain;

public enum Rank {
    fifth(3, 5000),
    fourth(4, 50000),
    third(5, 1500000),
    second(6, 30000000),
    first(7, 2000000000),
    ;
    private int correctCount;
    private int price;

    Rank(int correctCount, int price) {
        this.correctCount = correctCount;
        this.price = price;
    }
}

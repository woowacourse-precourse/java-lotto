package lotto.domain;

public enum Rank {
    fifth(3, 5000,"3개 일치 (5,000원) - "),
    fourth(4, 50000,"4개 일치 (50,000원) - "),
    third(5, 1500000,"5개 일치 (1,500,000원) - "),
    second(6, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    first(7, 2000000000,"6개 일치 (2,000,000,000원) - "),
    ;
    private int correctCount;
    private int price;

    private String priceMessage;

    Rank(int correctCount, int price,String priceMessage) {
        this.correctCount = correctCount;
        this.price = price;
        this.priceMessage = priceMessage;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrice() {
        return price;
    }
    public String getPriceMessage(){
        return priceMessage;
    }
}

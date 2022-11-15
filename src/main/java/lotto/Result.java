package lotto;

public enum Result {
    Three("3개 일치 (5,000원)", 5000), Four("4개 일치 (50,000원)", 50_000), Five("5개 일치 (1,500,000원)", 1_500_000), FiveBonus(
            "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000), Six("6개 일치 (2,000,000,000원)", 2_000_000_000),
    ;

    String message;
    int price;

    Result(String message, int price) {
        this.message = message;
        this.price = price;
    }
}

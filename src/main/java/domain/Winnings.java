package domain;

public enum Winnings {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NONE("2개 이하", 0);

    private final String expression;
    private final int price;

    Winnings(String expression, int price) {
        this.expression = expression;
        this.price = price;
    }

    public String getExpression() {
        return expression;
    }

    public int getPrice() {
        return price;
    }
}

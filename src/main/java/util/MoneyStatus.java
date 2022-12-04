package util;

public enum MoneyStatus {
    MONEY_DIVIDE(1000),
    ROUND(10),
    PERCENT(100);
    private final int status;

    MoneyStatus(int moneyStatus) {
        this.status = moneyStatus;
    }

    public int getStatus() {
        return status;
    }
}

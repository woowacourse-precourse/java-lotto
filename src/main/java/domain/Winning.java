package domain;

public enum Winning {
    FIRST("6개 일치", "2,000,000,000원", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000원", 30_000_000),
    THIRD("5개 일치", "1,500,000원", 1_500_000),
    FOURTH("4개 일치", "50,000원", 50_000),
    FIFTH("3개 일치", "5,000원", 5_000);

    private final String DESCRIPTION;
    private final String SRING_PRICE;
    private final int PRICE;
    private int count;

    Winning(String DESCRIPTION, String SRING_PRICE, int PRICE) {
        this.DESCRIPTION = DESCRIPTION;
        this.SRING_PRICE = SRING_PRICE;
        this.PRICE = PRICE;
        this.count = 0;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getSRING_PRICE() {
        return "("+SRING_PRICE+")";
    }

    public int getPRICE() {
        return PRICE;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

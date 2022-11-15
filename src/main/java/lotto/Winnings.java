package lotto;

enum Winnings {
    FirstPlace(2000000000, "6개 일치 (2,000,000,000원) - "),
    SecondPlace(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ThirdPlace(1500000, "5개 일치 (1,500,000원) - "),
    FourthPlace(50000, "4개 일치 (50,000원) - "),
    FifthPlace(5000, "3개 일치 (5,000원) - ");


    private final int amount;
    private final String info;

    /**
     * Award constructor.
     * Constructor is private since all instances are created within the Enum
     * @param amount Winning amount
     */
    Winnings(int amount, String info) {
        this.amount = amount;
        this.info = info;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getInfo() {
        return this.info;
    }
}

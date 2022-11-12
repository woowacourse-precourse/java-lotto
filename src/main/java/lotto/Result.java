package lotto;

public enum Result {
    FIRST(2000000000, "(2,000,000,000원) - ", "6개 일치 " ),
    SECOND(30000000, "(30,000,000원) - ", "5개 일치, 보너스 볼 일치 "),
    THIRD(1500000, "(1,500,000원) - ", "5개 일치 "),
    FOURTH(50000, "(50,000원) - ", "4개 일치 "),
    FIFTH(5000, "(5,000원) - ", "3개 일치 ");

    private final int intPrize;
    private final String stringPrize;
    private final String standard;

    Result(int intPrize, String stringPrize, String standard) {
        this.intPrize = intPrize;
        this.stringPrize = stringPrize;
        this.standard = standard;
    }

    public int getIntPrize() {
        return intPrize;
    }
    public String getStringPrize() {
        return stringPrize;
    }
    public String getStandard() {
        return standard;
    }

}

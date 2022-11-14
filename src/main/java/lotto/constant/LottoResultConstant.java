package lotto.constant;

public enum LottoResultConstant {
    EMPTY(null,0),
    CORRECT_THREE("3개 일치 (" + IntConstant.THREE_CORRECT_MONEY.getMoneyValue() + "원) - ",
            IntConstant.THREE_CORRECT_MONEY.getValue()),
    CORRECT_FOUR("4개 일치 (" + IntConstant.FOUR_CORRECT_MONEY.getMoneyValue() + "원) - ",
            IntConstant.FOUR_CORRECT_MONEY.getValue()),
    CORRECT_FIVE("5개 일치 (" + IntConstant.FIVE_CORRECT_MONEY.getMoneyValue() + "원) - ",
            IntConstant.FIVE_CORRECT_MONEY.getValue()),
    CORRECT_FIVE_CORRECT_BONUS("5개 일치, 보너스 볼 일치 (" + IntConstant.FIVE_CORRECT_BONUS_CORRECT.getMoneyValue() + "원) - ",
            IntConstant.FIVE_CORRECT_BONUS_CORRECT.getValue()),
    CORRECT_SIX("6개 일치 (" + IntConstant.SIX_CORRECT_MONEY.getMoneyValue() + "원) - ",
            IntConstant.SIX_CORRECT_MONEY.getValue());

    private final String resultString;
    private final int resultMoney;


    LottoResultConstant(String resultString, int resultMoney) {
        this.resultString = resultString;
        this.resultMoney = resultMoney;
    }

    public String getResultString() {
        return resultString;
    }

    public int getResultMoney() {
        return resultMoney;
    }


}

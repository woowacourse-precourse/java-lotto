package lotto.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public enum PrizeMoneyMessage {
    FIFTH_GRADE(LottoConstant.MATCH_NUMBER_FIFTH_GRADE.getValue() +"개 일치 ("
            + LottoConstant.LOTTO_PRIZE_MONEY_FIFTH_GRADE.getString() + "원) - ")
    ,FOURTH_GRADE(LottoConstant.MATCH_NUMBER_FOURTH_GRADE.getValue() +"개 일치 ("
            + LottoConstant.LOTTO_PRIZE_MONEY_FOURTH_GRADE.getString() + "원) - ")
    ,THIRD_GRADE(LottoConstant.MATCH_NUMBER_THIRD_GRADE.getValue() +"개 일치 ("
            + LottoConstant.LOTTO_PRIZE_MONEY_THIRD_GRADE.getString() + "원) - ")
    ,SECOND_GRADE(LottoConstant.MATCH_NUMBER_THIRD_GRADE.getValue() +"개 일치, 보너스 볼 일치 ("
            + LottoConstant.LOTTO_PRIZE_MONEY_SECOND_GRADE.getString() + "원) - ")
    ,FIRST_GRADE(LottoConstant.MATCH_NUMBER_FIRST_GRADE.getValue() +"개 일치 ("
            + LottoConstant.LOTTO_PRIZE_MONEY_FIRST_GRADE.getString() + "원) - ")
    ;
    private final String message;
    public String getMessage(int count) {
        return message + count + "개";
    }
    PrizeMoneyMessage(String message) {
        this.message = message;
    }
}

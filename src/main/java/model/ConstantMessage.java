package model;

public enum ConstantMessage {
    BUYING_LOTTO_MESSAGE("개를 구매했습니다."),
    WINNING_STATS_MESSAGE("당첨 통계 :"),
    NUMBER_MATCH_FORMAT_MESSAGE("개 일치 ("),
    NUMBER_BONUS_MATCH_FORMAT_MESSAGE("개 일치, 보너스 볼 일치 ("),
    MONEY_FORMAT_MESSAGE("원) - "),
    NUMBER_FORMAT_MESSAGE("개"),
    PROFIT_RATE_MESSAGE("총 수익률은 "),
    PERCENT_MESSAGE("%입니다."),
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String constant;
            
    ConstantMessage(String constant){
        this.constant = constant;
    }

    public String getConstant(){
        return constant;
    }
}

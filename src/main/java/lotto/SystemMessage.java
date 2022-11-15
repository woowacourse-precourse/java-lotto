package lotto;

public enum SystemMessage {
    INPUT_MONEY("구매 금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_COUNT("개를 구매했습니다."),
    OUTPUT_RESULT_START("당첨 통계\n---"),
    OUTPUT_RESULT_LOTTO("%s%d개\n"),
    OUTPUT_RATE_OF_RETURN("총 수익률은 %s%%입니다.\n");

    private final String message;

    SystemMessage(String message){
        this.message = message;
    }

    public String print(){
        return message;
    }
}

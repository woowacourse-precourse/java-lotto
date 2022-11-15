package lotto.message;

public enum GameMessage {
    Input_Purchase("구매금액을 입력해 주세요."),
    Input_Lotto_Numbers("당첨 번호를 입력해 주세요."),
    Input_Bonus("보너스 번호를 입력해 주세요."),
    Purchase_Count("개를 구매했습니다."),
    Winnig_Stat("당첨 통계\n---"),
    Three_Match("3개 일치 (5,000원) - "),
    Four_Match("4개 일치 (50,000원) - "),
    Five_Match("5개 일치 (1,500,000원) - "),
    Five_Bonus_Match("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Six_Match("6개 일치 (2,000,000,000원) - "),
    Return_Rate_Prefix("총 수익률은 "),
    Return_Rate_Postfix("%입니다.");

    private final String message;
    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

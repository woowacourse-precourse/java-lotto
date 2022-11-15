package lotto.view;

public enum PrintMessage {
    Guide_InputPurchasePrice("구입 금액을 입력해 주세요."),
    Guide_InputLuckyNumbers("당첨 번호을 입력해 주세요."),
    Guide_InputBonusNumber("보너스 번호를 입력해 주세요."),
    Guide_RemindLottoPurchaseCount("%d개를 구매했습니다.\n"),
    Guide_InformSameNumberCount("%d개의 번호가 일치합니다.\n"),
    Guide_InformSameBonusNumber("보너스 번호가 일치합니다.\n"),
    ;

    private final String message;
    PrintMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}

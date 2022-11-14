package Printer;

public enum Message {

    INPUT_MONEY_MESSAGE("구입금액을 입력해주세요."),
    PURCHASE_CONFIRM_MESSAGE("개를 구매했습니다."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE_TITLE("당첨 통계\n---"),
    WINNING_RESULT_MESSAGE_3CORRECT("3개 일치 (5,000원) - "),
    WINNING_RESULT_MESSAGE_4CORRECT("4개 일치 (50,000원) - "),
    WINNING_RESULT_MESSAGE_5CORRECT("5개 일치 (1,500,000원) - "),
    WINNING_RESULT_MESSAGE_5BONUS_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_RESULT_MESSAGE_6CORRECT("6개 일치 (2,000,000,000원) - ");

    private final String printingMessage;

    Message(String printingMessage) {
        this.printingMessage=printingMessage;
    }

    public String getPrintingMessage() {
        return printingMessage;
    }
}

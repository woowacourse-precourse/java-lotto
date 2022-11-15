package lotto.Enum;

public enum Notice {

    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    BUY_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String notice;
    Notice(String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return notice;
    }

    public void buy(int amount) {
        System.out.println(String.format(BUY_MESSAGE.getNotice(), amount));
    }
}

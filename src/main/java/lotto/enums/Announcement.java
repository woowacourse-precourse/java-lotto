package lotto.enums;

public enum Announcement {
    INSERT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");

    private final String announcement;

    Announcement(String announcement) {
        this.announcement = announcement;
    }

    public void announce() {
        System.out.println(announcement);
    }

}

package lotto.enums;

import java.math.BigInteger;

public enum Announcement {
    INSERT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    NUMBER_OF_PURCHASES("개를 구매했습니다.");

    private final String announcement;

    Announcement(String announcement) {
        this.announcement = announcement;
    }

    public void announce() {
        System.out.println(announcement);
    }
    public void announce(BigInteger numberOfLottos) {
        System.out.println(numberOfLottos + announcement);
    }

}

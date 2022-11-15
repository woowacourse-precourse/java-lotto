package lotto.io;

import java.util.Objects;

public enum Message {

    MONEY_INPUT("구입금액을 입력해 주세요.\n"),
    QUANTITY("\n%d개를 구매했습니다."),
    WINNING_INPUT("\n당첨 번호를 입력해 주세요.\n"),
    BONUS_INPUT("\n보너스 번호를 입력해 주세요.\n"),
    STATISTICS("\n당첨 통계\n---\n"),

    FIRST_RESULT(6, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND_RESULT(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_RESULT(5, "5개 일치 (1,500,000원) - %d개"),
    FOURTH_RESULT(4, "4개 일치 (50,000원) - %d개"),
    FIFTH_RESULT(3, "3개 일치 (5,000원) - %d개"),

    YIELD("총 수익률은 %.1f%%입니다.");

    private Integer key;
    private final String message;

    Message(String message) {
        this.message = message;
    }

    Message(Integer key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getResultMessage(Integer key) {
        for (Message str : Message.values()) {
            if (Objects.equals(str.key, key))
                return str.message;
        }
        return null;
    }
}

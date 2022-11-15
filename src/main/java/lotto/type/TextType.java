package lotto.type;

/**
 * 출력 문구 상수를 모아둔 Enum 클래스
 */
public enum TextType {
    PURCHASE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    WIN_NUMBER_INPUT_MESSAGE("\n당첨 번호를 입력해 주세요"),
    BONUS_NUMBER_INPUT_MESSAGE("\n보너스 번호를 입력해 주세요."),
    TITLE_WIN_DETAILS("\n당첨 통계\n---"),
    THREE_MATCH_MESSAGE_FORMAT("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH_MESSAGE_FORMAT("\n4개 일치 (50,000원) - %d개"),
    FIVE_MATCH_MESSAGE_FORMAT("\n5개 일치 (1,500,000원) - %d개"),
    SIX_WITH_BONUS_MATCH_MESSAGE_FORMAT("\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH_MESSAGE_FORMAT("\n6개 일치 (2,000,000,000원) - %d개"),
    YIELD_MESSAGE_FORMAT("\n총 수익률은 %.1f%%입니다.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

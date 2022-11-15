package lotto.type;

/**
 * 출력 문구 상수를 모아둔 Enum 클래스
 */
public enum TextType {
    PURCHASE_INPUT_MESSAGE("구입금액을 입력해 주세요.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

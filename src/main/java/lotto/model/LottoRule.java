package lotto.model;

public enum LottoRule {
    SIZE(6),
    START_NUMBER(1),
    END_NUMBER(45),
    ;

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public static void validateRange(int number) {
        if (number < START_NUMBER.getValue() || END_NUMBER.getValue() < number) {
            throw new IllegalArgumentException("로또 번호의 범위를 넘어갔습니다. 로또 번호는 " +
                    START_NUMBER + "부터 " + END_NUMBER + "까지 입니다.");
        }
    }

    public static void validateSize(int size) {
        if (size != SIZE.getValue()) {
            throw new IllegalArgumentException("쉼표를 기준으로 " + SIZE + "개의 값을 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

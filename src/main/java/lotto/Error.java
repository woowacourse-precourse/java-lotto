package lotto;

public enum Error {
    NOT_DIGIT_CHARACTER("[ERROR] 숫자가 아닌 문자 입력됨"),
    MONEY_THOUSAND_UNIT("[ERROR] 천 단위 금액 오류"),
    WINNING_NUMS_LENGTH("[ERROR] 당첨 번호 입력 개수 오류"),
    LOTTO_NUM_RANGE("[ERROR] 사용자 당첨 번호 입력 오류");

    private final String desc;

    private Error(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

package lotto.domain;

public enum MSG {
    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WINNING("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE("%d개를 구매했습니다."),
    OUTPUT_STATISTIC("당첨 통계\n---"),
    OUTPUT_YIELD("총 수익률은 %.1f%%입니다."),

    ERR_PURCHASE("[ERROR] 구매금액은 1000원 단위의 숫자만 입력 가능합니다."),
    ERR_WINNING("[ERROR] 당첨번호는 6개 숫자를 콤마(,)로 구분하여 입력해 주세요."),
    ERR_NOT_UNIQUE_NUM("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    ERR_NUMBER_FORMAT("[ERROR] 문자를 입력할 수 없습니다."),
    ERR_NUMBER_RANGE("[ERROR] 입력가능한 숫자의 범위는 1~45입니다.");

    private final String msg;

    MSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

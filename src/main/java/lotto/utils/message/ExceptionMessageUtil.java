package lotto.utils.message;

import lotto.utils.consts.LottoConst;

public enum ExceptionMessageUtil {
    WRONG_NUMBER_FORMAT("입력한 값을 숫자로 치환할 수 없습니다."),

    WRONG_NUMBER_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            LottoConst.MIN_NUMBER_VALUE,
            LottoConst.MAX_NUMBER_VALUE),

    WRONG_NUMBER_SIZE("유효한 숫자는 총 %d개여야만 합니다.",
            LottoConst.NUMBER_SIZE),

    WRONG_PURCHASE_AMOUNT_UNIT("구입 금액은 %d원 단위여야만 합니다.",
            LottoConst.PURCHASE_AMOUNT),

    WRONG_PURCHASE_AMOUNT_VALUE("구입 금액은 %d원 이상이어야만 합니다",
            LottoConst.PURCHASE_AMOUNT),

    WRONG_SEPARATOR("필요한 숫자 구분자 %s가 누락되었습니다.",
            LottoConst.SEPARATOR),

    WRONG_NUMBER_LENGTH("유효하지 않은 길이입니다."),

    WRONG_RANKING("존재하지 않는 등수입니다.");

    private final String message;

    ExceptionMessageUtil(String baseMessage, Object... replaces) {
        this.message = String.format(baseMessage, replaces);
    }

    public String findFullMessage() {
        return this.message;
    }
}

package lotto.error;

import lotto.domain.lotto.LottoInfo;

public enum ErrorMsg {
    WRONG_BUYING_UNIT("[ERROR] 로또의 구입 금액은 "+ LottoInfo.PRICE+"원 단위입니다."),
    WRONG_LOTTO_SIZE("[ERROR] 로또의 길이가 6이 아닙니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또에 중복된 숫자가 존재합니다."),
    WRONG_LOTTO_NUMBER("[ERROR] 로또 범위를 벗어나는 숫자입니다. (범위 : " + LottoInfo.MIN +"~"+LottoInfo.MAX+")"),
    INPUT_ERROR("[ERROR] 잘못된 입력입니다.");

    private final String errorMsg;

    ErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return errorMsg;
    }
}

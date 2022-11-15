package lotto.domain.errorenum;

import lotto.domain.lottoenum.LottoCondition;

public enum LottoError {
    HEAD("[ERROR] "),
    NOT_6_LENGTH(String.format("로또 번호는 총 %d개여야 합니다.", LottoCondition.LENGTH.getValue())),
    DUPLICATE_FOUND("로또 번호는 서로 다른 숫자여야 합니다."),
    NOT_IN_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LottoCondition.MIN.getValue(), LottoCondition.MAX.getValue())),
    WRONG_DELIMITER("쉼표(,)로 구분된 숫자만 입력할 수 있습니다."),
    ACCEPT_ONLY_NUMBER("숫자만 입력할 수 있습니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String code;

    LottoError(String code) {
        this.code = code;
    }

    public static String printError(String code) {
        return HEAD.code + code;
    }

    public String printError() {
        return HEAD.code + code;
    }
}

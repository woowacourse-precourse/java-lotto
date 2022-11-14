package lotto.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/14
 */
public enum ArgumentExceptionMessage {
    INPUT_PURCHASE_AMOUNT_UNCONFORMABLE_VALUE("로또 구매 금액은  "+ LottoConstant.LOTTO_PRICE.getString() +"원 단위의 정수로, " + LottoConstant.LOTTO_PRICE.getValue() + "으로 나누어 떨어져야 합니다.")
    ,INPUT_LOTTO_UNCONFORMABLE_FROM("로또 번호는 숫자와 쉼표(,)로 이루어져야 합니다.")
    ,INPUT_LOTTO_UNCONFORMABLE_NUMBER_RANGE("로또 번호는 " + LottoConstant.LOTTO_RANGE_MIN.getValue() + "부터 " + LottoConstant.LOTTO_RANGE_MAX.getValue() + " 사이의 숫자여야 합니다.")
    ,INPUT_LOTTO_UNCONFORMABLE_LENGTH("로또 번호는 총 " + LottoConstant.LOTTO_LENGTH.getValue() + "개의 숫자여야 합니다.")
    ,INPUT_LOTTO_NUMBER_OVERLAP("로또 번호는 모두 중복되지 않아야 합니다.")
    ,INPUT_NOT_INTEGER("입력된 데이터가 정수가 아닙니다.")
    ;

    private final String message;
    public String getMessage() {
        return "[ERROR] " + message;
    }
    ArgumentExceptionMessage(String message) {
        this.message = message;
    }
}

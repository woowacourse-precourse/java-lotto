package lotto;

public enum Error {
    RANGE_ERROR("로또 번호는 1~45사이의 숫자로 입력해주세요"),
    LENGTH_ERROR("6자리 숫자를 입력해주세요"),
    PURCHASE_UNIT_ERROR("구입금액은 1000원 단위로 입력해주세요 ex)14000"),
    INPUT_FORMAT_ERROR("당첨 번호는 쉼표로 구분해주세요 ex)1,2,3,4,5,6"),
    NONDIGIT_ERROR("숫자만 입력해주세요");
    private String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getText() {
        return errorMessage;
    }
}

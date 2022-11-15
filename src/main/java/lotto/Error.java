package lotto;

public class Error {
    private static final String ERROR = "[ERROR]";

    public static final String errMsg_WrongLottoSize = "로또 번호는 6개로 구성되어야 합니다.";
    public static final String errMsg_WrongLottoNumber = "로또 번호는 1부터 45사이의 숫자로 구성되어야 합니다.";
    public static final String errMsg_ExistSameNumber = "중복된 수가 존재합니다.";
    public static final String errMsg_WrongPurchaseAmount = "로또 구입 금액은 1,000원 단위로 입력하셔야 합니다.";
    public static final String errMsg_ExistNotNumber = "구매금액에 숫자가 아닌것이 포함되어 있습니다.";

    public static void error(String errorMessage) {
        String output = ERROR + errorMessage;
        throw new IllegalArgumentException(output);
    }
}

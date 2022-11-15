package lotto.exception;

public class ExceptionMessages {

    private static final String ERROR = "[ERROR] ";
    public static final String InvalidMoneyMessage = ERROR + "올바른 금액을 입력해주세요.";
    public static final String IndivisibleMoneyMessage = ERROR + "로또긍액 단위 금액을 입력해주세요.";
    public static final String InvalidNumberMessage = ERROR + "숫자형식 이어야 합니다.";
    public static final String InvalidNumbersSizeMessage = ERROR + "로또번호는 6개 입니다.";
    public static final String DuplicateLottoNumbersMessage = ERROR + "서로 다른 번호만 가능합니다.";
    public static final String InvalidBonusNumberMessage = ERROR + "보너스번호는 당첨번호에 없는 번호만 가능합니다.";
}

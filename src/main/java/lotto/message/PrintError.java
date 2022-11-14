package lotto.message;

public class PrintError {
    public static final String LOTTO_SIZE = "[ERROR]: 로또 당첨 숫자에는 6개를 입력해주세요";
    public static final String LOTTO_RANGE = "[ERROR]: 로또 당첨 숫자에는 1이상 45이하의 숫자를 입력해주세요.";
    public static final String LOTTO_OVERLAP = "[ERROR]: 로또 당첨 숫자에는 중복된 숫자를 입력하면 안됩니다.";
    public static final String LOTTO_NUMBER = "[ERROR]: 로또 번호는 숫자만 입력할 수 있습니다.";
    public static final String MONEY_NUMBER = "[ERROR]: 로또를 구매할 돈의 최소 단위는 반드시 1000원이어야 합니다.";
    public static final String MONEY_RANGE = "[ERROR]: 로또를 구매할 돈은 반드시 1000원 이상이어야 합니다.";
    public static final String NUMBER_SIZE = "[ERROR]: 숫자만 입력할 수 있습니다.";
    public static final String BONUS_RANGE = "[ERROR]: 보너스 번호는 반드시 1~45 이내에 숫자여야 합니다.";
    public static final String BONUS_OVERLAP = "[ERROR]: 보너스 번호는 입력한 당첨번호와 중복되어선 안됩니다.";

    private PrintError(){    }
}

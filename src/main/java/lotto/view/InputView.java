package lotto.view;

import com.sun.security.jgss.GSSUtil;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_FORMAT_ERROR = "[ERROR] 입력값 형식이 올바르지 않습니다.";
    public static final String PURCHASE_AMOUNT_SCOPE_ERROR = "[ERROR] 입력값이 0보다 작습니다.";
    public static final String PURCHASE_AMOUNT_DIVIDED_ERROR = "[ERROR] 입력값이 1000으로 나눠떨어지지 않습니다.";
    public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_LENGTH_ERROR = "[ERROR] 로또의 번호 수는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 로또의 번호는 중복되지 않아야 합니다.";

    public InputView() {
    }

    public static void newLine(){
        System.out.println();
    }

    public static void showPurchaseAmountMessage(){
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void showAnswerNumberMessage(){
        System.out.println(INPUT_ANSWER_NUMBER_MESSAGE);
    }

    public static void showBonusNumberMessage(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
    public static int inputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return 1;
    }

    public static void showLottoNumberRangeError(){
        System.out.println(LOTTO_NUMBER_RANGE_ERROR);
    }
}

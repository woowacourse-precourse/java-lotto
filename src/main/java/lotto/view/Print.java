package lotto.view;

import java.util.List;

import static lotto.model.InputNumber.bonusNumber;
import static lotto.model.InputNumber.winNumbers;

public class Print {
    final static String GET_USER_MONEY = "구입 금액을 입력해 주세요.";
    final static String WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    final static String ERROR_WRONGINPUT = "[ERROR] 로또 번호 입력 오류";
    final static String ERROR_NOTNUMBER = "[ERROR] 숫자가 아닌 값을 포함하고 있습니다.";

    public static void requestMoneyMessage() {
        System.out.println(GET_USER_MONEY);
    }

    public static void requestWinNumbers() {
        System.out.println(WIN_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public static void bonusNumber() {
        System.out.println(bonusNumber);
    }

    public static void winNumbers() {
        System.out.println(winNumbers);
    }

    public static void wrongInputError(){
        System.out.println(ERROR_WRONGINPUT);
    }

    public static void notNumberError(){
        System.out.println(ERROR_NOTNUMBER);
    }

    public static void howmanyLottos(int numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }

    public static void getLottos(List<Integer> lottos) {
        System.out.println(lottos);
    }



}

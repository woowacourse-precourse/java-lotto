package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String LOTTO_BUY_RESULT_MESSAGE = "개를 구매했습니다.";
    private static final String NORMAL_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputUI() {

    }

    public int getMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        isValidatedMoney(money);
        return Integer.parseInt(money);
    }

    private void isValidatedMoney(String money) {

    }

    public void getWinningNumbers() {
        getNormalNumbers();
        getBonusNumbers();
    }

    private void getNormalNumbers() {

    }

    private void getBonusNumbers() {

    }
}

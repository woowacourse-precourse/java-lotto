package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.*;


public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTONUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final int lotteryPrice = 1000;
    private static int inputMoney = 0;
    private static int lotteryAmount = 0;

    public int getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void setLotteryAmount(int lotteryAmount) {
        this.lotteryAmount = lotteryAmount;
    }

    public int getLotteryAmount() {
        return lotteryAmount;
    }

    public static String getUserInput() {
        String input = Console.readLine();
        return input;
    }

    public void buyLottoMoney() {
        String input = getUserInput();
        setInputMoney(Integer.parseInt(input));
    }

    public void cntLotto() {
        setLotteryAmount(getInputMoney() / lotteryPrice);
    }

    public int purchasedLotto() {
        System.out.println(MONEY_INPUT_MESSAGE);
        buyLottoMoney();
        cntLotto();
        System.out.println("구매금액: " + inputMoney);
        if (inputMoney % lotteryPrice != 0) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 입력해주세요");
        }
        System.out.println(lotteryAmount + "개를 구매했습니다");

        return lotteryAmount;
    }

    public static List<Integer> makeList(String userInput) {
        String[] arrayInput = userInput.split(",");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < arrayInput.length; i++) {
            userNumbers.add(Integer.valueOf(arrayInput[i]));
        }
        return userNumbers;
    }

    public List<Integer> input_Lotto_Numbers() {
        System.out.println(LOTTONUMBERS_INPUT_MESSAGE);
        List<Integer> list = makeList(getUserInput());
        return list;
    }

}

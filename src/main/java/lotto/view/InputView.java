package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.*;


public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTONUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTONUMBERS_INPUT_EXCEPTION_MESSAGE = "[ERROR] : 중복되지 않는 1~45 사이 숫자를 입력해 주세요";
    private static final String BONUSNUMBER_INPUT_EXCEPTION_MESSAGE = "[ERROR] : 1~45중 로또번호와 중복되지 않는 숫자를 입력해 주세요.";
    private final int lotteryPrice = 1000;
    private static int inputMoney = 0;
    private static int lotteryAmount = 0;
    public static List<Integer> lottoNum;
    public static int bonusNum;

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
        System.out.println(inputMoney);
        if (inputMoney % lotteryPrice != 0) {
            throw new IllegalArgumentException("[ERROR] : 1000원 단위로 입력해주세요");
        }
        System.out.println(lotteryAmount + "개를 구매했습니다");

        return lotteryAmount;
    }

    public static List<Integer> makeList(String userInput) {
        String[] arrayInput = userInput.split(",");
        String joinString = String.join(", ", arrayInput);
        System.out.println(joinString);
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < arrayInput.length; i++) {
            userNumbers.add(Integer.valueOf(arrayInput[i]));
        }
        return userNumbers;
    }

    public void input_Lotto_Numbers() {
        System.out.println(LOTTONUMBERS_INPUT_MESSAGE);
        lottoNum = makeList(getUserInput());
        lotto_Numbers_Validate(lottoNum);

    }

    public void lotto_Numbers_Validate(List<Integer> list) {
        if (list.contains(0)) {
            throw new IllegalArgumentException(LOTTONUMBERS_INPUT_EXCEPTION_MESSAGE);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 45) {
                throw new IllegalArgumentException(LOTTONUMBERS_INPUT_EXCEPTION_MESSAGE);
            }
            if (Collections.frequency(list, list.get(i)) != 1) {
                throw new IllegalArgumentException(LOTTONUMBERS_INPUT_EXCEPTION_MESSAGE);
            }
        }
    }
    public void input_Bonus_Number() {
        System.out.println(BONUS_INPUT_MESSAGE);
        bonusNum = Integer.parseInt(getUserInput());
        bonus_Numbers_Validate(bonusNum);
        System.out.println(bonusNum);
    }

    public void bonus_Numbers_Validate(int bonusNum) {
        if (bonusNum > 45) {
            throw new IllegalArgumentException(BONUSNUMBER_INPUT_EXCEPTION_MESSAGE);
        }
        if (lottoNum.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUSNUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }
}

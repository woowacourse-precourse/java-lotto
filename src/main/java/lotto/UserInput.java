package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public final static String NOT_INTEGER_ERROR = "[ERROR] 정수가 아닙니다.";
    public final static String ILLEGAL_UNIT_ERROR = "[ERROR] 금액의 단위는 1,000원입니다.";
    public final static String BONUS_NUMBER_DUPLICATE_ERROR = "[ERROR] 보너스 번호와 로또 번호는 중복되지 않는 번호여야 합니다.";
    public final static int MONEY_UNIT = 1_000;

    public int getBonusNumber(Lotto lotto) {
        String input = getInput("보너스 번호를 입력해 주세요.");
        int number = safeStringToInt(input);
        validateBonusNumberDuplicate(lotto.getNumbers(), number);
        return number;
    }

    public Lotto getWinningLotto() {
        String input = getInput("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            numbers.add(safeStringToInt(number));
        }
        return new Lotto(numbers);
    }

    public int getMoney() {
        String input = getInput("구입금액을 입력해 주세요.");
        int money = safeStringToInt(input);
        validateMoneyUnit(money);
        return money;
    }

    private void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ILLEGAL_UNIT_ERROR);
        }
    }

    private void validateBonusNumberDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

    public int getAmount(int money) {
        return money / MONEY_UNIT;
    }

    public String getInput(String placeholder) {
        System.out.println(placeholder);
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }

    public int safeStringToInt(String number) {
        int result;
        try {
            result = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }
        return result;
    }
}

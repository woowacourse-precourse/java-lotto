package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.isDigit;

public class User {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    private int userMoney;
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public User(int userMoney, List<Integer> winningNumbers, int bonusNumber) {

        this.userMoney = userMoney;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);

        String inputNum = Console.readLine();
        checkInteger(inputNum);

        int userMoney = Integer.parseInt(inputNum);
        checkUserMoneyUnit(userMoney);

        return userMoney;
    }

    public void checkInteger(String number) {
        if(!number.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void checkUserMoneyUnit(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }

    public void checkWinningNumbers(String inputNumbers) {
        for (char c : inputNumbers.toCharArray()) {
            if (!Character.isDigit(c)) {
                checkComma(c);
            }
        }
    }

    public void checkComma(char c) {
        if (c != ',') {
            throw new IllegalArgumentException("[ERROR] 쉼표를 기준으로 구분해주세요");
        }
    }

    public void checkWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수를 6개만 입력해주세요");
        }
    }

    public void checkNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위 1~45까지만 입력해주세요");
        }
    }
}

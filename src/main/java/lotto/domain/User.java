package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static java.lang.Character.isDigit;

public class User {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    private int userMoney;
    private List<Integer> winningNumbers;
    private int bonusNumber;


    public User(int userMoney, List<Integer> winningNumbers, int bonusNumber) {
        validateUserMoney(userMoney);

        this.userMoney = userMoney;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);

        String money = Console.readLine();
        checkInteger(money);

        return Integer.parseInt(money);
    }

    public void validateUserMoney(int userMoney) {
        if (userMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }

    public void checkInteger(String number) {
        if(!number.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}

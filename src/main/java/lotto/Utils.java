package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Utils {
    SystemMessage systemMessage = new SystemMessage();

    public int inputMoney() {
        systemMessage.inputMoney();
        String inputMoney = Console.readLine();
        blankLine();
        validateMoney(inputMoney);
        int money = Integer.parseInt(inputMoney);
        return money;
    }

    private void blankLine() {
        System.out.println();
    }

    public void validateMoney(String inputMoney) {
        if (!Pattern.matches("[0-9]+", inputMoney)
                || Integer.parseInt(inputMoney) <= 0
                || Math.floorMod(Integer.parseInt(inputMoney), 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 입력이 가능합니다.");
        }
    }

    public int countTicket(int money) {
        int lottoPrice = 1000;
        int count = Math.floorDiv(money, lottoPrice);
        systemMessage.printCount(count);
        return count;
    }
}
package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getInputMoney() {
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]Input error");
        }

        if (money < 1000) throw new IllegalArgumentException("[ERROR]Input error");
        if (money % 1000 != 0) throw new IllegalArgumentException("[ERROR]Input error");

        return money;
    }

    public static Lotto getWinningNumber() {
        String winningNumberInput = Console.readLine();

        if(!winningNumberInput.contains(","))
            throw new IllegalArgumentException("[ERROR]Winning number error");

        String[] winningNumberSplit = ",".split(winningNumberInput);
        if(winningNumberSplit.length != 6)
            throw new IllegalArgumentException("[ERROR]Winning number error");

        List<Integer> winningNunmbers = new ArrayList<>();
        for(String num : winningNumberSplit) {
            try {
                winningNunmbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR]Winning number error");
            }
        }

        return new Lotto(winningNunmbers);
    }
}

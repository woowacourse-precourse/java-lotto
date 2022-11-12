package lotto;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
}

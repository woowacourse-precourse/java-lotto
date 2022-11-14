package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String line = Console.readLine();
        int amountToBuy = Integer.parseInt(line);
        // TODO 1000 단위로 떨어지지 않을 경우 예외 발생



    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();

        System.out.println("구매금액을 입력해 주세요.");
        String buyMoney = Console.readLine();

        int buyLottoMoney = Integer.parseInt(buyMoney);

    }
}



package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        startMessage();
        try {
            Money money = new Money(Console.readLine());

            LottoGenerator lottoList = new LottoGenerator(money.getLottoCount());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }

    public static void startMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}

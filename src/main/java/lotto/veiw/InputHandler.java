package lotto.veiw;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.model.Money;

public class InputHandler {

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            new Money(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

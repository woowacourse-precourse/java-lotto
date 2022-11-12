package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private final int INPUT_UNIT = 1000;
    private int price;

    BuyLotto() {
        this.price = 0;
    }

    private void inputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void buyNumberMessage() {
        System.out.println("\n" + numberOfLottoCount() + "개를 구매했습니다.");
    }
    
    public void inputPrice() {
        inputMessage();
        price = Integer.parseInt(Console.readLine());
        inputPriceException();
        buyNumberMessage();
    }

    private void inputPriceException() {
        if((price % INPUT_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위여야 합니다.");
        }
    }

    public int numberOfLottoCount() {
        return price / INPUT_UNIT;
    }
}

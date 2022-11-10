package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyLotto {
    private final int INPUT_UNIT = 1000;

    public void printMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public int inputPrice() {
        int price = Integer.parseInt(Console.readLine());
        inputPriceException(price);

        return price;
    }

    private void inputPriceException(int price) {
        if((price % INPUT_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위여야 합니다.");
        }
    }

    public int numberOfLottoCount(int price) {
        return price / INPUT_UNIT;
    }
}

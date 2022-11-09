package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyLotto {
    private final int INPUT_UNIT = 1000;

    public void printMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public String inputPrice() {
        String price = Console.readLine();
        inputPriceException(price);

        return price;
    }

    public void inputPriceException(String price) {
        if((Integer.parseInt(price) % INPUT_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위여야 합니다.");
        }
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        LottoPrice.checkPrice(price);

        return price;
    }
}

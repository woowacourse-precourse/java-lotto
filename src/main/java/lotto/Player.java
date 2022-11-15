package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private String pay;
    private int lottoCount;

    public int getLottoCount() {
        return lottoCount;
    }

    public void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Console.readLine();
        payValidate(pay);
        lottoCount = Integer.parseInt(pay) / 1000;
    }

    private void payValidate(String input) {
        Integer price;
        try {
            price = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력 가능합니다");
        }
    }
}

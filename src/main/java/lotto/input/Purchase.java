package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    public Purchase() {
        getPrice();
        validate();
    }

    public static String getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private void validate() {
        throw new IllegalArgumentException();
    }
}

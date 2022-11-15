package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static void validatePrice(String price) throws IllegalArgumentException {
        for (int i = 0; i < price.length(); ++i) {
            if (!('0' <= price.charAt(i) && price.charAt(i) <= '9') ||
                    !(i == 0 && '1' <= price.charAt(i) && price.charAt(i) <= '9')) {
                throw new IllegalArgumentException("[ERROR] 천원 단위의 금액을 입력하셔야 합니다.");
            }
        }
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위의 금액을 입력하셔야 합니다.");
        }
    }


}
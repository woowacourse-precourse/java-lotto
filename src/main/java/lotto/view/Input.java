package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputPrice() {
        System.out.println(InputMessage.NOTICE_INPUT_PRICE.getMessage());
        return Console.readLine();
    }

    public static void validatePrice(String price) throws IllegalArgumentException {
        for (int i = 0; i < price.length(); ++i) {
            if (!('0' <= price.charAt(i) && price.charAt(i) <= '9') ||
                    !(i == 0 && '1' <= price.charAt(i) && price.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
            }
        }
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
        }
    }

}
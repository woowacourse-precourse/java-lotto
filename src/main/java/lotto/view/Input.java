package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPrice() {
        System.out.println(InputMessage.NOTICE_INPUT_PRICE.getMessage());
        return getIntPrice();
    }

    private static void validatePrice(final String price) throws IllegalArgumentException {
        if (price.length() < 4) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
        }
        for (int i = 0; i < price.length(); ++i) {
            if (!('0' <= price.charAt(i) && price.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
            }
        }
        if (price.charAt(0) == '0' || Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.GET_ERROR_FOR_PRICE.getMessage());
        }
    }

    public static int getIntPrice() {
        String price = Console.readLine();
        validatePrice(price);
        return Integer.parseInt(price);
    }


}
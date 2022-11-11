package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumber(String input) {
        int lottoNumber;
        validateNumber(input);
        lottoNumber = Integer.parseInt(input);
        if (lottoNumber < 1 || lottoNumber > 45) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            // TODO: 2022/11/11 에러 메시지 출력 추가
            throw new IllegalArgumentException();
        }
    }

    public static int price() {
        int price;
        String input = Console.readLine();
        validateNumber(input);
        price = Integer.parseInt(input);
        validatePrice(price);
        return price;
    }
}

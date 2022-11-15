package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static boolean isMultipleThousands(int number) {
        return number % 1000 == 0;
    }

    public static void validateLottoPrice(String priceString) {
        int price;
        try {
            price = Integer.parseInt(priceString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (!isMultipleThousands(price)) {
            throw new IllegalArgumentException();
        }
    }

    public static int readLottoPrice() {
        String priceString = Console.readLine();
        validateLottoPrice(priceString);
        return Integer.parseInt(priceString);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price;

        try {
            price = readLottoPrice();
        } catch (Exception e) {
            System.out.println("[ERROR] 입력이 올바르지 않습니다.");
            return;
        }
    }
}

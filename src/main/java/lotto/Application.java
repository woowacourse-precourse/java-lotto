package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {

    static void priceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static boolean checkPrice(int n) {
        if (n % 1000 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void inputPrice() {
        priceMessage();
        String price = Console.readLine();
        System.out.println();
        if (!checkPrice(Integer.parseInt(price))) {
            throw new IllegalArgumentException("[ERROR] 구입금액 형식이 맞지 않습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            inputPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

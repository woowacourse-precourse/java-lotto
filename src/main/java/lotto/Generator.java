package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Generator {

    public static Integer purchasePrice() {
        String userMoney;

        System.out.println("구입 금액을 입력하세요 : ");
        userMoney = Console.readLine();

        return Integer.parseInt(userMoney);
    }

    public static int calculateLottoNum(int userMoney) throws IllegalArgumentException {

        if (userMoney % 1000 == 0) {
            return userMoney/1000;
        }
        throw new IllegalArgumentException();
    }
}

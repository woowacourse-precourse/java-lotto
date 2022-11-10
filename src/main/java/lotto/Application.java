package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {


    }

    public static int inputBuyLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String inputBuyMoney = Console.readLine();

        if(!inputBuyMoney.matches("^[0-9]*$"))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");

        int buyMoney = Integer.parseInt(inputBuyMoney);

        if (buyMoney % 1000 != 0 || buyMoney == 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.");

        return buyMoney;
    }

    public static List<Integer> makeLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

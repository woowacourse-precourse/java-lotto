package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// UI 로직
public class UserIO {

    private List<Lotto> userLottoList;

    public UserIO() {
        userLottoList = new ArrayList<>();
    }

    // 구입 금액 입력
    public int moneySpent() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = Integer.valueOf(input);

        if (money % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return money;
    }

}

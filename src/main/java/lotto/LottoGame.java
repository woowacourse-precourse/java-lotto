package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 금액을 1000원 단위로 입력해주세요.";


    public List<Lotto> pickLottoList(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        while (count > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            count -= 1;
        }
        return lottoList;
    }

    public int countLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
        }
        return money / 1000;
    }

    public int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }
}

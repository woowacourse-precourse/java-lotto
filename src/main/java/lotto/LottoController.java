package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class LottoController {

    public Integer readUserMoney(String userMoney) {
        isDigit(userMoney);
        validateUserMoney(userMoney);

        return Integer.parseInt(userMoney);
    }

    public LinkedList<Lotto> createRandomLotto(int count) {
        LinkedList<Lotto> lottoPool = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> modi = new ArrayList<>(randomNumbers);

            Collections.sort(modi);
            Lotto newLotto = new Lotto(modi);
            lottoPool.add(newLotto);
            /*
            Collections.sort(randomNumbers);
            Lotto newLotto = new Lotto(randomNumbers);
            lottoPool.add(newLotto);
             */
        }

        return lottoPool;
    }


    private void isDigit(String userInput) {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, userInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다");
        }
    }

    private void validateUserMoney(String userInput) {
        int money = Integer.parseInt(userInput);

        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 이상의 금액을 입력해야 합니다");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000 단위의 금액을 입력해야 합니다");
        }
    }
}

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

    public Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> modifiable = new ArrayList<>(randomNumbers);

        Collections.sort(modifiable);
        Lotto newLotto = new Lotto(modifiable);

        return newLotto;
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

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// enum 사용해보자
public class User {

    private final String inputMoney;
    static int money;
    public List<Lotto> userLotto;

    public User(String inputMoney) {
        this.inputMoney = inputMoney;
        setMoneyNumber();
        validateMoney();
        userLotto = setUserLotto();
    }

    private void setMoneyNumber() {
        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액으로 숫자를 입력해주세요.");
        }
    }

    private void validateMoney() {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매해주세요.");
        }
    }

    public List<Lotto> setUserLotto() {
        int numOfLotto = money / 1000;
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto tempLotto = new Lotto(numbers);
            lotto.add(tempLotto);
        }
        return lotto;
    }
}

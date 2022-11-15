package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;

public class Player {

    private Set<Lotto> playerLotto;

    public Set<Lotto> buyLotto(String money) {
        int numberOfLotto = calculate(money);
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        for(int i=0; i< numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            playerLotto.add(new Lotto(numbers));
        }

        for(Lotto lotto : playerLotto) {
            System.out.println(lotto);
        }

        return playerLotto;
    }

    public int calculate(String money) throws IllegalArgumentException {
        int numberOfLotto = 0;
        try {
            numberOfLotto = Integer.parseInt(money) / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (numberOfLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return numberOfLotto;
    }

    public List<Integer> split(String input) {

        return null;
    }

}

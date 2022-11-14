package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User extends Valid {
    private int money;
    private List<Lotto> lottos;

    public User() {
    }

    public void buy() throws IllegalArgumentException {
        String amount = Console.readLine();
        validate(amount);
        setMoney(Integer.parseInt(amount));
        createLotto();
    }

    private void createLotto() throws IllegalArgumentException {
        lottos = new ArrayList<>();
        for (int lotto = 0; lotto < (money / lottoPrice); lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto((numbers)));
        }
    }

    private void validate(String amount) throws IllegalArgumentException {
        isNumeric(amount);
        isCorrectPrice(amount);
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

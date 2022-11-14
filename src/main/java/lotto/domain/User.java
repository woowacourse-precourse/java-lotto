package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User extends Valid {
    private List<Lotto> lottos = new ArrayList<>();
    private HashMap<Rank, Integer> result = new HashMap<>();
    private int money;

    public User() {
    }

    public void buy() throws IllegalArgumentException {
        String amount = Console.readLine();
        validate(amount);
        setMoney(Integer.parseInt(amount));
        createLotto();
    }

    private void createLotto() throws IllegalArgumentException {
        for (int lotto = 0; lotto < (money / lottoPrice); lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto((numbers)));
        }
    }

    private void validate(String amount) throws IllegalArgumentException {
        isNumeric(amount);
        isCorrectPrice(amount);
    }

    public double calcProfit() {
        return Math.round((money / sumReward() * 100) * 10) / 10.0;
    }

    private int sumReward() {
        int sum = 0;
        for (Rank rank : this.result.keySet()) {
            sum += rank.getReward() * this.result.get(rank);
        }
        return sum;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setResult(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public HashMap<Rank, Integer> getResult() {
        return result;
    }
}

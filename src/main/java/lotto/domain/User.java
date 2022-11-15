package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User extends Valid {
    private List<Lotto> lottos;
    private HashMap<Rank, Integer> result;
    private int money;

    public User() {
        lottos = new ArrayList<>();
        result = new HashMap<>();
    }

    public void buy() throws IllegalArgumentException {
        String inputMoney = Console.readLine();
        validate(inputMoney);
        setMoney(Integer.parseInt(inputMoney));
        createLotto();
    }

    private void createLotto() throws IllegalArgumentException {
        for (int lotto = 0; lotto < (money / lottoPrice); lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startLottoNum, endLottoNum, lottoSize);
            lottos.add(new Lotto((numbers)));
        }
    }

    private void validate(String inputMoney) throws IllegalArgumentException {
        isNumeric(inputMoney);
        isCorrectPrice(inputMoney);
    }

    public double calcProfit() {
        return Math.round((sumReward() / (double) money * 100) * 10) / 10.0;
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

    public void saveResult(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public HashMap<Rank, Integer> getResult() {
        return result;
    }
}

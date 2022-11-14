package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class User {
    private int cost;
    private List<List<Integer>> lottoNumbers;

    public User(int cost) {
        lottoNumbers = new ArrayList<>();
        validateCost(cost);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateCost(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다");
        }
    }

    public void makeLottoNumbers() {
        for (int i = 0; i < this.cost / 1000; i++) {
            lottoNumbers.add(pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumbers.get(i));
            System.out.println(lottoNumbers.get(i));
        }

    }
}

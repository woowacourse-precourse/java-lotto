package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.ExceptionConstants.*;

public class User {
    private int cost;
    private List<List<Integer>> lottoNumbers;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public User(String cost) {
        validateCost(cost);
        this.cost = Integer.parseInt(cost);
        this.lottoNumbers = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setLottoNumbers(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private void validateCost(String cost) {
        try {
            if (Integer.parseInt(cost) % 1000 != 0) {
                throw new IllegalArgumentException(USER_INPUT_COST.getValue());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(USER_INPUT_COST_NUMBER.getValue());
        }
    }

    public void makeLottoNumbers() {
        for (int i = 0; i < this.cost / 1000; i++) {
            lottoNumbers.add(pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void checkWinning(List<Integer> numbers, int bonus) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int count = checkNumberByLottoAndWinning(i, numbers);
            if (count == 6) {
                this.first++;
            }
            if (count == 5) {
                checkBonus(i, bonus);
            }
            if (count == 4) {
                this.fourth++;
            }
            if (count == 3) {
                this.fifth++;
            }
        }
    }

    private int checkNumberByLottoAndWinning(int i, List<Integer> numbers) {
        int count = 0;
        for (int j = 0; j < lottoNumbers.get(i).size(); j++) {
            if (lottoNumbers.get(i).contains(numbers.get(j))) {
                count++;
            }
        }
        return count;
    }

    private void checkBonus(int i, int bonus) {
        if (this.lottoNumbers.get(i).contains(bonus)) {
            this.second++;
            return;
        }
        this.third++;
    }

    public float calculateYield() {
        float yield = (float) (fifth * 5000 + fourth * 50000 + third * 1500000 + second * 30000000 + first * 2000000000) / cost * 100;
        return (float) (Math.round(yield * 10) / 10.0);
    }
}

package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class User {
    private int cost;
    private List<List<Integer>> lottoNumbers;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public User(int cost) {
        this.lottoNumbers = new ArrayList<>();
        validateCost(cost);
        this.cost = cost;
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
}

package lotto.datamodel;

import lotto.datamodel.enumdata.Rank;

import java.util.ArrayList;
import java.util.List;

public class CompareLottoNumbers {
    private static final int TOTAL_WIN_COUNT = 6;
    private final List<Integer> numbers;
    private final int bonusNumber;
    private boolean bonusValid = false;

    public CompareLottoNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> calculator(int lottoCount, List<List<Integer>> lottoNumbers) {
        Rank score;
        int count = 0;

        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            count = checkSameNumber(lottoNumbers.get(i));
            score = returnType(count);
            bonusValid = false;
            if (score != Rank.NONE) {
                price.add(score.getAmount());
            }
        }
        return price;
    }

    private int checkSameNumber(List<Integer> oneNumbers) {
        int count = 0;

        for (int i = 0; i < TOTAL_WIN_COUNT; i ++) {
            if (oneNumbers.contains(numbers.get(i))) {
                count++;
            }
            if (oneNumbers.contains(bonusNumber)) {
                bonusValid = true;
            }
        }
        return count;
    }

    private Rank returnType(int count) {
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5 && bonusValid == true) {
            return Rank.SECOND;
        }
        if (count == 5) {
            return Rank.THIRD;
        }
        if (count == 4){
            return Rank.FOURTH;
        }
        if (count == 3){
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }
}

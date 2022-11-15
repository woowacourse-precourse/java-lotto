package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public class CompareNumber {

    public int CompareLotto(List<Integer> lotto, List<Integer> winnerNumbers) {
        int count = 0;
        for(int numbers : lotto) {
            if (CompareNumber(numbers, winnerNumbers))
                count++;
        }
        return count;
    }

    public boolean CompareNumber(int number, List<Integer> winnerNumbers) {
        for (int winnerNumber : winnerNumbers) {
            if (number == winnerNumber)
                return true;
        }
        return false;
    }

    public boolean CompareBonuseLotto(int bonus, List<Integer> lotto) {
        for (int numbers : lotto)
            if (bonus == numbers)
                return true;
        return false;
    }

}

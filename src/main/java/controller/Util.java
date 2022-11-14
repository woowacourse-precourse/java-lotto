package controller;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public int compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        sameNumbers.addAll(lottoNumbers);
        sameNumbers.retainAll(winningNumbers);
        return sameNumbers.size();
    }

    public boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}

package controller;

import java.util.ArrayList;
import java.util.HashMap;
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
    public HashMap<String,Integer> createWinning(){
        HashMap<String, Integer> totalResult = new HashMap<>();
        for (Result rank : Result.values()){
            totalResult.put(rank.getWinningNumber(), 0);
        }
        return totalResult;
    }
}

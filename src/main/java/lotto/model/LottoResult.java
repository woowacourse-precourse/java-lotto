package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LottoResult {
    private List<List<Integer>> results = new ArrayList<>();

    public void setResults(List<List<Integer>> lottos, Set<Integer> winningNumbers, int bonusNumber){
        for (List<Integer> lotto: lottos){
            int matches = measureWinningNumber(lotto, winningNumbers);
            int bonusCount = countBonus(lotto, bonusNumber);

            results.add(Arrays.asList(matches, bonusCount));
        }
    }

    public List<List<Integer>> getResults(){
        return results;
    }

    public int measureWinningNumber(List<Integer> lotto, Set<Integer> winningNumbers){
        int matches = 0;

        for (int number : lotto){
            if (winningNumbers.contains(number)){
                matches++;
            }
        }

        return matches;
    }

    public int countBonus(List<Integer> lotto, int bonusNumber){
        if(lotto.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }
}

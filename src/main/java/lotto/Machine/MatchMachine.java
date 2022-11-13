package lotto.Machine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatchMachine {

    private final List<Integer> lottoResults;

    public MatchMachine(List<Integer> winningNumers, List<List<Integer>> lottoes) {
        this.lottoResults = getLottoResults(winningNumers, lottoes);
    }

    public List<Integer> getResults() {
        return lottoResults;
    }

    private HashSet<Integer> getOverlapedNumber(List<Integer> winningNumers, List<Integer> lottoes) {
        HashSet<Integer> winningNumber = new HashSet<>(winningNumers);
        HashSet<Integer> lotto = new HashSet<>(lottoes);
        HashSet<Integer> intersection = new HashSet<>(winningNumber);

        intersection.retainAll(lotto);

        return intersection;
    }

    private List<Integer> getLottoResults(List<Integer> winningNumers, List<List<Integer>> lottoes){
        List<Integer> results = new ArrayList<>();
        for (List<Integer> lotto : lottoes) {
            results.add(getOverlapedNumber(winningNumers, lotto).size());
        }

        return results;
    }




}

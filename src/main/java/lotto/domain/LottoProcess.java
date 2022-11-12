package lotto.domain;

import java.util.*;

public class LottoProcess {
    private final List<List<Integer>> lottos;
    private final List<Integer>winningNumbers;
    private final int bonusNumber;

    public LottoProcess(List<List<Integer>> lottos, List<Integer> winningNumbers,int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }

    public int compareWinningNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        int countMachingNumber=0;

        for(int number : lotto){
            if(winningNumbers.contains(number)) countMachingNumber++;
        }

        return countMachingNumber;
    }

    public List<Integer> decideRanks(List<List<Integer>> lottos, List<Integer> winningNumbers){
        List<Integer> ranks = new ArrayList<>();

        for(List<Integer> lotto : lottos){
            ranks.add(decideRank(compareWinningNumbers(lotto,winningNumbers),lotto));
        }

        return ranks;
    }

    public int decideRank(int countMachingNumber, List<Integer> lotto){
        if(countMachingNumber == 6) return 1;
        if(countMachingNumber == 5 && lotto.contains(bonusNumber)) return 2;
        if(countMachingNumber == 5) return 3;
        if(countMachingNumber == 4) return 4;
        if(countMachingNumber == 3) return 5;
        return 6;
    }

    public Map<String, Integer> countRanks(List<Integer> ranks){
        Map<String, Integer> ranking = new HashMap<>();
        ranking.put("FIRST", Collections.frequency(ranks,1));
        ranking.put("SECOND", Collections.frequency(ranks,2));
        ranking.put("THIRD", Collections.frequency(ranks,3));
        ranking.put("FOURTH", Collections.frequency(ranks,4));
        ranking.put("FIFTH", Collections.frequency(ranks,5));

        return ranking;
    }

    public void printStatistics(Map<String, Integer> ranking){
        for(Rank rank : Rank.values()){
            System.out.println(rank.getMessage(ranking.get(rank.name())));
        }
    }

}

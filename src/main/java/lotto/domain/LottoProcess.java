package lotto.domain;

import java.util.*;

public class LottoProcess {
    final int START_COUNT = 0;
    final int SIX_CORRECT = 6;
    static final int FIVE_CORRECT = 5;
    static final int FOUR_CORRECT = 4;
    static final int THREE_CORRECT = 3;
    static final int FIRST = 1;
    static final int SECOND = 2;
    static final int THIRD = 3;
    static final int FOURTH = 4;
    static final int FIFTH = 5;
    static final int REST = 6;

    private final List<List<Integer>> lottos;
    private final List<Integer>winningNumbers;
    private final int bonusNumber;
    private final int money;

    public LottoProcess(List<List<Integer>> lottos, List<Integer> winningNumbers,int bonusNumber,int money) {
        this.lottos = lottos;
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
        this.money = money;
    }

    public int compareWinningNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        int countMachingNumber=START_COUNT;

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
        if(countMachingNumber == SIX_CORRECT) return FIRST;
        if(countMachingNumber == FIVE_CORRECT && lotto.contains(bonusNumber)) return SECOND;
        if(countMachingNumber == FIVE_CORRECT) return THIRD;
        if(countMachingNumber == FOUR_CORRECT) return FOURTH;
        if(countMachingNumber == THREE_CORRECT) return FIFTH;
        return REST;
    }

    public Map<String, Integer> countRanks(List<Integer> ranks){
        Map<String, Integer> ranking = new HashMap<>();
        ranking.put("FIRST", Collections.frequency(ranks,FIRST));
        ranking.put("SECOND", Collections.frequency(ranks,SECOND));
        ranking.put("THIRD", Collections.frequency(ranks,THIRD));
        ranking.put("FOURTH", Collections.frequency(ranks,FOURTH));
        ranking.put("FIFTH", Collections.frequency(ranks,FIFTH));

        return ranking;
    }

    public void printStatistics(Map<String, Integer> ranking){
        for(Rank rank : Rank.values()){
            System.out.println(rank.getMessage(ranking.get(rank.name())));
        }
    }

    public void calculateRateOfReturn(Map<String, Integer> ranking){
        float totalPrize = 0;

        for(Rank rank : Rank.values()){
            if(ranking.get(rank.name()) != 0){
                totalPrize += rank.getPrize();
            }
        }

        System.out.println(String.format("총 수익률은 %.1f%%입니다.",(totalPrize/this.money) * 100));
    }

}

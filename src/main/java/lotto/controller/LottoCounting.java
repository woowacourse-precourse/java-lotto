package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCounting {

    public Map<Lotto, Integer> countedLotto(List<Lotto> lottoPapers, Lotto winningLotto){
        Map<Lotto, Integer> lottoBox = new HashMap<>();
        for (Lotto oneLottoPaper : lottoPapers) {
            countLottoAndStore(lottoBox, oneLottoPaper, winningLotto);
        }
        return lottoBox;
    }

    public Map<Integer,Integer> countWinningPaper(Map<Lotto,Integer> countedLotto,int bonusNumber){
        Map<Integer,Integer> countedWinningPaper = new HashMap<>();
        countedLotto.forEach((lottoPaper,lottoRanking) -> {
            addOneWinningPrize(countedWinningPaper,lottoRanking,lottoPaper,bonusNumber);
        });
        return countedWinningPaper;
    }

    public int calculateEarningMoney(Map<Integer, Integer> winningCounts){
        int totalEarnMoney = 0;

        for(int ranking = 1; ranking <= 5; ranking++){
            int winningMoney = WinningPrize.findEnumByRank(ranking).getWinningMoney();
            int amountOfThatRanking = getThisRankingsAmount(winningCounts,ranking);

            totalEarnMoney += (winningMoney * amountOfThatRanking);
        }
        return totalEarnMoney;
    }

    public int getThisRankingsAmount(Map<Integer, Integer> winningCounts, int ranking){
        try{
            return winningCounts.get(ranking);
        }catch(NullPointerException ex){
            return 0;
        }
    }

    private void addOneWinningPrize(Map<Integer,Integer> countedLotto,int howMuchCorrect,Lotto oneLottoPaper,int bonusNumber){

        int ranking = WinningPrize.findRanking(howMuchCorrect,oneLottoPaper,bonusNumber);
        try{
            int previousRankingCount = countedLotto.get(ranking);
            countedLotto.replace(ranking,previousRankingCount + 1);
        }catch(NullPointerException ex){
            countedLotto.put(ranking,1);
        }
    }

    private void countLottoAndStore(Map<Lotto, Integer> lottoBox, Lotto oneLottoPaper, Lotto winningLotto){
        int howManyNumbersCorrect = compareLottoAndCount(oneLottoPaper, winningLotto);
        lottoBox.put(oneLottoPaper,howManyNumbersCorrect);
    }

    int compareLottoAndCount(Lotto oneLottoPaper, Lotto winningLotto){
        int lottoCount = 0;
        List<Integer> lottoNumbers = oneLottoPaper.getNumbers();
        for (Integer oneLottoNumber : lottoNumbers) {
            if (winningLotto.getNumbers().contains(oneLottoNumber)) {
                lottoCount++;
            }
        }
        return lottoCount;
    }
}

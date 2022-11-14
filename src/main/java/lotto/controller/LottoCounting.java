package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCounting {

    public Map<Lotto, Integer> countedLotto(Lotto[] lottoPapers, Lotto winningLotto){
        Map<Lotto, Integer> lottoBox = new HashMap<>();
        for (Lotto oneLottoPaper : lottoPapers) {
            countLottoAndStore(lottoBox, oneLottoPaper, winningLotto);
        }
        return lottoBox;
    }

    public Map<Integer,Integer> countWinningPaper(Map<Lotto,Integer> countedLotto,Lotto winningLotto,int bonusNumber){
        Map<Integer,Integer> countedWinningPaper = new HashMap<>();
        countedLotto.forEach((lottoPaper,lottoRanking) -> {
            addOneWinningPrize(countedWinningPaper,lottoRanking,lottoPaper,bonusNumber);
        });
        return countedWinningPaper;
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

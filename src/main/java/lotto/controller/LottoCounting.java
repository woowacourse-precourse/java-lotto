package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCounting {

    // 로또 한장한장 세어서, Map 에다가 집어넣기. 그래서, 몇개 맞췄는지 매핑하기.
    public Map<Lotto, Integer> countedLotto(Lotto[] lottoPapers, Lotto winningLotto){
        Map<Lotto, Integer> lottoBox = new HashMap<>();
        for (Lotto oneLottoPaper : lottoPapers) {
            storeLottoInBox(lottoBox, oneLottoPaper, winningLotto);
        }

        return lottoBox;
    }
    // 당첨된
    public Map<Integer,Integer> countWinningPaper(Map<Lotto,Integer> countedLotto,Lotto winningLotto,int bonusNumber){
        Map<Integer,Integer> countedWinningPaper = new HashMap<>();
        countedLotto.forEach((key,value) -> {
            addOneWinningPrize(countedWinningPaper,value,winningLotto,bonusNumber);
        });
        return countedWinningPaper;
    }

    private void addOneWinningPrize(Map<Integer,Integer> countedLotto,int howMuchCorrect,Lotto winningLotto,int bonusNumber){

        int ranking = WinningPrize.getRanking(howMuchCorrect,winningLotto,bonusNumber);
        try{
            int previousRankingCount = countedLotto.get(ranking);
            countedLotto.replace(ranking,previousRankingCount + 1);
        }catch(NullPointerException ex){
            countedLotto.put(ranking,1);
        }
    }

    // 한 장의 로또가 몇개 맞췄는지, 세어서 로또박스에 매핑해야 한다.
    private void storeLottoInBox(Map<Lotto, Integer> lottoBox, Lotto oneLottoPaper, Lotto winningLotto){
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

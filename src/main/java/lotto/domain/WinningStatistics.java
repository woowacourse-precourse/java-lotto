package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lotto.utility.LottoRanking;

public class WinningStatistics {
    private double totalProfit = 0;
    private Publisher lottoPublisher;
    private WinningLotto winningLotto;
    private List<Integer> numberOfWinningLottos;

    public WinningStatistics(Publisher lottoPublisher, WinningLotto winningLotto){
        this.lottoPublisher = lottoPublisher;
        this.winningLotto = winningLotto;
        numberOfWinningLottos = Arrays.asList(0,0,0,0,0);
        countWinningLottos();
    }

    public List<Integer> getNumberOfWinningLottos(){
        return numberOfWinningLottos;
    }

    public double getEarningRate(){
        return totalProfit / lottoPublisher.getPrice() * 100;
    }

    private void countWinningLottos(){
        HashSet<Integer> winningNumberSet = new HashSet<>(winningLotto.getNumbers());
        for(Lotto lotto : lottoPublisher.getLottos()){
            int index = compareLottoNumber(winningNumberSet, lotto.getNumbers());
            if(index != -1)
                numberOfWinningLottos.set(index, numberOfWinningLottos.get(index) + 1);
        }
    }

    private int compareLottoNumber(HashSet<Integer> winningNumber, List<Integer> numbers){
        int correctCount = 0;
        boolean bonusConunt = false;
        for(int number : numbers){
            if(winningNumber.contains(number))
                ++correctCount;
            if(number == winningLotto.getBonusNumber())
                bonusConunt = true;
        }
        return lottoRankingTask(correctCount, bonusConunt);
    }

    private int lottoRankingTask(int correctCount, boolean bonusConunt){
        int idx = -1, profit = 0;
        if(correctCount > 2){
            LottoRanking winning = LottoRanking.valueOf(String.format("CORRECT%d", correctCount));
            idx = winning.getValue();
            profit = winning.getPrice();
        }
        if(correctCount == 5 && bonusConunt){
            idx = LottoRanking.CORRECT5BONUS1.getValue();
            profit = LottoRanking.CORRECT5BONUS1.getPrice();
        }
        totalProfit += profit;
        return idx;
    }
}

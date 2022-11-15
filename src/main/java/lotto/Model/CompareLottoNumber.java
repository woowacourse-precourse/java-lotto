package lotto.Model;

import lotto.DB.LottoData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CompareLottoNumber {
    LottoData lottoData = new LottoData();

    public List<List<Integer>> getWinCountByPrize(){
        countWinningLotto();
        List<Integer> prizeList = new ArrayList<>(lottoData.getNumberOfWins().keySet());
        List<List<Integer>> winCountByPrize = new ArrayList<List<Integer>>();
        prizeList.sort(Integer::compareTo);
        for(int prize : prizeList){
            int numberOfWins = lottoData.getNumberOfWins().get(prize);
            winCountByPrize.add(Arrays.asList(prize, numberOfWins));
        }
        return winCountByPrize;
    }

    public double calculateYield(){
        HashMap<Integer, Integer> numberOfWins = lottoData.getNumberOfWins();
        List<Integer> prizeList = new ArrayList<>(numberOfWins.keySet());
        double yield = 0;
        double earning = 0;
        for(int prize : prizeList){
            earning += (prize * numberOfWins.get(prize));
        }
        yield = earning/(lottoData.getCountOfLotto() * lottoData.LOTTOPRICE);
        return yield*100;
    }

    private void countWinningLotto(){
        List<Lotto> lottoList = lottoData.getLottoList();
        final int noPrize = 0;
        HashMap<Integer, Integer> numberOfWins = new HashMap<Integer, Integer>();
        initCountPrize(numberOfWins);
        for(Lotto lotto : lottoList){
            int lottoPrize = getLottoPrize(lotto);
            if(lottoPrize != noPrize) numberOfWins.put(lottoPrize, numberOfWins.get(lottoPrize) + 1);
        }
        lottoData.setNumberOfWins(numberOfWins);
    }

    private void initCountPrize(HashMap<Integer, Integer> numberOfWins){
        for(LottoData.LottoPrize prize : LottoData.LottoPrize.values()){
            numberOfWins.put(prize.getValue(), 0);
        }
    }

    private int getLottoPrize(Lotto userNumberLotto){
        Lotto winnerNumberLotto = lottoData.getWinnerNumber();
        int bonusNumber = lottoData.getBonusNumber();
        int matchedNumberCount = compareWinnerNumber(userNumberLotto, winnerNumberLotto);
        if(matchedNumberCount == 6) return LottoData.LottoPrize.FIRSTPRIZE.getValue();
        if(matchedNumberCount == 5 && isContainsBonusNumber(userNumberLotto, bonusNumber))return LottoData.LottoPrize.SECONDPRIZE.getValue();
        if(matchedNumberCount == 5) return LottoData.LottoPrize.THRIDPRIZE.getValue();
        if(matchedNumberCount == 4) return LottoData.LottoPrize.FOURTHPRIZE.getValue();
        if(matchedNumberCount == 3) return LottoData.LottoPrize.FIFTHPRIZE.getValue();
        return 0;
    }

    private int compareWinnerNumber(Lotto userNumberLotto, Lotto winnerNumberLotto){
        List<Integer> userNumber = userNumberLotto.getLottoNumber();
        List<Integer> winnerNumber = winnerNumberLotto.getLottoNumber();
        int matchedNumber = 0;
        for(int number : winnerNumber){
            if(userNumber.contains(number)){
                matchedNumber += 1;
            }
        }
        return matchedNumber;
    }

    private boolean isContainsBonusNumber(Lotto userNumberLotto, int bonusNumber){
        List<Integer> userNumber = userNumberLotto.getLottoNumber();
        return userNumber.contains(bonusNumber);
    }
}

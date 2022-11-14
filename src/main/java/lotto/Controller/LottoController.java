package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.*;
import lotto.View.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    LottoData lottoData = new LottoData();
    OutputView output = new OutputView();
    InputView input = new InputView();

    public void start(){
        try {
            setLottoCount();
            makeLottoNumber();
            printLottoNumber();
            inputWinnerNumber();
            inputBonusNumber();
            countLottoPrize();
            printLottoPrize();
            calculateYield();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR]잘못된 입력");
        }
    }
    private void setLottoCount(){
        output.askPurchasePrice();
        lottoData.setCountOfLotto(input.purchasePrice());
    }

    private void makeLottoNumber(){
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for(int i = 0; i < lottoData.getCountOfLotto(); i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lottoList.add(lotto);
        }
        lottoData.setLottoList(lottoList);
    }

    private void printLottoNumber(){
        List<Lotto> lottoList = lottoData.getLottoList();
        List<List<Integer>> lottoNumber = new ArrayList<List<Integer>>();
        for(Lotto lotto : lottoList){
            lottoNumber.add(lotto.getLottoNumber());
        }
        output.showPurchasedLotto(lottoData.getCountOfLotto(), lottoNumber);
    }

    private void inputWinnerNumber(){
        output.askWinnerNumber();
        Lotto winnerNumberLotto = new Lotto(input.winnerNumbers());
        lottoData.setWinnerNumber(winnerNumberLotto);
    }

    private void inputBonusNumber(){
        output.askBonusNumber();
        lottoData.setBonusNumber(input.bonusNumber());
    }

    private void countLottoPrize(){
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
    private void initCountPrize(HashMap<Integer, Integer> countPrize){
        for(LottoData.LottoPrize prize : LottoData.LottoPrize.values()){
            countPrize.put(prize.getValue(), 0);
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

    private void printLottoPrize(){
        List<Integer> prizeList = new ArrayList<>(lottoData.getNumberOfWins().keySet());
        List<Integer> winCount = new ArrayList<Integer>();
        prizeList.sort(Integer::compareTo);
        for(int prize : prizeList){
            winCount.add(lottoData.getNumberOfWins().get(prize));
        }
        output.showLottoPrize(prizeList, winCount);
    }

    private void calculateYield(){
        HashMap<Integer, Integer> numberOfWins = lottoData.getNumberOfWins();
        List<Integer> prizeList = new ArrayList<>(numberOfWins.keySet());
        double yield = 0;
        double earning = 0;
        for(int prize : prizeList){
            earning += (prize * numberOfWins.get(prize));
        }
        yield = earning/(lottoData.getCountOfLotto() * lottoData.LOTTOPRICE);
        output.showYield(yield*100);
    }
}
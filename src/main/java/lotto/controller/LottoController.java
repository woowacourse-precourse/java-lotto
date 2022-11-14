package lotto.controller;

import lotto.domain.*;
import lotto.view.input.LottoGenerator;
import lotto.view.input.UserInput;
import lotto.view.output.Guide;

import java.util.List;
import java.util.Map;

public class LottoController {
    Guide guide = new Guide();
    UserInput userInput = new UserInput();
    LottoGenerator generator = new LottoGenerator();


    public void start(){
        int lottoCount = getLottoCount();
        guide.printLottoCount(lottoCount);

        LottoGroup lottoGroup = getLottoGroup(lottoCount);
        guide.printLottoGroup(lottoGroup);

        WinningNumber winningNumber = getWinningNumber();

        int bonus = getBonus();
        winningNumber.updateBonus(bonus);

        Map<RankingType, Integer> rankingTypeCounts = lottoGroup.getRankingTypeCounts(winningNumber);
        printResult(rankingTypeCounts);

        double profitRate = getProfitRate(rankingTypeCounts, lottoCount);
        guide.printProfitRate(profitRate);
    }

    private int getLottoCount(){
        guide.printInputPriceGuide();
        return userInput.getLottoCount();
    }

    private LottoGroup getLottoGroup(int lottoCount){
        List<Lotto> lottos = generator.generateLottos(lottoCount);
        return new LottoGroup(lottos);
    }

    private WinningNumber getWinningNumber(){
        guide.printInputWinningNumberGuide();
        List<Integer> inputWinningNumber = userInput.getWinningNumber();
        return new WinningNumber(inputWinningNumber);
    }

    private int getBonus(){
        guide.printInputBonusGuide();
        return userInput.getBonusNumber();
    }

    private void printResult(Map<RankingType, Integer> rankingTypeCounts){
        guide.printResultGuide();
        guide.printResult(rankingTypeCounts);
    }

    private double getProfitRate(Map<RankingType, Integer> rankingTypeCounts, int lottoCount){
        int investment = getInvestment(lottoCount);
        Profit profit = new Profit(rankingTypeCounts, investment);
        return profit.getProfitRate();
    }

    private int getInvestment(int lottoCount){
        return lottoCount * 1000;
    }

}

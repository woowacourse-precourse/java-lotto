package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoRank;
import lotto.model.LottoGenerator;
import lotto.model.LottoJudge;
import lotto.model.WinningNumber;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    private LottoGenerator lottoGenerator;
    private LottoJudge lottoJudge;
    private WinningNumber winningNumber;

    public String loadPayMoney() {
        return LottoInput.inputPayMoney();
    }

    public List<Integer> loadWinningNumber() {
        winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(LottoInput.inputWinningNumber());
        return winningNumber.getWinningNumbers();
    }

    public int loadBonusNumber() {
        winningNumber.setBonusNumber(LottoInput.inputBonusNumber());
        return winningNumber.getBonusNumber();
    }

    public ArrayList<List<Integer>> generateLottoNumbers(String money) {
        lottoGenerator = new LottoGenerator();
        lottoGenerator.generateLotto(money);
        return lottoGenerator.getLotteries();
    }

    public void printBuyNumber(String money) {
        LottoOutput.printBuyLotto(Integer.parseInt(money));
    }

    public void printLottoNumber(ArrayList<List<Integer>> lotteries) {
        LottoOutput.printLottoNumbers(lotteries);
    }

    public void printLottoRank(ArrayList<List<Integer>> lotteries, List<Integer> winningNumbers,
        int bonusNUmber) {
        lottoJudge = new LottoJudge();
        lottoJudge.judgeLotto(lotteries, winningNumbers, bonusNUmber);
        LottoOutput.printLottoRank(lottoJudge.getRankCount());
    }

    public void printLottoProfit(List<LottoRank> rankCount, int money) {
        lottoJudge.profitLotto(rankCount, money);
        LottoOutput.printLottoProfit(lottoJudge.getLottoProfit());
    }


}

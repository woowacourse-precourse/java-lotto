package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void lottoStart() {
        String money = buyLotto();
        int count = lottoCount(money);
        List<List<Integer>> myLotto = getLotto(count);

        List<Integer> lotto = getWinNumber();
        int bonusNum = getBonusNumber(lotto);
        List<WinDetail> rank = winCalculation(lotto, myLotto,bonusNum);
        winCount(rank);
        rewardRate(rank, money);
    }


    private String buyLotto(){
        String money = InputView.buyLotto();
        User.checkError(money);
        return money;
    }

    private int lottoCount(String money){
        int count = User.lottoCount(money);
        OutputView.lottoCountMsg(count);
        return count;
    }

    private List<List<Integer>> getLotto(int count){
        List<List<Integer>> myLotto = LottoNumber.userLotto(count);

        LottoNumber.printUserLotto(myLotto);
        return myLotto;
    }

    private List<Integer> getWinNumber(){
        String win = InputView.winningLotto();
        List<Integer> numbers = new ArrayList<>();

        Lotto lotto = new Lotto(win, numbers);
        numbers = lotto.change(win);
        return numbers;

    }

    private int getBonusNumber(List<Integer> lotto){
        String bonus = InputView.bonusNumber();
        return BonusNumber.checkBonusNumber(lotto, bonus);
    }

    private List<WinDetail> winCalculation(List<Integer> lotto,List<List<Integer>> myLotto, int bonusNum){
        List<List<Object>> rank;
        rank = WinCalculation.winCal(lotto,myLotto,bonusNum);
        List<WinDetail> result = WinCalculation.rankResult(rank);
        return result;
    }

    private void winCount(List<WinDetail> result){
        List<Integer> cc = WinCount.winCount(result);
        WinCount.printCount(cc);

    }

    private void rewardRate(List<WinDetail> result, String money){
        long reward = Revenue.revenue(result);
        double rate = Revenue.rate(money,reward);
        OutputView.rateMsg(rate);

    }




}

package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.GenerateLotto;
import lotto.domain.PickBonusNum;
import lotto.domain.PickLottoNum;
import lotto.domain.Profit;
import lotto.domain.Raffle;
import lotto.view.BuyerInputView;
import lotto.view.BuyerOutputView;

public class LottoController {
    private Buyer buyer;
    private GenerateLotto generateLotto;
    private PickLottoNum pickLottoNum;
    private PickBonusNum pickBonusNum;
    private Raffle raffle;
    private Profit profit;

    public void lottoStart() {
        try {
            buyLotto();
            showLotto();
            pickLotto();
            pickBonus();
            startRaffle();
            showMeTheMoney();
        } catch(IllegalArgumentException e){
            return;
        }
    }

    private void buyLotto() {
        String inputNum = BuyerInputView.getInputPrice();
        buyer = new Buyer(inputNum);
    }

    private void showLotto() {
        BuyerOutputView.showLottoCount(buyer.getTicketCount());
        generateLotto = new GenerateLotto(buyer.getTicketCount());
        BuyerOutputView.showLottoNumber(generateLotto.lottoNumber);
    }

    private void pickLotto() {
        pickLottoNum = new PickLottoNum(BuyerInputView.getPickNum());
    }

    private void pickBonus() {
        pickBonusNum = new PickBonusNum(pickLottoNum.pickLotto, BuyerInputView.getBonusNum());
    }

    private void startRaffle() {
        raffle = new Raffle(generateLotto.lottoNumber, buyer.getTicketCount(), pickLottoNum.pickLotto,
                pickBonusNum.pickBonus);
        BuyerOutputView.showRaffleResult(raffle.prize);
    }

    private void showMeTheMoney() {
        profit = new Profit(buyer.inputPrice, raffle.prize);
        BuyerOutputView.showProfit(profit.profitRate);
    }


}

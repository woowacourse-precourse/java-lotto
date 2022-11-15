package controller;

import domain.Buyer;
import domain.GenerateLotto;
import domain.PickBonusNum;
import domain.PickLottoNum;
import domain.Profit;
import domain.Raffle;
import view.BuyerInputView;
import view.BuyerOutputView;

public class LottoController {
    private Buyer buyer;
    private GenerateLotto generateLotto;
    private PickLottoNum pickLottoNum;
    private PickBonusNum pickBonusNum;
    private Raffle raffle;
    private Profit profit;

    public void lottoStart() {
        buyLotto();
        showLotto();
        pickLotto();
        pickBonus();
        startRaffle();
        showMeTheMoney();
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

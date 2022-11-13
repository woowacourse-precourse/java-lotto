package lotto.controller;

import lotto.domain.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final int LOTTO_ONE_GAME_PRICE = 1000;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoRank lottoRank;

    // 게임을 실행하는 메소드
    public void run(){
        int inputLottoMoney = inputLottoPurchaseMoney();
        int lottoTickets = createLottoTickets(inputLottoMoney);
    }

    private int inputLottoPurchaseMoney() {
        int lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();
        return lottoPurchaseMoney;
    }

    private int createLottoTickets (int inputMoney) {
        return inputMoney / LOTTO_ONE_GAME_PRICE;
    }


}

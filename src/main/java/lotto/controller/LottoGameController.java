package lotto.controller;

import lotto.service.LottoGame;
import lotto.view.input.AmountInput;
import lotto.view.print.PrintGuideMessage;

public class LottoGameController {
    private final LottoGame game;

    public LottoGameController(LottoGame game) {
        this.game = game;
    }

    public void startGame() {
        getAmount();
    }

    public void getAmount() {
        PrintGuideMessage.printStartGuide();
        AmountInput input = new AmountInput();
        String amount = input.getInput();
    }

    public void printTickets() {
        // 자동 발행된 로또 번호를 출력
    }

    public void getWinnings() {
        //당첨 번호 입력받기
    }

    public void getBonus() {
        // 보너스 번호 입력받기
    }

    public void printStatistics() {
        // 당첨 내역과 수익률을 출력
    }
}
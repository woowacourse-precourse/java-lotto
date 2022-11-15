package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        LottoTicket lottoTicket = new LottoTicket();
        LottoSeller lottoSeller = new LottoSeller();

        int ticketMoney = input.inputPurchaseAmount();
        lottoTicket.buyTicket(lottoSeller, ticketMoney);

        List<Integer> winningNumber = input.inputWinningNumbers();
        Lotto winningNumbers = new Lotto(winningNumber);
        int bonusNumber = input.inputBonusNumber();
        LottoValidate lottoValidate = new LottoValidate(winningNumbers, bonusNumber);

        LottoRankCheck lottoRankCheck = new LottoRankCheck();

    }
}

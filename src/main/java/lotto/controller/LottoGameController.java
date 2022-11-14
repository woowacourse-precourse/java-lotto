package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;
import lotto.domain.Money;
import lotto.number.LottoWinningNumbers;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
	
	public void play() {
		LottoTickets lottoTickets = getLottoTickets(new Money(InputView.inputMoney()));
		OutputView.printLottoTickets(lottoTickets.getLottoTickets()); 
		LottoWinningNumbers lottoWinningNumbers = getWinningNumbers();
		
		LottoGame lottoGame = new LottoGame(lottoTickets, lottoWinningNumbers);
        LottoGameResult lottoGameResult = lottoGame.getMatchingResult();
        
	}
	
	private LottoWinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(); 
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }
	
	private LottoTickets getLottoTickets(Money money) {
        int ticketCount = money.getTickets();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i=0;i<ticketCount;i++) {
        	lottoTickets.add(new LottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }
}

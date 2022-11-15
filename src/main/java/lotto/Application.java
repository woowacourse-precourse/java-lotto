package lotto;

import java.util.List;

import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.ui.Reader;
import lotto.domain.Seller;
import lotto.ui.Writer;

public class Application {

	public static void main(String[] args) {
		try {
			final List<Lotto> tickets = buyLottoTickets();
			final LotteryMachine machine = drawAndGetMachine();
			Writer.writeWinningStats(tickets, machine);
		} catch (IllegalArgumentException e) {
			Writer.writeExceptionMessage(e);
		}
	}

	private static LotteryMachine drawAndGetMachine() {
		Writer.writeInputWinningNumbers();
		final List<Integer> numbers = Reader.readWinningNumbers();
		final LotteryMachine machine = LotteryMachine.of(numbers);
		Writer.writeInputBonusNumber();
		final Integer bonusNumber = Reader.readBonusNumber();
		machine.setBonusNumber(bonusNumber);
		return machine;
	}

	private static List<Lotto> buyLottoTickets() {
		Writer.writeInputPurchaseAnnouncement();
		final List<Lotto> tickets = Seller.sellLottoTickets(Reader.readPurchaseAmount());
		Writer.writePurchasedLottoTickets(tickets);
		return tickets;
	}

}

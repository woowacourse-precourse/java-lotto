package lotto.domain;

import lotto.domain.ui.Printer;
import lotto.domain.ui.Scanner;

public class LottoGame {

	public void start() {
		Printer printer = new Printer();
		Scanner scanner = new Scanner();

		printer.printMessage(Message.START);
		int money = scanner.scanInt();
		Pay pay = new Pay(money);
		Store store = new Store(pay.getPay());
		printer.printLottoTicket(store.lottoTicket);
	}
}

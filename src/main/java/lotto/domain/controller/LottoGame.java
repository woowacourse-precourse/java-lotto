package lotto.domain.controller;

import lotto.domain.model.LottoTicket;
import lotto.domain.model.Pay;
import lotto.domain.model.Store;
import lotto.domain.view.Message;
import lotto.domain.view.Print;
import lotto.domain.view.Scanner;

public class LottoGame {

	public void start() {
		Print print = new Print();
		Scanner scanner = new Scanner();

		print.message(Message.START);
		int money = scanner.scanInt();
		Pay pay = new Pay(money);
		Store store = new Store(pay.getPay());
		print.LottoTicket(store.count, store.lottoTicket.getTicket());
	}
}

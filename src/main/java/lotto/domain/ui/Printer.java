package lotto.domain.ui;

import lotto.domain.model.Message;

import java.util.List;

public class Printer {

	public void printMessage(Message message) {
		System.out.println(message.get());
	}

	public void println() {
		System.out.println();
	}

	public void printLottoTicket(List<List<Integer>> lottoTicket) {
		println();
		for (List<Integer> ticket : lottoTicket)
			System.out.println(ticket);
	}

}

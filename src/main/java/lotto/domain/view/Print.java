package lotto.domain.view;

import java.util.List;

public class Print {

	public void message(Message message) {
		System.out.println(message.getMessage());
	}

	public void newLine() {
		System.out.println();
	}

	public void LottoTicket(int count, List<List<Integer>> lottoTicket) {
		newLine();
		System.out.println("" + count + Message.BUY.getMessage());
		for (List<Integer> ticket : lottoTicket)
			System.out.println(ticket);
	}

}

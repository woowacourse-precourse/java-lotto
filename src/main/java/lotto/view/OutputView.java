package lotto.view;

import java.util.List;

public class OutputView {

	public static void printLottoTickets(final List<String> lottoTickets) {
		System.out.println(lottoTickets.size() + "개를 구매했습니다.");
		for (String lottoTicket : lottoTickets) {
			System.out.println(lottoTicket);
		}
		System.out.println();
	}
}

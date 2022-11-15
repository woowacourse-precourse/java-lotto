package lotto.domain.view;

import java.util.List;

public class Print {

	public void message(Message message) {
		System.out.print(message.getMessage());
	}

	public void LottoTicket(long count, List<List<Integer>> lottoTicket) {
		System.out.println("\n" + count + Message.BUY.getMessage());
		for (List<Integer> ticket : lottoTicket)
			System.out.println(ticket);
	}

	public void result(List<List<Integer>> result) {
		message(Message.RESULT_TITLE);
		for (List<Integer> score : result) {
			if (score.get(1).equals(30000000)) {
				System.out.printf(Message.RESULT_FIVE_BONUS.getMessage(), score.get(2));
				continue;
			}
			System.out.printf(Message.RESULT.getMessage(), score.get(0), score.get(1), score.get(2));
		}
	}
}

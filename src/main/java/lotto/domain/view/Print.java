package lotto.domain.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Print {

	public void message(Message message) {
		System.out.print(message.getMessage());
	}

	public void print(String string) {
		System.out.println(string);
	}

	public void newLine() {
		System.out.println();
	}    // todo 이거 메세지에 개행에 문자 넣기

	public void LottoTicket(int count, List<List<Integer>> lottoTicket) {
		newLine();
		System.out.println("" + count + Message.BUY.getMessage());
		for (List<Integer> ticket : lottoTicket)
			System.out.println(ticket);
	}

	public void result(List<List<Integer>> result) {
		DecimalFormat decFormat = new DecimalFormat("###,###");

		message(Message.RESULT_TITLE);
		for (List<Integer> score : result) {
			String prize = decFormat.format(score.get(1));

			if (prize.equals("30,000,000")) {
				System.out.printf(Message.RESULT_FIVE_BONUS.getMessage(), score.get(2));
				continue;
			}
			System.out.printf(Message.RESULT.getMessage(), score.get(0), prize, score.get(2));
		}


	}
}

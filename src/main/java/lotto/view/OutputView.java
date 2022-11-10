package lotto.view;

import java.util.Arrays;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

public class OutputView {
	private static final String NUMBER_OF_TICKETS_MESSAGE = "%d개를 구매했습니다.";

	private OutputView() {
	}

	public static void printNumberOfTickets(int getNumberOfTickets) {
		System.out.printf(NUMBER_OF_TICKETS_MESSAGE + "%n", getNumberOfTickets);
	}

	public static void printLottoTickets(LottoMachine lottoMachine) {
		for (Lotto lottoTickets : lottoMachine.getLottoTickets()) {
			System.out.println(Arrays.toString(lottoTickets.getNumbers().toArray()));
		}
	}
}

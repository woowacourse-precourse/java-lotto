package lotto.view;

import java.util.List;

import lotto.constant.OutputMessage;

public class OutputView {
	public void printNumberOfTickets(int numberOfTickets) {
		System.out.println();
		System.out.printf(OutputMessage.DISPLAYING_PURCHASING_QUANTITY.message(), numberOfTickets);
		System.out.println();
	}
}

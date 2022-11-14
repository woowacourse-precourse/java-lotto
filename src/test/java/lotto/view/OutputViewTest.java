package lotto.view;

import java.util.List;

import org.junit.jupiter.api.Test;

public class OutputViewTest {

	List<Integer> places = List.of(0, 0, 0, 0, 1);
	int money = 8_000;

	@Test
	void printStatistics() {
		OutputView.printStatistics(places, money);
	}

}

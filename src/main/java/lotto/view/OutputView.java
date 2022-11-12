package lotto.view;

import lotto.Message;
import lotto.model.Lotto;

import java.util.List;

public class OutputView {

	public static void printLottos(List<Lotto> lottos){
		System.out.println("" + lottos.size() + Message.AFTER_BUY.getMessage());
		lottos.stream()
				.forEach(System.out::println);
	}
}

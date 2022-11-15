package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.LottoAttributes.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoAttributes.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoAttributes.MAX_LOTTO_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

	public static List<Lotto> publish(final int numberOfTickets) {
		List<Lotto> tickets = new ArrayList<>();

		for (int i = 0; i < numberOfTickets; i++) {
			tickets.add(new Lotto(pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
				MAX_LOTTO_NUMBER, MAX_LOTTO_NUMBERS_SIZE)));
		}
		return tickets.stream()
			.sorted(Comparator.comparingInt(Lotto::getSumOfNumbers))
			.collect(Collectors.toList());
	}
}

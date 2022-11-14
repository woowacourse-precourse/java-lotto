package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ErrorMessage;

/**
 * 제공된 Lotto 클래스를 활용해 구현해야 한다.
 * Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
 * numbers의 접근 제어자를 변경할 수 없다.
 * Lotto에 필드를 추가할 수 없다.
 * Lotto의 패키지 변경은 가능하다.
 */
public class Lotto {

	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;
	public static final int NUMBER_OF_LOTTO = 6;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	public static Lotto newInstance() {
		final List<Integer> numbers = Randoms
			.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, NUMBER_OF_LOTTO)
			.stream()
			.sorted()
			.collect(Collectors.toList());
		return new Lotto(numbers);
	}

	public static List<Lotto> newInstances(int count) {
		final List<Lotto> lottoTickets = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			lottoTickets.add(Lotto.newInstance());
		}
		return lottoTickets;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != NUMBER_OF_LOTTO) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidNumberOfLottoNumbers());
		}
		if (isInvalidLottoNumber(numbers)) {
			throw new IllegalArgumentException(ErrorMessage.isInvalidLottoNumber());
		}
	}

	private boolean isInvalidLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
	}

}

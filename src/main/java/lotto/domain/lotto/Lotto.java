package lotto.domain.lotto;

import static lotto.util.constant.Constant.LOTTO_END_NUMBER;
import static lotto.util.constant.Constant.LOTTO_LENGTH;
import static lotto.util.constant.Constant.LOTTO_START_NUMBER;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {


	private static final String DIVIDE = ",";

	private static final String NOT_THE_RIGHT_LOTTO_LENGTH = "[ERROR] 입력한 개수가 올바르지 않습니다.";
	private static final String NOT_THE_RIGHT_NUMBER = "[ERROR] 숫자가 아닌 값이 입력 됬습니다";
	private static final String NOT_THE_RIGHT_RANGE = "[ERROR] 올바른 범위의 숫자가 입력되지 않았습니다";
	private static final String NOT_THE_ANOTHER_NUMBER = "[ERROR] 1~45의 서로다른 숫자가 입력되지 않았습니다";
	private final List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
		validate();
	}

	public Lotto(String winLottoNumber,String bonusNumber) {
		isNumber(winLottoNumber);
		this.numbers = convertStringToList(winLottoNumber);
		isAlreadyIncludeNumber(bonusNumber);
		validate();
	}

	private void validate() {
		isLengthRight();
		isInRangeNumber();
		isAnotherNumber();
	}

	public void isNumber(String number) {
		number = number.replace(",", "");
		try {
			Long.parseLong(number);
		} catch (Exception e) {
			throw new IllegalArgumentException(NOT_THE_RIGHT_NUMBER);
		}
	}

	public void isLengthRight() {
		if (numbers.size() != LOTTO_LENGTH) {
			throw new IllegalArgumentException(NOT_THE_RIGHT_LOTTO_LENGTH);
		}
	}

	public void isInRangeNumber() {
		for (Integer num : numbers) {
			if (num < LOTTO_START_NUMBER || num > LOTTO_END_NUMBER) {
				throw new IllegalArgumentException(NOT_THE_RIGHT_RANGE);
			}
		}
	}

	public void isAnotherNumber() {
		int removeDisticntSize  = (int) numbers.stream()
				.distinct()
                .count();
        int size = numbers.size();
		if (removeDisticntSize != size) {
			throw new IllegalArgumentException(NOT_THE_ANOTHER_NUMBER);
		}
	}

	public List<Integer> convertStringToList(String number) {
		String[] arr = number.split(DIVIDE);
		return Stream.of(arr)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public void isAlreadyIncludeNumber(String number) {
		Integer num = Integer.parseInt(number);
		if (numbers.contains(num)){
            throw new IllegalArgumentException(NOT_THE_ANOTHER_NUMBER);
        }
	}


}

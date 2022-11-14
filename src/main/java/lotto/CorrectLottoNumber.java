package lotto;

import java.util.ArrayList;
import java.util.List;

public class CorrectLottoNumber {

	/*
	 * correctLottoNumber는 로또번호와 당첨번호간 같은 갯수를 3,4,5,6(보너스포함),6개 순으로
	 * 당첨 횟수를 저장하는 배열이다.
	 * */
	private final List<Integer> correctLottoNumber;

	public CorrectLottoNumber() {
		this.correctLottoNumber = new ArrayList<>(List.of(0, 0, 0, 0, 0));
	}

	public List<Integer> getCorrectLottoNumber() {
		return correctLottoNumber;
	}
}

package lotto.caculate;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.calculate.calculateResult;

public class CalculateResultTest {
	@DisplayName("구입한 로또와 당첨번호 및 보너스 번호를 map에 정확하게 담는지 여부")
	@Test
	void validateNumberOnMap() {
		ArrayList<List<Integer>> userNumber = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(15);
		list.add(31);
		list.add(32);
		list.add(33);
		userNumber.add(list);
		ArrayList<Integer> winningNumber = new ArrayList<>();
		winningNumber.add(1);
		winningNumber.add(5);
		winningNumber.add(15);
		winningNumber.add(20);
		winningNumber.add(30);
		winningNumber.add(40);
		int bonusNumber = 45;

		calculateResult calculateResult = new calculateResult(userNumber, winningNumber, bonusNumber);
		assertThat(calculateResult.calculateResult.get("three")).isEqualTo(1);

	}
}

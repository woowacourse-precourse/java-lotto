package lotto.caculate;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.calculate.calculateProfitability;
import lotto.calculate.calculateResult;

public class calculateProfitabilityTest {
	@DisplayName("구입한 로또의 수익률을 소숫점 1자리로 정확하게 표현하는지 여부")
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


		calculateResult calculateResult = new calculateResult(userNumber,winningNumber,bonusNumber);
		calculateProfitability calculateProfitability = new calculateProfitability(calculateResult.calculateResult, userNumber);
		assertThat(calculateProfitability.calculateProfitability).isEqualTo(500.0);


	}
}

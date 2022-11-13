package lotto.domain.lotto;

import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.PurchaseCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
	LottoMachine lottoMachine;

	@BeforeEach
	void LottoMachineTestSetUp(){
		lottoMachine = new LottoMachine();
	}

	@DisplayName("컴퓨터 생성 난수의 개수를 확인한다")
	@Test
	void verifyGeneratedLottoNumbersSize() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method generateLottoNumbers = lottoMachine.getClass().getDeclaredMethod("generateLottoNumbers");
		generateLottoNumbers.setAccessible(true);

		List<Integer> actual = (List<Integer>) generateLottoNumbers.invoke(lottoMachine);
		int expected = 6;

		assertThat(actual.size()).isEqualTo(expected);
	}

	@DisplayName("컴퓨터 생성 난수의 범위에서 시작값과 마지막값이 들어있지 않은 것을 확인한다")
	@RepeatedTest(100)
	void verifyGeneratedLottoNumbersInBetweenAssignedNumbers() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method generateLottoNumbers = lottoMachine.getClass().getDeclaredMethod("generateLottoNumbers");
		generateLottoNumbers.setAccessible(true);

		List<Integer> actuals = (List<Integer>) generateLottoNumbers.invoke(lottoMachine);
		int firstNumberInclusive = 1;
		int lastNumberInclusive = 45;

		// condition 1
		for (int actual : actuals) {
			assertThat(actual).isBetween(firstNumberInclusive, lastNumberInclusive);
		}

		// condition 2
		assertThat(actuals).doesNotContain(firstNumberInclusive - 1, lastNumberInclusive + 1);
	}

	@DisplayName("컴퓨터 생성 로또의 개수가 제시된 금액에 따라 계산된 개수와 일치하는 것을 확인한다")
	@Test
	void verifyIssuedLottoSameAsDesignatedCount() {
		PurchaseCount purchaseCount = PurchaseCount.from(PurchaseAmount.from("1000"));
		lottoMachine.issueLotto(purchaseCount);

		int actual = LottoMachine.issuedLottoes.size();
		int expected = 1;

		assertThat(actual).isEqualTo(expected);
	}
}

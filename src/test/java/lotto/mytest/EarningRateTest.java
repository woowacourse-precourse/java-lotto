package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.EarningRate;

public class EarningRateTest {
	int paidMoney;
	Long earningMoney;
	double earningRate;

	@DisplayName("수익률 계산 확인")
	@Test
	void earningRate() {
		paidMoney = 8000;
		earningMoney = 5000L;
		earningRate = EarningRate.calculate(paidMoney, earningMoney);
		assertThat(earningRate).isEqualTo(62.5);
	}
}

package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.EarningRate;

public class EarningRateTest {
	int paidMoney;
	int earningMoney;
	double earningRate;

	@DisplayName("수익률 계산 확인")
	@Test
	void earningRate() {
		paidMoney = 8000;
		earningMoney = 5000;
		earningRate = EarningRate.calculate(paidMoney, earningMoney);
		assertThat(earningRate).isEqualTo(62.5);
	}
}

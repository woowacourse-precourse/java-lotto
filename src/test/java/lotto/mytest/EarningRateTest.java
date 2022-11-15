package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.EarningRate;

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

	@DisplayName("소숫점 첫째 자리에서 반올림 확인")
	@Test
	void roundOff() {
		paidMoney = 8888;
		earningMoney = 5000L;
		earningRate = EarningRate.calculate(paidMoney, earningMoney);
		assertThat(earningRate).isEqualTo(56.3);
	}
}

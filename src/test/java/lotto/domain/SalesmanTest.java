package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SalesmanTest {
	private Salesman salesman;

	@BeforeEach
	public void init() {
		salesman = new Salesman();
	}

	@Test
	public void 로또_판매_테스트() {
	    //given
		int purchaseBudget = 3000;

	    //when
		int lottoCount = salesman.sellLotto(purchaseBudget);
		int expected = 3;
	    //then
		assertThat(lottoCount).isEqualTo(expected);
	}

	@DisplayName("로또 구입 금액이 1000원 보다 작으면 예외가 발생한다.")
	@Test
	public void 작은_구입_금액_테스트() {
		int purchaseBudget = 500;
		assertThatThrownBy(() -> salesman.sellLotto(purchaseBudget))
			.isInstanceOf(IllegalArgumentException.class);
	}
}

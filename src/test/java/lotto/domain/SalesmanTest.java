package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
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
}

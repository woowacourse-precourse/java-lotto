package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SellerTest {

	@Nested
	class SellLottoTickets {

		@Test
		@DisplayName("돈이 1000원 단위가 아닌 경우, IllegalArgumentException 발생")
		void case1() throws Exception {
			// given
			final int money = 9_999;

			// when
			final ThrowableAssert.ThrowingCallable throwingCallable = () -> Seller.sellLottoTickets(money);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("돈이 20,000원인 경우, 로또 복권 20장 반환")
		void case2() throws Exception {
			// given
			final int money = 20_000;
			final int expected = 20;

			// when
			final List<Lotto> lottos = Seller.sellLottoTickets(money);

			// then
			assertThat(lottos.size()).isEqualTo(expected);
		}

	}

}
package model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoTotalCountCalculatorTest {

	private LottoTotalCountCalculator lottoTotalCountCalculator = new LottoTotalCountCalculator();
	
	@Nested
	class UnitTest {
		
		@Test
		@DisplayName("로또 구매 개수 테스트")
		void lottoTotalCountTest() {
			// given
			long price = 2000000;
			
			// when
			long expectedTotalCount = 2000;
			
			// then
			assertThat(lottoTotalCountCalculator.calculateLottoTotalCount(price)).isEqualTo(expectedTotalCount);
		}
	}
}

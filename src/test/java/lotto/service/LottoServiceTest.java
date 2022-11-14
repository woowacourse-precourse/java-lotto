package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoGroup;

public class LottoServiceTest {

	private final LottoService lottoService = LottoService.getInstance();

	@DisplayName("로또 구매 수량 입력시 원하는만큼 구매가 되었는지 확인하는 테스트")
	@Test
	void givenPurchaseQuantity_whenMakeLottoGroup_thenLottosSizeEqualPurchaseQuantity() {
		//given
		int purchaseQuantity = 8;

		//when
		LottoGroup lottoGroup = lottoService.makeLottoGroup(purchaseQuantity);

		//then
		Assertions.assertThat(lottoGroup.getLottosSize())
			.isEqualTo(purchaseQuantity);
	}

}

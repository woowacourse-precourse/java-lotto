package lotto.domain.lotto;

import lotto.domain.player.PurchaseAmount;
import lotto.domain.player.PurchaseCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {
	@DisplayName("컴퓨터 생성 로또의 개수가 제시된 금액에 따라 계산된 개수와 일치하는 것을 확인한다")
	@Test
	void verifyIssuedLottoSameAsDesignatedCount() {
		LottoMachine lottoMachine = new LottoMachine();

		PurchaseCount purchaseCount = PurchaseCount.from(PurchaseAmount.from("1000"));
		LottoTickets lottoTickets = LottoTickets.setsOf(lottoMachine.issueLotto(purchaseCount));

		int actual = lottoTickets.getLottoTickets().size();
		int expected = 1;

		assertThat(actual).isEqualTo(expected);
	}
}

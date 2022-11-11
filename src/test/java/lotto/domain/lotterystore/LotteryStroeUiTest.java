package lotto.domain.lotterystore;

import lotto.domain.lotteryseller.LotterySeller;
import lotto.dto.lotterystore.MoneyForPurchase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LotteryStroeUiTest {
	private static LotterySeller lotterySeller;
	@BeforeAll static void initializeTest() {
		lotterySeller = LotterySeller.getLotterySeller();
	}

	@DisplayName("자동생성된 로또 번호를 모두 출력합니다.") @Test void 로또번호출력() {
		lotterySeller.receiveInformationAboutPurchase(new MoneyForPurchase("45000"));
		lotterySeller.sendGeneratedLotterySets();
	}
}

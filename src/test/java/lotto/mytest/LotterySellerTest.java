package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LotterySeller;

public class LotterySellerTest {
	@DisplayName("구매한 로또 개수만큼 로또를 생성한다.")
	@Test
	void createLotto() {
		LotterySeller seller = new LotterySeller();
		assertThat(LotterySeller.sellLottery(3).size()).isEqualTo(3);
	}
}

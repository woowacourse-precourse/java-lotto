package player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void 입력받은_금액을_반환() {
		int coin = 13000;
		
		assertThat(coin).isEqualTo(13000);
	}

}

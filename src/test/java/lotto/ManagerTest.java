package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	void 로또_구매_메서드_테스트(){
		String valid = "14000";
		Manager.buyLottos(valid);
		String notDivisible = "3589";
		assertThatThrownBy(() -> Manager.buyLottos(notDivisible))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_DIVISIBLE_MONEY.getMessage());
	}

	@Test
	void 구매_목록_확인_테스트(){
		String money = "14000";
		Manager.showGeneratedLottos(Manager.buyLottos(money));
		assertThat(Manager.lottoMachine.getLottos().size()).isEqualTo(14);
	}
}

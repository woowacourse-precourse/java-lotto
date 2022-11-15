package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ManagerTest {

	// @Test
	// void 로또_구매_메서드_테스트(){
	// 	String valid = "14000";
	// 	Manager.buyLottos();
	// 	String notDivisible = "3589";
	// 	assertThatThrownBy(() -> Manager.buyLottos())
	// 		.isInstanceOf(IllegalArgumentException.class)
	// 		.hasMessageContaining(Message.ERROR.getMessage() + Message.NOT_DIVISIBLE_MONEY.getMessage());
	// }
	//
	// @Test
	// void 구매_목록_확인_테스트(){
	// 	String money = "14000";
	// 	Manager.showGeneratedLottos(Manager.buyLottos());
	// 	assertThat(Manager.lottoMachine.getLottos().size()).isEqualTo(14);
	// }
	//
	// @Test
	// void 당첨_번호_정상_저장_확인(){
	// 	String numbers = "1,2,3,4,5,6";
	// 	List<Integer> number = Manager.formatting(numbers);
	// 	Manager.inputWinningNumbers();
	// 	assertThat(Manager.lotto.getNumbers()).isEqualTo(number);
	// }
}

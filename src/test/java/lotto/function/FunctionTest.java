package lotto.function;

import lotto.domain.jackpot.JackpotResult;
import lotto.domain.lotto.Lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTest {

	@Test
	void 잭팟_개수가_정확히_카운트_되는지() {
		//given
		List<Integer> lottos = one_of_lotto();

		JackpotResult jr=new JackpotResult();

		int jackpot_number=4;
		//when
		Lotto.compare_jackpot_number(jackpot_number,lottos,jr);
		//then
		assertThat(jr.return_jackpot_count()).isEqualTo(1);
	}

	@Test
	void 보너스_개수가_정확히_카운트_되는지() {
		//given
		List<Integer> lottos = one_of_lotto();

		JackpotResult jr = new JackpotResult();

		int bonus_number = 4;
		//when
		Lotto.compare_bonus_number(bonus_number, lottos, jr);
		//then
		assertThat(jr.return_bonus_count()).isEqualTo(1);
	}

	private static List<Integer> one_of_lotto() {
		List<Integer> purchase = new ArrayList<>();
		purchase.add(1);
		purchase.add(2);
		purchase.add(3);
		purchase.add(4);
		purchase.add(5);
		purchase.add(6);

		return purchase;
	}
}
package lotto.function;


import lotto.domain.jackpot.JackpotResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.prize.PrizeResult;
import lotto.domain.rate.Rate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
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

	@Test
	void MAP에_정확히_카운트_되는지_확인_1() {
		//given
		PrizeResult pr=new PrizeResult();
		pr.prize_set_by_count(5,1);
		//when
		HashMap<String, Integer> hashMap = pr.prize_map_return();
		int hit_five_and_bonus = hashMap.get("5개 일치, 보너스 볼 일치");
		//then
		assertThat(hit_five_and_bonus).isEqualTo(1);
	}

	@Test
	void MAP에_정확히_카운트_되는지_확인_2() {
		//given
		PrizeResult pr=new PrizeResult();
		pr.prize_set_by_count(4,0);
		//when
		HashMap<String, Integer> hashMap = pr.prize_map_return();

		//then
		assertThat(hashMap.get("4개 일치")).isEqualTo(1);
	}

	@Test
	void MAP에_있는_값만_가져오기_정상작동하는지() {
		//given
		HashMap<String,Integer> testMap=new HashMap<>();
		testMap.put("3개 일치",1);
		testMap.put("5개 일치",2);
		//when
		List<Integer> money_list = Rate.prize_money_list_return(testMap);
		int prize_money_sum = Rate.prize_money_sum(money_list);
		//then
		assertThat(prize_money_sum).isEqualTo(3005000);
	}

	@Test
	void ENUM_GET_PRIZE_MONEY_이넘값에_존재하는_금액추출_테스트(){
		//given
		String key="4개 일치";
		//when
		int money = Rate.add_money_list(key);
		//then
		assertThat(money).isEqualTo(50000);
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
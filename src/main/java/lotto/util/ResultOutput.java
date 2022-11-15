package lotto.util;

import lotto.domain.jackpot.Jackpot;
import lotto.domain.prize.PrizeResult;
import lotto.domain.rate.Rate;

import java.util.HashMap;
//예기치 못한 오류 테스트 커밋
public class ResultOutput {
	private static HashMap<String,Integer> result_map=PrizeResult.prize_map_return();
	public static void all_result_output(){
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - "+prize_three()+"개");
		System.out.println("4개 일치 (50,000원) - "+prize_four()+"개");
		System.out.println("5개 일치 (1,500,000원) - "+prize_five()+"개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+prize_five_and_bonus()+"개");
		System.out.println("6개 일치 (2,000,000,000원) - "+prize_six()+"개");
		System.out.println("총 수익률은 "+Rate.calculate_rate(result_map)+"%입니다.");
		Jackpot.set_jackpot_and_bonus_number_static_zero();
		PrizeResult.set_prize_map_clear();
		set_result_map_clear();
	}

	private static int prize_three(){
		if (result_map.get("3개 일치")==null){
			return 0;
		}
		return result_map.get("3개 일치");
	}

	private static int prize_four(){
		if (result_map.get("4개 일치")==null){
			return 0;
		}
		return result_map.get("4개 일치");
	}

	private static int prize_five(){
		if (result_map.get("5개 일치")==null){
			return 0;
		}
		return result_map.get("5개 일치");
	}

	private static int prize_five_and_bonus(){
		if (result_map.get("5개 일치, 보너스 볼 일치")==null){
			return 0;
		}
		return result_map.get("5개 일치, 보너스 볼 일치");
	}

	private static int prize_six(){
		if (result_map.get("6개 일치")==null){
			return 0;
		}
		return result_map.get("6개 일치");
	}

	public static void set_result_map_clear(){
		result_map.clear();
	}
}

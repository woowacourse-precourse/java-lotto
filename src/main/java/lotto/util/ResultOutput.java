package lotto.util;

import lotto.domain.prize.PrizeResult;
import lotto.domain.rate.Rate;

import java.util.HashMap;
//예기치 못한 오류 테스트 커밋
public class ResultOutput {
	private static HashMap<String,Integer> result_map=PrizeResult.prize_map_return();
	public static void all_result_output(){
		StringBuilder sb=new StringBuilder();
		sb.append("\n당첨 통계\n").append("---\n");
		sb.append("3개 일치 (5,000원) - "+prize_three()+"개\n");
		sb.append("4개 일치 (50,000원) - "+prize_four()+"개\n");
		sb.append("5개 일치 (1,500,000원) - "+prize_five()+"개\n");
		sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - "+prize_five_and_bonus()+"개\n");
		sb.append("6개 일치 (2,000,000,000원) - "+prize_six()+"개\n");
		sb.append("총 수익률은 "+Rate.calculate_rate(result_map)+"%입니다.");
		System.out.println(sb);
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

}

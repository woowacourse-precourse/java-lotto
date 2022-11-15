package lotto.domain.prize;

import java.util.HashMap;
import java.util.LinkedHashMap;
//예기치 못한 오류 테스트 커밋
public class PrizeResult {

	private static HashMap<String,Integer> prize_map=new LinkedHashMap<>();

	public static void prize_set_by_count (int jackpot_count,int bonus_count){
		if (jackpot_count==3)
			prize_three();
		if (jackpot_count==4)
			prize_four();
		if (jackpot_count==5)
			prize_five();
		if (jackpot_count==5&&bonus_count==1)
			prize_five_and_bonus();
		if (jackpot_count==6)
			prize_SIX();

	}

	private static void prize_three(){
		String grade = Prize.THREE.getGrade();
		prize_map.put(grade,prize_map.getOrDefault(grade,0)+1);
	}

	private static void prize_four(){
		String grade = Prize.FOUR.getGrade();
		prize_map.put(grade,prize_map.getOrDefault(grade,0)+1);
	}

	private static void prize_five(){
		String grade = Prize.FIVE.getGrade();
		prize_map.put(grade,prize_map.getOrDefault(grade,0)+1);
	}

	private static void prize_five_and_bonus(){
		String grade = Prize.FIVE_B.getGrade();
		prize_map.put(grade,prize_map.getOrDefault(grade,0)+1);
	}

	private static void prize_SIX(){
		String grade = Prize.SIX.getGrade();
		prize_map.put(grade,prize_map.getOrDefault(grade,0)+1);
	}

	public static HashMap<String,Integer> prize_map_return(){
		return prize_map;
	}
}

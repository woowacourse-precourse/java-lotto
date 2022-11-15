package lotto.domain.rate;

import lotto.domain.lotto.BuyLotto;
import lotto.domain.prize.Prize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//예기치 못한 오류 테스트 커밋
public class Rate {

	public static String calculate_rate(HashMap<String,Integer> hashMap){

		if (hashMap.isEmpty()) return "0.0";

		double money = Integer.parseInt(BuyLotto.USER_MONEY_return());
		List<Integer> prize_money_list = prize_money_list_return(hashMap);
		double money_sum = prize_money_sum(prize_money_list);
		double result_rate = (money_sum / money) * 100;
		String result = String.format("%.1f", result_rate);
		return result;
	}

	public static List<Integer> prize_money_list_return(HashMap<String,Integer> hashMap){
		List<Integer> prize_money_list=new ArrayList<>();
		for (String key: hashMap.keySet()){
			prize_money_list.add(add_money_list(key)*hashMap.get(key));
		}
		return prize_money_list;
	}

	public static int add_money_list(String key){
		if (key.equals(Prize.THREE.getGrade()))
			return Integer.parseInt(Prize.THREE.getPrize_money().replaceAll(",",""));
		if (key.equals(Prize.FOUR.getGrade()))
			return Integer.parseInt(Prize.FOUR.getPrize_money().replaceAll(",",""));
		if (key.equals(Prize.FIVE.getGrade()))
			return Integer.parseInt(Prize.FIVE.getPrize_money().replaceAll(",",""));
		if (key.equals(Prize.FIVE_B.getGrade()))
			return Integer.parseInt(Prize.FIVE_B.getPrize_money().replaceAll(",",""));
		if (key.equals(Prize.SIX.getGrade()))
			return Integer.parseInt(Prize.SIX.getPrize_money().replaceAll(",",""));

		return 0;
	}

	public static int prize_money_sum(List<Integer> prize_money_list){
		int money_sum=0;
		for (int i=0;i<prize_money_list.size();i++){
			money_sum+=prize_money_list.get(i);
		}
		return money_sum;
	}
}

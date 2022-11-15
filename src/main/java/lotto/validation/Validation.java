package lotto.validation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
//예기치 못한 오류 테스트 커밋
public class Validation {
	private static List<String> jackpot_number_list_compare;
	//============================사용자 입력 금액 예외 처리============================//

	public static boolean money_validation(String validation_param){
		if (validation_param.matches("^[0-9]*$")){

			BigInteger money = new BigInteger(validation_param);
			BigInteger target = BigInteger.valueOf(1000);

			if (money_remainder_result_equal_zero(money,target)){
				return true;
			}

		}

		return false;
	}
	private static boolean money_remainder_result_equal_zero(BigInteger money,BigInteger target){

		if (money.remainder(target).compareTo(BigInteger.valueOf(0))==0){
			return true;
		}

		return false;
	}

	//============================당첨 번호 예외 처리============================//

	public static boolean jackpot_number_validation(String jackpot_number){

		if (jackpot_number.contains(",")){//문자 자체에 ',' 이 포함되어 있어야지만 조건이 성립된다.
			if(jackpot_number_length_validation(jackpot_number)){
				return true;
			}
		}

		return false;
	}

	private static boolean jackpot_number_length_validation(String jackpot_number) {
		List<String> jackpot_number_list = Arrays.asList(jackpot_number.split(","));

		jackpot_number_list_compare=jackpot_number_list;

		if(jackpot_number_list.size()==6){
			if (jackpot_number_regex_validation(jackpot_number,jackpot_number_list)){
				return true;
			}
		}

		return false;
	}

	private static boolean jackpot_number_regex_validation(String jackpot_number,List<String> jackpot_number_list){
		String eliminate_comma = jackpot_number.replaceAll(",", "");

		if (eliminate_comma.matches("^[0-9]*$")){
			if (jackpot_number_range_validation(jackpot_number_list)){
				return true;
			}
		}

		return false;
	}

	private static boolean jackpot_number_range_validation(List<String> jackpot_number_list){
		boolean RANGE_FLAG=true;

		for (int i=0;i<jackpot_number_list.size();i++){

			int jackpot_number = Integer.parseInt(jackpot_number_list.get(i));

			if (1>jackpot_number||jackpot_number>45){
				RANGE_FLAG=false;
				break;
			}
		}

		return RANGE_FLAG;
	}

	//============================보너스 번호 예외 처리============================//

	public static boolean bonus_number_validation(String bonus_number){

		if (bonus_number.matches("^[0-9]*$")){
			if (bonus_number_length_validation(bonus_number)){
				return true;
			}
		}

		return false;
	}

	private static boolean bonus_number_length_validation(String bonus_number){

		if (bonus_number.length()==1||bonus_number.length()==2){
			if (bonus_number_range_validation(bonus_number)){
				return true;
			}
		}

		return false;
	}

	private static boolean bonus_number_range_validation(String bonus_number){
		int bonus = Integer.parseInt(bonus_number);

		if (0<bonus&&bonus<46){
			if (bonus_number_existCheck_validation(bonus_number)){
				return true;
			}
		}

		return false;
	}

	private static boolean bonus_number_existCheck_validation(String bonus_number){

		if (jackpot_number_list_compare.contains(bonus_number)){
			return false;
		}

		return true;
	}

	public static void setJackpot_number_list_compare(List<String> jackpot_number_list){
		jackpot_number_list_compare=jackpot_number_list;
	}
}

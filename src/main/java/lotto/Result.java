package lotto;

import java.util.List;

public class Result {

	public static String getLottoResultMessage(int index, Integer numberOfTimes) {

		if (index == Constant.FIRST_PLACE.condition)
			return Constant.FIRST_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.LOTTO_NUMBERS_LENGTH.value + 1)
			return Constant.SECOND_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.THIRD_PLACE.condition)
			return Constant.THIRD_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.FOURTH_PLACE.condition)
			return Constant.FOURTH_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.FIFTH_PLACE.condition)
			return Constant.FIFTH_PLACE.resultMessage + numberOfTimes + "개";

		return "";
	}

	public static String getRateOfReturn(int payment, List<Integer> result) {

		int totalPrizeMoney = getTotalPrizeMoney(payment, result);

		double rateOfReturn = (double) totalPrizeMoney / payment * 100;
		
		return "총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.";
	}

	public static int getTotalPrizeMoney(int payment, List<Integer> result) {

		int totalPrizeMoney = 0;
		int startIndex = Constant.FIFTH_PLACE.condition;
		int endIndex = Constant.LOTTO_NUMBERS_LENGTH.value + 1;

		for (int numberOfNumbers = startIndex; numberOfNumbers <= endIndex; numberOfNumbers++) {

			Integer numberOfTimes = result.get(numberOfNumbers);
			if (numberOfTimes == 0) continue;

			totalPrizeMoney += numberOfTimes * getPrizeMoney(numberOfNumbers);
		}
		return totalPrizeMoney;
	}

	public static int getPrizeMoney(int index) {

		if (index == Constant.FIRST_PLACE.condition)
			return Constant.FIRST_PLACE.prizeMoney;

		if (index == Constant.LOTTO_NUMBERS_LENGTH.value + 1)
			return Constant.SECOND_PLACE.prizeMoney;

		if (index == Constant.THIRD_PLACE.condition)
			return Constant.THIRD_PLACE.prizeMoney;

		if (index == Constant.FOURTH_PLACE.condition)
			return Constant.FOURTH_PLACE.prizeMoney;

		if (index == Constant.FIFTH_PLACE.condition)
			return Constant.FIFTH_PLACE.prizeMoney;

		return 0;
	}
}

package model;

import static model.LottoMachineConstants.*;
import static model.LottoProfitCalculatorConstants.*;

import java.util.Map;

public class LottoProfitCalculator {

	public double calculateLottoProfit(Map<Integer, Integer> winningDetails, long lottoPurchaseAmount) {

		long winningAmount = calculateWinningAmount(winningDetails);
		return (double) winningAmount / (double) lottoPurchaseAmount * UNIT;
	}

	private long calculateWinningAmount(Map<Integer, Integer> winningDetails) {
		long winningAmount = 0;
		long fifthCount = winningDetails.get(RANK_FIFTH);
		long fourthCount = winningDetails.get(RANK_FOURTH);
		long thirdCount = winningDetails.get(RANK_THIRD);
		long secondCount = winningDetails.get(RANK_SECOND);
		long firstCount = winningDetails.get(RANK_FIRST);

		winningAmount += fifthCount * LOTTO_FIFTH_PLACE_PRIZE_MONEY;
		winningAmount += fourthCount * LOTTO_FOURTH_PLACE_PRIZE_MONEY;
		winningAmount += thirdCount * LOTTO_THIRD_PLACE_PRIZE_MONEY;
		winningAmount += secondCount * LOTTO_SECOND_PLACE_PRIZE_MONEY;
		winningAmount += firstCount * LOTTO_FIRST_PLACE_PRIZE_MONEY;

		return winningAmount;
	}
}

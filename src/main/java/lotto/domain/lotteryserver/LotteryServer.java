package lotto.domain.lotteryserver;

import lotto.controller.LotteryRequestController;
import lotto.domain.lotterystore.LotteryStoreUi;
import lotto.dto.lotteryseller.LottoSetsDto;
import lotto.dto.lotterystore.MoneyDto;
import lotto.dto.lotterystore.WinningNumbersDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryServer {
	private int money;
	private List<List<Integer>> lottoSets;
	private List<Integer> winningNumbers;
	private int bonusNumber;

	public void receiveMoney(MoneyDto money) {
		String receivedMoney = money.getMoney();
		this.money = Integer.parseInt(receivedMoney);
	}

	public void receiveLottoSets(LottoSetsDto lottoSetsDto) {
		this.lottoSets = lottoSetsDto.getLottoSets();
	}

	public void receiveWinningNumbers(WinningNumbersDto winningNumbers) {
		String winningPrize = winningNumbers.getWinningNumbers();
		this.winningNumbers = convertToValidFormForWinning(winningPrize);

		String bonus = winningNumbers.getBonusNumber();
		this.bonusNumber = convertToValidFormForBonus(bonus);
	}

	public void sendLottoResultMessage(LotteryRequestController lotteryRequestController,
		LotteryStoreUi storeUi) {
		List<Rank> winningStatistics =
			WinningChecker.getStatistics(this.lottoSets, this.winningNumbers, this.bonusNumber);
		String profit = WinningChecker.getProfit(winningStatistics, this.money);

		String resultMessage = getResultMessage(winningStatistics, profit);

		lotteryRequestController.receiveLottoResultMessage(resultMessage, storeUi);
	}

	private List<Integer> convertToValidFormForWinning(String winningPrize) {
		String[] numbers = winningPrize.split(",");
		List<Integer> winningPrizeNumbers = new ArrayList<>();

		if (LotteryServerExceptions.isNumbersExceptions(numbers)) {
			throw new IllegalArgumentException(Messages.getLottoNumbersError());
		}

		Arrays.stream(numbers).sorted()
			.forEach(elem -> winningPrizeNumbers.add(Integer.parseInt(elem)));

		return winningPrizeNumbers;
	}

	private int convertToValidFormForBonus(String bonus) {
		if (LotteryServerExceptions.isBonusExceptions(bonus)) {
			throw new IllegalArgumentException(Messages.getBonusNumberError());
		}

		return Integer.parseInt(bonus);
	}

	private String getResultMessage(List<Rank> winningStatistics, String profit) {
		StringBuilder resultMessage = new StringBuilder();
		RankInfo rankInfo = new RankInfo();

		for (Rank rank : winningStatistics) {
			rankInfo.update(rank);
		}

		resultMessage.append(ResultBuilder.getFirstAnnouncement());
		String prizeResult = Arrays.stream(Rank.values()).filter(rank -> rank != Rank.NOTHING)
			.map(rank -> buildPrizeMessage(rankInfo, rank)).collect(Collectors.joining());
		resultMessage.append(prizeResult);
		resultMessage.append(buildProfitMessage(profit));

		return resultMessage.toString();
	}

	private String buildPrizeMessage(RankInfo rankInfo, Rank rank) {
		return ResultBuilder.getMatchedNumber(rank) + ResultBuilder.getPrizeMoney(rank)
			+ ResultBuilder.getCountedNumber(rankInfo, rank) + ResultBuilder.getNewLine();
	}

	private String buildProfitMessage(String profit) {
		return ResultBuilder.getProfit(profit);
	}
}

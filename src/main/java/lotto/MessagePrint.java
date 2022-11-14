package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.SortedMap;

public class MessagePrint {

	public void purchaseLottoPrint() {
		System.out.println(Constants.PURCHASE_PRIZE_MESSAGE);
	}

	public void changeList(List<Integer> list) {
		System.out.println(list);
	}

	public void countLottoPrint(String inputPrice) {
		LottoProgram lottoProgram = new LottoProgram();
		System.out.println(lottoProgram.countLotto(inputPrice) + Constants.COUNT_LOTTO_PRINT);
	}

	public void inputWinNumPrint() {
		System.out.println(Constants.INPUT_LOTTO_NUMBER_PRINT);
	}

	public void inputBonusNumPrint() {
		System.out.println(Constants.INPUT_BONUS_NUMBER_PRINT);
	}

	public void lottoResultView(StoreMap storeMap) {
		System.out.println(Constants.WINNING_STATISTICS);
		System.out.println(Constants.WINNING_STATISTICS_DIVISION);
		lottoStoreMapView(storeMap.getStoreMap());
		lottoPercentView(storeMap);
	}

	public void lottoStoreMapView(SortedMap<Rank, Integer> StoreMap) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.printf(Constants.WIN_TOTAL_MESSAGE, Rank.FIFTH.getCountOfMatch(), nf.format(Rank.FIFTH.getWinningMoney()),
			StoreMap.get(Rank.FIFTH));
		System.out.printf(Constants.WIN_TOTAL_MESSAGE, Rank.FOURTH.getCountOfMatch(), nf.format(Rank.FOURTH.getWinningMoney()),
			StoreMap.get(Rank.FOURTH));
		System.out.printf(Constants.WIN_TOTAL_MESSAGE, Rank.THIRD.getCountOfMatch(), nf.format(Rank.THIRD.getWinningMoney()),
			StoreMap.get(Rank.THIRD));
		System.out.printf(Constants.WIN_BONUS_TOTAL_MESSAGE, Rank.SECOND.getCountOfMatch(), nf.format(Rank.SECOND.getWinningMoney()),
			StoreMap.get(Rank.SECOND));
		System.out.printf(Constants.WIN_TOTAL_MESSAGE, Rank.FIRST.getCountOfMatch(), nf.format(Rank.FIRST.getWinningMoney()),
			StoreMap.get(Rank.FIRST));
	}

	public void lottoPercentView(StoreMap storeMap) {
		LottoProgram lottoProgram = new LottoProgram();
		System.out.print(Constants.TOTAL_PROFIT);
		System.out.printf("%.1f", lottoProgram.lottoPercentCalculate(storeMap));
		System.out.println(Constants.END_MESSAGE);
	}
}

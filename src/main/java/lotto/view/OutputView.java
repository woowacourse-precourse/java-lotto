package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.LottoRanking;

public class OutputView {

	public static final String MESSAGE_PURCHASE = "개를 구매했습니다.";
	static OutputView instance;

	private OutputView(){}

	public static OutputView getInstance(){
		if(instance == null){
			instance = new OutputView();
		}
		return instance;
	}

	public void LottoInformation(int purchaseCount, List<Lotto> lottoBundle) {
		PurchaseAmount(purchaseCount);
		LottoNumber(lottoBundle);
	}

	private void PurchaseAmount(int purchaseAmount) {
		System.out.println(purchaseAmount + MESSAGE_PURCHASE);
	}

	private void LottoNumber(List<Lotto> lottoBundle) {
		Stream<Lotto> lottoStream = lottoBundle.stream();
		lottoStream.forEach(System.out::println);
	}

	public void lottoResult(Map<LottoRanking, Integer> prizeResult) {
		System.out.println("3개 일치 (5,000원) - " + prizeResult.get(LottoRanking.FIFTH) + "개");
		System.out.println("4개 일치 (50,000원) - " + prizeResult.get(LottoRanking.FOURTH) + "개");
		System.out.println("5개 일치 (1,500,000원) - " + prizeResult.get(LottoRanking.THIRD) + "개");
		System.out.println("5개 일치, 보너스 불 일치 (30,000,000원) - " + prizeResult.get(LottoRanking.SECOND) + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + prizeResult.get(LottoRanking.FIRST) + "개");
	}

	public void yield(double yield) {
		System.out.println(String.format("총 수익률은 %.2f%%입니다", yield));
	}
}

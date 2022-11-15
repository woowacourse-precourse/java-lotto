package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
	private static int purchaseAmount;
	private static int lottoAmount;
	private List<Lotto> lottos = new ArrayList<>();
	LottoMachine lottoMachine = new LottoMachine();

	public void inputPurchaseAmount() {
		System.out.println(Message.INPUT_PURCHASE_AMOUNT_MESSAGE);
		purchaseAmount = Valid.validatePurchaseAmount(readLine());
	}

	public void purchaseLotto() {
		System.out.println(lottoAmount + Message.LOTTO_PURCHASE_MESSAGE);
		do {
			List<Integer> lotto = lottoMachine.generateLotto();
			System.out.println(lotto);
			lottos.add(new Lotto(lotto));
		} while (lottos.size() < lottoAmount);
	}

	public void computeLottoAmount() {
		lottoAmount = purchaseAmount / Constant.LOTTO_PRICE;
	}

	public void prizeResult() {
		System.out.println(Message.RESULT_OF_LOTTO);
		HashMap<Prize, Integer> result= setResult();
		for (Lotto lotto : lottos) {
			int hitNumber = lottoMachine.countHitNumber(lotto);
			boolean bonusNumber = lottoMachine.hitBonusNumber(lotto);
			if (hitNumber >= 3) {
				Prize prize = Prize.computePrize(hitNumber, bonusNumber);
				result.put(prize, result.get(prize) + 1);
			}
		}
		printResult(result);
		printTotalReturn(result);
	}

	private HashMap<Prize, Integer> setResult() {
		HashMap<Prize, Integer> result = new HashMap<>();

		for (Prize prize : Prize.values()) {
			result.put(prize, 0);
		}
		return result;

	}

	private void printResult(HashMap<Prize, Integer> result) {
		for (int rank = Prize.values().length - 1; rank >= 0; rank--) {
			System.out.println(Prize.values()[rank].getMessage() + result.get(Prize.values()[rank]) + "개");
		}
	}

	private void printTotalReturn(HashMap<Prize, Integer> result) {
		double totalReturn = 0D;

		for (Prize prize : result.keySet()) {
			int prizeMoney = prize.getPrizeMoney();
			int winningNumber = result.get(prize);
			totalReturn +=  ((double) (prizeMoney * winningNumber * 100) / (double) purchaseAmount);
		}
		System.out.println("총 수익률은 "+String.format("%.1f", totalReturn)+"%입니다.");
	}


}

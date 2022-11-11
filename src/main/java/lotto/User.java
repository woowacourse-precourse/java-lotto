package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
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
}

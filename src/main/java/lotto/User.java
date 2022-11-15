package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

public class User {
	private Integer lottoCount;
	private UserLotto userLottoes;

	public User() {
		Print.PrintUserPurchaseAmount();

		String stringLottoMoney = Console.readLine();
		Exception.UserContainExceptNumber(stringLottoMoney);

		this.lottoCount = Integer.parseInt(stringLottoMoney);
		Exception.UserMoneyDivide1000(lottoCount);
		this.lottoCount /= 1000;

		Print.PrintUserPurchaseLottoAmount(this.lottoCount);

		this.userLottoes = new UserLotto(lottoCount);
		Print.PrintUserLottoNumbers(userLottoes);
	}

	public UserLotto getUserLottoes() {
		return this.userLottoes;
	}

	public Integer getLottoCount() {
		return this.lottoCount;
	}

}

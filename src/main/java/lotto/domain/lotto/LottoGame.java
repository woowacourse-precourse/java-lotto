package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.person.Person;

public class LottoGame {

	Person person;

	public void start() {
		System.out.println("구입금액을 입력해 주세요.");
		String money = askPurchaseAmount();
		person = new Person(money);
		List<Lotto> lottos = person.buyLotto();
		System.out.println();
		System.out.println(lottos.size() + "개를 구매했습니다");
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers().toString());
		}
		System.out.println();
		System.out.println("당첨 번호를 입력해 주세요.");
		String winLottoNumber = askWinLottoNumber();
		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");
		String bonusNumber = askBonusNumber();


	}


	public String askPurchaseAmount() {
		return Console.readLine();
	}

	public String askWinLottoNumber() {
		return Console.readLine();
	}

	public String askBonusNumber() {
		return Console.readLine();
	}
}

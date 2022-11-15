package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.machine.LottoMachine;
import lotto.domain.person.Person;
import lotto.domain.win.WinningStats;

public class LottoGame {

	Person person;
	List<Lotto> lottos;

	LottoMachine lottoMachine;

	public void start() {
		String money = askPurchaseAmount();
		printPurchaseLotto(money);
		String winLottoNumber = askWinLottoNumber();
		String bonusNumber = askBonusNumber();
		System.out.println();
		lottoMachine = new LottoMachine(winLottoNumber, bonusNumber);
		WinningStats winningStats = new WinningStats(person, lottoMachine);
		winningStats.printWinningStats();

	}


	public String askPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return Console.readLine();
	}

	public void printPurchaseLotto(String money) {
		person = new Person(money);
		lottos = person.buyLotto();
		int lottoCount = lottos.size();
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다");
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers().toString());
		}
		System.out.println();
	}


	public String askWinLottoNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		return Console.readLine();
	}

	public String askBonusNumber() {
		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");
		return Console.readLine();
	}
}

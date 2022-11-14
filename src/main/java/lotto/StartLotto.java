package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class StartLotto {

	private Money money;
	private Numbers numbers;
	private Lotto lotto;
	private Bonus bonus;
	private Statistics statistics;

	public StartLotto() {
		inputMoney();
		inputWinningNumbers();
		inputBonus();

		statistics = new Statistics(numbers.getNumbers(), lotto.getLotto(), money.getMoney(), bonus.getBonus());
		System.out.println(statistics.toString());
	}

	private void inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = Console.readLine();
		validateMoney(input);

		money = new Money(Integer.parseInt(input));
		int lottoCount = money.getLottoCount();
		numbers = new Numbers(lottoCount);

		System.out.println(lottoCount + "개를 구매했습니다.");
		System.out.println(numbers.toString());
	}

	private void inputWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		StringTokenizer token = new StringTokenizer(Console.readLine(), ",");

		List<Integer> winningNumbers = new ArrayList<>();

		while(token.hasMoreTokens()) {
			String item = token.nextToken();
			validateNumbers(item);
			winningNumbers.add(Integer.parseInt(item));
		}

		lotto = new Lotto(winningNumbers);
	}

	private void inputBonus() {
		System.out.println("보너스 번호를 입력해 주세요.");
		String input = Console.readLine();
		validateNumbers(input);

		bonus = new Bonus(Integer.parseInt(input));
	}

	private void validateMoney(String input) {
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)  < 48 || 57 < input.charAt(i)) {
				throwException(ErrorMessage.TYPE_ERROR);
			}
		}
	}

	private void validateNumbers(String input) {
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i)  < 49 || 57 < input.charAt(i)) {
				throwException(ErrorMessage.TYPE_ERROR);
			}
		}
	}

	private void throwException(ErrorMessage errorType) {
		errorType.printErrorMessage();
		throw new IllegalArgumentException();
	}
}

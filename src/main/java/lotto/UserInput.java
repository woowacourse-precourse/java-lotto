package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
	
	public UserInput() {
		inputMoney();
		inputWinningNumbers();
		inputBonus();
	}
	
	private void inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		Money money = new Money(Integer.parseInt(Console.readLine()));
		
		int lottoCount = money.getLottoCount();
		Numbers numbers = new Numbers(lottoCount);
		
		System.out.println(lottoCount + "개를 구매했습니다.");
		System.out.println(numbers.toString());
	}
	
	private void inputWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		StringTokenizer token = new StringTokenizer(Console.readLine(), ",");
		
		List<Integer> winningNumbers = new ArrayList<>();
		
		while(token.hasMoreTokens()) {
			winningNumbers.add(Integer.parseInt(token.nextToken()));
		}
		
		Lotto lotto = new Lotto(winningNumbers);
	}
	
	private void inputBonus() {
		System.out.println("보너스 번호를 입력해 주세요.");
		Bonus bonus = new Bonus(Integer.parseInt(Console.readLine()));
	}
}

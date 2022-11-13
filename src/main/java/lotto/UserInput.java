package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
	private Money money;
	private Lotto lotto;
	private Bonus bonus;
	
	UserInput() {
		money = new Money(money());
		lotto = new Lotto(userNumbers());
		bonus = new Bonus(bonusNumber());
	}
	
	
	private int money() {
		String message = "구입금액을 입력해 주세요.";
		System.out.println(message);
		
		int money = Integer.parseInt(Console.readLine());
		return money;
	}
	
	private List<Integer> userNumbers() {
		String message = "당첨 번호를 입력해 주세요";
		System.out.println(message);
		
		StringTokenizer token = new StringTokenizer(Console.readLine(), ",");
		
		List<Integer> numbers = new ArrayList<>();
		
		while(token.hasMoreTokens()) {
			numbers.add(Integer.parseInt(token.nextToken()));
		}
		
		return numbers;
	}
	
	private int bonusNumber() {
		String message = "보너스 번호를 입력해 주세요";
		System.out.println(message);
		
		int bonus = Integer.parseInt(Console.readLine());
		return bonus;
	}
}

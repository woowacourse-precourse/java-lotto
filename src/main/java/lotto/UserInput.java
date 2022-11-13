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
		lotto = new Lotto(lottoNumbers());
		bonus = new Bonus(bonusNumber());
	}
	
	
	private int money() {
		int money = Integer.parseInt(Console.readLine());
		return money;
	}
	
	private List<Integer> lottoNumbers() {
		StringTokenizer token = new StringTokenizer(Console.readLine(), ",");
		
		List<Integer> numbers = new ArrayList<>();
		
		while(token.hasMoreTokens()) {
			numbers.add(Integer.parseInt(token.nextToken()));
		}
		
		return numbers;
	}
	
	private int bonusNumber() {
		int bonus = Integer.parseInt(Console.readLine());
		return bonus;
	}
	
}

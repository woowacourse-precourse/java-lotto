package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.VO.LottoVO;
import lotto.constants.Constants;
import lotto.exception.Lotto;

public class Service {
	LottoVO lotto = new LottoVO();
	Constants constants = new Constants();

	public String setInputPrice() {
		System.out.println(constants.getBuyPrice());
		String price = Console.readLine();
		lotto.setPrice(price);
		return price;
	}

	public int setInputNumbers(String inputNumber) {
		int ea = Integer.parseInt(inputNumber) / constants.getLottoPrice();
		System.out.println(ea + constants.getBuyEach());
		return ea;
	}

	public void setBuyLotto(int ea) {		
		for (int i = 0; i < ea; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Lotto lotto = new Lotto(numbers); // 예외처리
			// 오름차순 정렬 삽입구간
			this.lotto.lotto.add(numbers);
		}		
		System.out.println(lotto.getLotto());
		setGoalNumbers();
	}

	public int setGoalNumbers() {
		System.out.println(constants.getInputGoalNumbers());
		String goalNumbers = Console.readLine();
		goalNumbers.replace(",", "");
		String match = "[^\uAC00-\uD7A30-9a-zA-Z\\s]";
		goalNumbers = goalNumbers.replaceAll(match, "");
		int parseNumbers = Integer.parseInt(goalNumbers);
		return parseNumbers;
	}
	
	public void setBonusGoalNumbers() {
		System.out.println(constants.getInputBonusNumbers());
		String bonusNumbers = Console.readLine();
		lotto.setBonusNumbers(bonusNumbers);
	}
}

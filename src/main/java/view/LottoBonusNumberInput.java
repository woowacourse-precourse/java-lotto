package view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusNumberInput {

	private static final String LOTTO_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	
	public int readLottoBonusNumber() {
		System.out.println(LOTTO_INPUT_BONUS_NUMBER);
		String bonusNumber = Console.readLine();
		System.out.println();
		
		int bonusNumberResult = Integer.parseInt(bonusNumber);
		
		return bonusNumberResult;
	}
}
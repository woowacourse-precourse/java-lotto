package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	
	private static final String BUY_SENTENCE = "구입금액을 입력해 주세요.";
	
	public static int inputMoney() {
		System.out.println(BUY_SENTENCE);
        String money = Console.readLine();
        
        return Integer.parseInt(money);
    }
}

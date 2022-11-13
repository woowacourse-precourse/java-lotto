package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

public class InputView {

	public static String buyInput(){
		System.out.println(Message.BEFORE_BUY.getMessage());
		return Console.readLine();
	}

	public static String answerInput(){
		System.out.println(Message.ANSWER_NUMS.getMessage());
		return Console.readLine();
	}

	public static String bonusInput(){
		System.out.println(Message.BONUS_NUMS.getMessage());
		return Console.readLine();
	}
}

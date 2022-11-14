package util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
	
	public static long inputPurchaseAmount(){
		System.out.println("구입금액을 입력해 주세요.");
		String inputValue = Console.readLine();
		
		if(!ValidateUtil.isNumber(inputValue)) {
			ExceptionUtil.makeException("구입금액은 숫자로 입력해야 합니다.");
		}
		if(!ValidateUtil.isMultipleOf1000(inputValue)) {
			ExceptionUtil.makeException("구입금액은 1000단위로 입력해야 합니다.");
		}
		
		return Integer.parseInt(inputValue);
	}
}

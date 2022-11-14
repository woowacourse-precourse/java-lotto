package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void purchase() throws IllegalArgumentException {
    	System.out.println("구매금액을 입력해 주세요.");
    	String input = Console.readLine();
    	if (!purchaseValidate(input)) {
    		throw new IllegalArgumentException();
    	}
    	System.out.println(input);
    }
    
    private boolean purchaseValidate(String input){
    	if(!checkInputNumeric(input)) {
    		System.out.println("[ERROR] 숫자만 입력해주세요.");
    		return false;
    	} 
    	if(!checkInputRange(input)) {
    		System.out.println("[ERROR] 1,000원 이상 구매 가능합니다.");
    		return false;
    	}
    	if(!checkInputValue(input)) {
    		System.out.println("[ERROR] 1,000원 단위로 입력해주세요.");
    		return false;
    	}
    	return true;
    }
    
    private boolean checkInputNumeric(String input) {
    	return input != null && input.matches("[0-9.]+"); 
    }
    
    private boolean checkInputRange(String input) {
    	return Integer.parseInt(input) >= 1000;
    }
    
    private boolean checkInputValue(String input) {
    	return Integer.parseInt(input) % 1000 == 0; 
    }
}
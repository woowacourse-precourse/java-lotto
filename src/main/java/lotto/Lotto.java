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

    public int purchase() {
    	System.out.println("구매금액을 입력해 주세요.");
    	int purchaseAmount = Integer.parseInt(Console.readLine());
    	purchaseValidate(purchaseAmount);
    	return purchaseAmount;
    }
    
    private void purchaseValidate(int purchaseAmount) throws IllegalArgumentException {
    	if(purchaseAmount % 1000 != 0) {
    		System.out.println("[ERROR] 1,000원 단위로 입력해주세요.");
    		throw new IllegalArgumentException();
    	}
    }
    
}
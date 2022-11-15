package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final String START_MESSAGE = "구매금액을 입력해 주세요.";
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
	
	public void start() {
    	System.out.println(START_MESSAGE);
    	purchase();
    	System.out.println(purchaseLottoAmount() + PURCHASE_MESSAGE);
	}
	
	private String purchase() throws IllegalArgumentException {
    	String input = Console.readLine();
    	if (!purchaseValidate(input)) {
    		throw new IllegalArgumentException();
    	}
    	return input;
    }
    
    private boolean purchaseValidate(String input){
    	if(!checkInputNumeric(input)) {
    		System.out.println(ERROR_MESSAGE + "숫자만 입력해주세요.");
    		return false;
    	} 
    	if(!checkInputRange(input)) {
    		System.out.println(ERROR_MESSAGE + "1,000원 이상 구매 가능합니다.");
    		return false;
    	}
    	if(!checkInputValue(input)) {
    		System.out.println(ERROR_MESSAGE + "1,000원 단위로 입력해주세요.");
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
    
    private int purchaseLottoAmount() {
    	int purchaseHowMuch = Integer.parseInt(purchase());
    	int purchaseHowMany = purchaseHowMuch / 1000;
    	return purchaseHowMany;
    }
    
    public void purchaseLottoNumbers() {
//    	purchaseLottoAmount()
    	
    }
}

package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
	
	static final String PAY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	static final String PAY_CHECK_MESSAGE = "개를 구매했습니다.";
	static final String WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
	static final String ERROR_MESSAGE = "[ERROR]";
	
	static final int MIN_NUMBER = 1;
	static final int MAX_NUMBER = 45;
	static final int LOTTO_SIZE = 6;
	static final int LOTTO_PRICE = 1000;
	static final long[] PRIZE_BY_RANK = {2000000000, 30000000, 1500000, 50000, 5000};
    
	public static void main(String[] args) {
		String input = inputMoney();
		start(input);
		
        
    }
	
	
	// input 
    public static String inputMoney() {
    	System.out.println(PAY_MONEY_MESSAGE);
    	return readLine().replace(" ", "");
    }
    
    
    // exceptions
	public static void start(String input) {
    	if(!purchaseValidate(input)) {
    		throw new IllegalArgumentException();
    	}
    	System.out.println();
	}
    
    private static boolean purchaseValidate(String input){
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
    
    private static boolean checkInputNumeric(String input) {
    	return input != null && input.matches("[0-9.]+"); 
    }
    
    private static boolean checkInputRange(String input) {
    	return Integer.parseInt(input) >= LOTTO_PRICE;
    }
    
    private static boolean checkInputValue(String input) {
    	return Integer.parseInt(input) % LOTTO_PRICE == 0; 
    }
    
    
}

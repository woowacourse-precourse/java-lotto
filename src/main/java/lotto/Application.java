package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
    
	private final static List<Lotto> numbers = new ArrayList<Lotto>();
	
	public static void main(String[] args) {
		String input = inputMoney();
		start(input);
		purchaseRandomNumbers(input);
		printLottoNumbers();
        
    }
	
	
	// input 
	public static String inputMoney() {
    	System.out.println(PAY_MONEY_MESSAGE);
    	return readLine().replace(" ", "");
    }
    
	public static String[] inputWinNumber() {
	   System.out.println(WIN_NUMBER_MESSAGE);
	   return readLine().split(",");
	}
   
	public static String inputBonusNumber() {
	   System.out.println(BONUS_NUMBER_MESSAGE);
	   return readLine().replace(" ", "");	
	}
   
   
   // output   
	public static void outputPurchase(String input) {
		List<Lotto> numbers = printLottoNumbers();
		System.out.println(purchaseLottoAmount(input) + PAY_CHECK_MESSAGE);
		for (Lotto number : numbers) {
			System.out.println(number.getLottoNumbers());
		}
	}
   
	public static void outputLottoNumbers(){
		System.out.println();
	}
   
	public static void outputWinStatistics() {
		System.out.println();
	}
   
	public static void outputWinRate() {
		System.out.printf("총 수익률은 %.1f%%입니다.");
	}
   
   
   // methods
	public static int purchaseLottoAmount(String input) {
		return Integer.parseInt(input) / LOTTO_PRICE;
	}
   
    public static List<Lotto> printLottoNumbers(){
    	return numbers;
    }
    
	private static Lotto purchaseNumbers() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
	}
   
	public static void purchaseRandomNumbers(String input) {
		int purchaseHowMany = purchaseLottoAmount(input);
		for (int i = 0; i < purchaseHowMany; i++) {
			numbers.add(purchaseNumbers());
			}
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

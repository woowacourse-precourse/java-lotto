package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	static final String START_MESSAGE = "구매금액을 입력해 주세요.";
	static final String ERROR_MESSAGE = "[ERROR]";
	static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
	static final String INPUTNUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
	static final int LOTTO_PRICE = 1000;
	static final int START_RANGE = 1;
	static final int END_RANGE = 45;
	static final int LOTTO_SIZE = 6;
	
	private final List<Lotto> numbers = new ArrayList<Lotto>();
	
	public void start(String input) {
    	if(!purchaseValidate(input)) {
    		throw new IllegalArgumentException();
    	}
    	System.out.println();
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
    	return Integer.parseInt(input) >= LOTTO_PRICE;
    }
    
    private boolean checkInputValue(String input) {
    	return Integer.parseInt(input) % LOTTO_PRICE == 0; 
    }
    
    public int purchaseLottoAmount(String input) {
    	return Integer.parseInt(input) / LOTTO_PRICE;
    }
    
    private Lotto purchaseNumbers() {
    	return new Lotto(Randoms.pickUniqueNumbersInRange(Game.START_RANGE, Game.END_RANGE, Game.LOTTO_SIZE));
    }
    
    public void purchaseRandomNumbers(String input) {
    	int purchaseHowMany = purchaseLottoAmount(input);
    	for (int i = 0; i < purchaseHowMany; i++) {
			this.numbers.add(purchaseNumbers());
		}
    }
    
    public List<Lotto> printLottoNumbers(){
    	return numbers;
    }
}

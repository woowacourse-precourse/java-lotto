package lotto;

import java.util.regex.Pattern;

public class LottoCount {
	private int price = 0;
	public int lottocount = 0;
	
	public LottoCount(int price) {
		this.price = price;
		this.lottocount = price / 1000;
		validateNumber(price);
	}
	
	public boolean validateNumber(int price) {
		String pattern = "^[0-9]+$";
		if (Pattern.matches(pattern, String.valueOf(price)) && price >= 1000) {
			return true;
		} 
		throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액만 입력하세요.");
	}
	
	public boolean validateDivideRight() {
		
	}
	
	
}

package lotto;

import java.util.regex.Pattern;

public class LottoCount {
	private int price = 0;
	public int lottonum = 0;
	
	public LottoCount(int price) {
		this.price = price;
		validateNumber(price);
		validateDivideRight(price);
		this.lottonum = price / 1000;
	}
	
	public void validateNumber(int price) {
		String pattern = "^[0-9]{4,}$";
		if (!Pattern.matches(pattern, String.valueOf(price)) || price < 1000) {
			throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액만 입력하세요.");
		} 
	}
	
	public void validateDivideRight(int price) {
		if (price % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 1장당 1000원 입니다.");
		}
	}
}

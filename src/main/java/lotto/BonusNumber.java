package lotto;

import java.util.regex.Pattern;

public class BonusNumber {
	private int bonusnumber = 0;
	public BonusNumber(String stringbonusnumber) {
		validateBonusNumber(stringbonusnumber);
		
		this.bonusnumber = Integer.parseInt(stringbonusnumber);
	}
	
	public void validateBonusNumber(String stringbonusnumber) {
		String pattern = "^[1-45]$";
		if (!Pattern.matches(pattern, stringbonusnumber)) {
			throw new IllegalArgumentException("[ERROR] 1-45사이의 1개의 숫자만 입력하세요.");
		}
	}
	
	public void bonusNoRepeat() {
		
	}
	
	public int getBonusNumber() {
		return this.bonusnumber;
	}
}

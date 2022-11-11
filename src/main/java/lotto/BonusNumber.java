package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class BonusNumber {
	private int bonusnumber = 0;
	public BonusNumber(String stringbonusnumber, List<Integer> inputnumbers) {
		validateBonusNumber(stringbonusnumber);
		bonusNoRepeat(inputnumbers);
		this.bonusnumber = Integer.parseInt(stringbonusnumber);
	}
	
	public void validateBonusNumber(String stringbonusnumber) {
		String pattern = "^[0-9]{1,2}$";
		if (!Pattern.matches(pattern, stringbonusnumber)) {
			throw new IllegalArgumentException("[ERROR] 1-45사이의 1개의 숫자만 입력하세요.");
		}
	}
	
	public void bonusNoRepeat(List<Integer> inputnumbers) {
		HashSet<Integer> inputnumbersset = new HashSet<>();
		inputnumbersset.addAll(inputnumbers);
		inputnumbersset.add(bonusnumber);
		
		if (inputnumbersset.size() != 7) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호가 입력된 당첨 번호 6개와 중복됩니다.");
		}
	}
	
	public int getBonusNumber() {
		return this.bonusnumber;
	}
}

package lotto.domain;

import java.util.List;

public class WinConfirmation {
	protected int correctCount;
	protected static String result;

	public int correctCount(List<Integer> lottoNumbers, List<Integer> userNumbers) {
		for (int index = 0; index < userNumbers.size(); index++) {
			int userNumber = userNumbers.get(index);
			if(lottoNumbers.contains(userNumber)) {
				correctCount++;
			}
		}
		return correctCount;
	}
	
	public boolean correctBonus(int bonusNumber, int userbonus) {
		return bonusNumber == userbonus;
	}
}

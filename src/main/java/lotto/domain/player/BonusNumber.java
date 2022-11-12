package lotto.domain.player;

import lotto.domain.Validator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BonusNumber {
	Validator validator = new Validator();

	private static String bonusNumber;

	public BonusNumber(String bonusNumberInput, List<Integer> winningNumber){	// todo : validation을 위해 winningNumber를 전달받는다. 이 방식이 맞는 것인지 고찰이 필요.
		validator.validateBonusNumber(bonusNumberInput, winningNumber);
		this.bonusNumber = bonusNumberInput;
	}

	public List<Integer> toConvert(){
		return Pattern.compile(",").splitAsStream(bonusNumber)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}

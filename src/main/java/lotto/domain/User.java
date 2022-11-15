package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class User {
	private int[] userNumbers = new int[6];
	private int userBonus;

	private int[] inputNumbers() {
		System.out.println("숫자를 입력해 주세요.");
		String inputNumber = Console.readLine();
		inputNumber = inputNumber.trim();
		String[] inputNumbers = inputNumber.split(",");

		for (int index = 0; index < inputNumbers.length; index++) {
			userNumbers[index] = Integer.parseInt(inputNumbers[index]);
		}
		return userNumbers;
	}

	private int bonusNumber() {
		System.out.println("보너스 숫자를 입력해 주세요.");
		String bonusNumber = Console.readLine();
		userBonus = Integer.parseInt(bonusNumber);
		return userBonus;
	}

	public List<Integer> winningNumber() {
		inputNumbers();
		bonusNumber();
		List<Integer> winningNumbers = new ArrayList(Arrays.asList(userNumbers));
		winningNumbers.add(userBonus);
		return winningNumbers;
	}
}

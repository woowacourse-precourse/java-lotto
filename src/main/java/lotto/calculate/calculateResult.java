package lotto.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class calculateResult {
	public HashMap<String, Integer> calculateResult;
	public calculateResult(ArrayList<List<Integer>> userNumber, ArrayList<Integer>
		winningNumber, int bonusNumber) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (String s : Arrays.asList("three", "four", "five", "bonus", "six")) {result.put(s, 0);}
		for (int i = 0; userNumber.size() > i; i++) {
			if (!userNumber.get(i).contains(bonusNumber)) {userNumber.get(i).retainAll(winningNumber);}
			if (userNumber.get(i).contains(bonusNumber)) {
				userNumber.get(i).retainAll(winningNumber);
				userNumber.get(i).add(bonusNumber);
			}
			rankCheck(userNumber,bonusNumber,result,i);
			this.calculateResult = result;
		}
	}
	public void rankCheck(ArrayList<List<Integer>> userNumber, int bonusNumber, HashMap<String, Integer> result,
		int i) {
		if (userNumber.get(i).size() == 3){result.put("three", result.get("three")+1);}
		if (userNumber.get(i).size() == 4 ){result.put("four", result.get("four")+1);}
		if (userNumber.get(i).size() == 5){result.put("five", result.get("five")+1);}
		if (userNumber.get(i).size() == 6 && userNumber.get(i).contains(bonusNumber)){
			result.put("bonus", result.get("bonus")+1);
		}
		if (userNumber.get(i).size() == 6 && !userNumber.get(i).contains(bonusNumber)){
			result.put("six", result.get("six")+1);
		}
		this.calculateResult = result;
	}
}


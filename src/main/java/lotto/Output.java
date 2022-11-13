package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Output {
	public static void output(int numberOfGame, ArrayList<List<Integer>> userNumber, ArrayList<Integer> winningNumber, int bonusNumber) {
		quantityAndNumberOutput(numberOfGame, userNumber);
		winningResultOutput(userNumber,winningNumber,bonusNumber);

	}
	public static void quantityAndNumberOutput(int numberOfGame, ArrayList<List<Integer>> userNumber) {
		System.out.println(numberOfGame+"개를 구매했습니다.");
		for (int i=0;userNumber.size()>i;i++){
			System.out.println(userNumber.get(i));
		}
	}
	public static void winningResultOutput(ArrayList<List<Integer>> userNumber, ArrayList<Integer> winningNumber, int bonusNumber) {
		calculateResult(userNumber, winningNumber, bonusNumber);
	}

	public static HashMap<String, Integer> calculateResult(ArrayList<List<Integer>> userNumber, ArrayList<Integer> winningNumber, int bonusNumber){
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		result.put("three",0);
		result.put("four",0);
		result.put("five",0);
		result.put("bonus",0);
		result.put("six",0);


		for(int i=0;userNumber.size()>i;i++){

			if (userNumber.get(i).size() == 3){
				result.put("three",result.get("three")+1);
			}
			if (userNumber.get(i).size() == 4  && !userNumber.get(i).contains(bonusNumber)){
				result.put("four",result.get("four")+1);
			}
			if (userNumber.get(i).size() == 5){
				System.out.println(userNumber.get(i)+"가"+bonusNumber+"를포함하는가");
				System.out.println(userNumber.get(i).contains(bonusNumber));
				result.put("five",result.get("five")+1);
			}
			if (userNumber.get(i).size() == 5 && userNumber.get(i).contains(bonusNumber)){
				result.put("bonus",result.get("bonus")+1);
			}
			if (userNumber.get(i).size() == 6){
				result.put("six",result.get("six")+1);
			}
		}
		System.out.println(result);
		return result;
	}
}

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
		HashMap<String,Integer> result = calculateResult(userNumber, winningNumber, bonusNumber);
		System.out.println("3개 일치 (5,000원) - "+result.get("three")+"개");
		System.out.println("4개 일치 (50,000원) - "+result.get("four")+"개");
		System.out.println("5개 일치 (1,500,000원) - "+result.get("five")+"개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result.get("bonus")+"개");
		System.out.println("6개 일치 (2,000,000,000원) - "+result.get("six")+"개");
		System.out.println("총 수익률은 "+profitabilityOutput(result,userNumber)+"%입니다.");
	}



	public static HashMap<String, Integer> calculateResult(ArrayList<List<Integer>> userNumber, ArrayList<Integer> winningNumber, int bonusNumber){
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		result.put("three",0);
		result.put("four",0);
		result.put("five",0);
		result.put("bonus",0);
		result.put("six",0);


		for(int i=0;userNumber.size()>i;i++){

			if (!userNumber.get(i).contains(bonusNumber)) {
				userNumber.get(i).retainAll(winningNumber);
			}
			if (userNumber.get(i).contains(bonusNumber)) {
				userNumber.get(i).retainAll(winningNumber);
				userNumber.get(i).add(bonusNumber);
			}

			if (userNumber.get(i).size() == 3){
				result.put("three",result.get("three")+1);
			}
			if (userNumber.get(i).size() == 4  && !userNumber.get(i).contains(bonusNumber)){
				result.put("four",result.get("four")+1);
			}
			if (userNumber.get(i).size() == 5){
				result.put("five",result.get("five")+1);
			}
			if (userNumber.get(i).size() == 6 && userNumber.get(i).contains(bonusNumber)){
				result.put("bonus",result.get("bonus")+1);
			}
			if (userNumber.get(i).size() == 6 && !userNumber.get(i).contains(bonusNumber)){
				result.put("six",result.get("six")+1);
			}
		}
		return result;
	}

	public static double profitabilityOutput(HashMap<String, Integer>result,ArrayList<List<Integer>> userNumber){
		double purchasePrice = userNumber.size() * 1000;
		double prize = (result.get("three")*5000) + (result.get("four")*50000) + (result.get("five")*1500000) +
			(result.get("bonus")*30000000) + (result.get("six")*2000000000);
		return (double)Math.round((prize*10/purchasePrice)*10);
	}
}

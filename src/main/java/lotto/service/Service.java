package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.VO.LottoVO;
import lotto.constants.Constants;
import lotto.exception.Lotto;

public class Service {	
	
	public void setInputPrice(Constants constants, LottoVO lotto) {		
		System.out.println(constants.getBuyPrice());
		String price = Console.readLine();
		lotto.setPrice(price);		
	}

	public void setInputNumbers(Constants constants, LottoVO lottoVO) {
		int each = Integer.parseInt(lottoVO.getPrice()) / constants.getLottoPrice();
		System.out.println(each + constants.getBuyEach());
		lottoVO.setEach(each);		
	}

	public void setBuyLotto(LottoVO lottoVO) {		
		for (int i = 0; i < lottoVO.getEach(); i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);			
			Lotto lotto = new Lotto(numbers); // 예외처리
			Collections.sort(numbers);
			// 오름차순 정렬 삽입구간
			lottoVO.lotto.add(numbers);
		}		
		System.out.println(lottoVO.getLotto());		
	}

	public void setGoalNumbers(LottoVO lotto, Constants constants) {
		System.out.println(constants.getInputGoalNumbers());
		String goalNumbers = Console.readLine();
		goalNumbers.replace(",", "");
		String match = "[^\uAC00-\uD7A30-9a-zA-Z\\s]";
		goalNumbers = goalNumbers.replaceAll(match, "");
		lotto.setGoalNumbers(goalNumbers);		
	}
	
	public void setBonusGoalNumbers(Constants constants, LottoVO lotto) {
		System.out.println(constants.getInputBonusNumbers());
		String bonusNumbers = Console.readLine();		
		lotto.setBonusNumbers(bonusNumbers);
		System.out.println(lotto.getGoalNumbers()+"/"+lotto.getBonusNumbers());
		String number = lotto.getGoalNumbers();
		String bonusNumber = lotto.getBonusNumbers();
		for(char x : number.toCharArray()) {
			System.out.println(x);
		}
	}
	
	public void setGoalStatics(LottoVO lotto) {
		List<List<Integer>> target = lotto.getLotto();
		String number = lotto.getGoalNumbers();
		String bonusNumber = lotto.getBonusNumbers();	
		for(int i=0; i<target.size(); i++) {
			for(int j=0; j<target.size(); j++) {
				
			}
		}
	}
	
	public void searchString(LottoVO lotto) {
		String number = lotto.getGoalNumbers();
		String bonusNumber = lotto.getBonusNumbers();			
		int count = 0;
		for(int i=0; i<lotto.getLotto().size(); i++) {
			for(int j=0; j<lotto.getLotto().size(); j++) {
				String a = lotto.getLotto().get(i).get(j).toString();
				for(int k=0; k<number.length(); k++) {
					if(a.equals(number.indexOf(k)==1)) {
						count++;
					}
				}
				
			}
		}
		System.out.println("당첨횟수"+count);
	}
}

package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Answer {
	private Set<Integer> numbers;
	private int bonus;
	
	public void setNumbers(String rawNumbers) {
		Set<Integer> numbers = processRawNumbers(rawNumbers);
		setNumbers(numbers);
	}
	
	public void setNumbers(Set<Integer> numbers) {
		numbersValidate(numbers);
		this.numbers = numbers;
	}
	
	
	public void setBonus(String rawBonus) {
		int bonus = changeStringToInt(rawBonus);
		setBonus(bonus);
	}
	
	public void setBonus(int bonus) {
		bonusValidate(bonus);
		this.bonus = bonus;
	}

	public void evaluate(User user) {
		List<Lotto> userLottos = user.getLottos();
		Map<Rank, Integer> rankCount = user.getRankCount();
		
		for(Lotto userLotto : userLottos) {
			Rank lottoRank = getRank(userLotto);
			rankCount.put(lottoRank, rankCount.get(lottoRank) + 1);
			user.addProfitMoney(lottoRank);
		}
	}
	
	private Set<Integer> processRawNumbers(String rawNumbers) {
		Set<Integer> numbers = new HashSet<>();
		
		for(String rawNumber : rawNumbers.split(",")) {
			numbers.add(changeStringToInt(rawNumber));
		}
		return numbers;
	}
	
	private void numbersValidate(Set<Integer> numbers) {
		if(numbers.size()!=6) {
			throw new IllegalArgumentException("당첨 번호가 올바르지 않습니다.");
		}
		for(int number : numbers) {
			if(number<1 || number>45) {
				throw new IllegalArgumentException("당첨 번호 범위가 올바르지 않습니다.");
			}
		}
	}
	
	private void bonusValidate(int bonus) {
		if(numbers.contains(bonus)) {
			throw new IllegalArgumentException("보너스 번호가 올바르지 않습니다.");
		}
		if(bonus<1 || bonus>45) {
			throw new IllegalArgumentException("보너스 번호 범위가 올바르지 않습니다.");
		}
	}
	
	private int changeStringToInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 int 포멧에 어긋납니다.");
		}
	}
	
	private Rank getRank(Lotto lotto) {
		List<Integer> numbers = lotto.getNumbers();
		
		int count = getCorrectCount(numbers);
		if(count==6) {
			return Rank.FIRST;
		}
		if(count==5) {
			if(numbers.contains(bonus)) {
				return Rank.SECOND;
			}
			return Rank.THIRD;
		}
		if(count==4) {
			return Rank.FOURTH;
		}
		if(count==3) {
			return Rank.FIFTH;
		}
		return Rank.ELSE;
	}
	
	private int getCorrectCount(List<Integer> lotto) {
		int count = 0;
		for(int number : lotto) {
			if(numbers.contains(number)) {
				count++;
			}
		}
		return count;
	}
}

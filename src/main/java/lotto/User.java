package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class User {
	private int purchaseMoney;
	private int profitMoney;
	private List<Lotto> lottos;
	private Map<Rank, Integer> rankCount;
	
	public User() {
		purchaseMoney = 0;
		profitMoney = 0;
		lottos = new ArrayList<>();
		rankCount = new HashMap<>();
		rankCount.put(Rank.FIRST, 0);
		rankCount.put(Rank.SECOND, 0);
		rankCount.put(Rank.THIRD, 0);
		rankCount.put(Rank.FOURTH, 0);
		rankCount.put(Rank.FIFTH, 0);
		rankCount.put(Rank.ELSE, 0);
	}
	
	public List<Lotto> getLottos() {
		return lottos;
	}
	
	public Map<Rank, Integer> getRankCount() {
		return rankCount;
	}
	
	public int getPurchaseCount(String rawCost) {
		int cost = changeStringToInt(rawCost);
		
		return getPurchaseCount(cost);
	}
	
	public int getPurchaseCount(int cost) {
		costValidate(cost);
		
		addPurchaseMoney(cost);
		
		int count = cost/1000;
		System.out.printf("%s개를 구매했습니다.\n", count);
		
		return count;
	}

	public void addLotto() {
		Lotto lotto = makeLotto();
		System.out.println(lotto.getNumbers());
		lottos.add(lotto);
	}
	
	public String getProfitRate() {
		double profitRate = (double)profitMoney/purchaseMoney;
		
		return String.format("%.1f", profitRate*100);
	}
	
	public void addProfitMoney(Rank lottoRank) {
		profitMoney += lottoRank.getPrize();
	}
	
	
	
	private Lotto makeLotto() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
	}
	
	private void addPurchaseMoney(int cost) {
		purchaseMoney += cost;
	}
	
	private void costValidate(int cost) {
		if(cost%1000 != 0) {
			throw new IllegalArgumentException("금액은 1000원 단위로 입력해야 합니다.");
		}
		if(cost<0) {
			throw new IllegalArgumentException("금액은 음수로 입력할 수 없습니다.");
		}
		if(cost==0) {
			throw new IllegalArgumentException("반드시 로또는 1개 이상 구매해야 합니다.");
		}
	}

	private int changeStringToInt(String str) {
		try {
			return Integer.parseInt(str);
		}catch(NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 int 포멧에 어긋납니다.");
		}
	}
	
}

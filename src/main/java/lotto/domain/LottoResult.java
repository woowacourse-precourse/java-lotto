package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
	private final List<List<Integer>> lottoTickets;
	private final List<Integer> winningNumber;
	private final int bonusNumber;
	private final HashMap<String, Integer> prize = new HashMap<>();

	public LottoResult(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
		this.lottoTickets = lottoTickets;
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public HashMap<String, Integer> countWin() {
		for (List<Integer> lottoTicket : lottoTickets) {
			int count = 0;
			for (Integer i : lottoTicket) {
				if (winningNumber.contains(i)) {
					count++;
				}
			}
			if (count == 6) {
				prize.put("firstPrize", prize.getOrDefault("firstPrize", 0) + 1);
			}
			if (count == 5 && lottoTicket.contains(bonusNumber)) {
				prize.put("secondPrize", prize.getOrDefault("secondPrize", 0) + 1);
			}
			if (count == 5 && !lottoTicket.contains(bonusNumber)){
				prize.put("thirdPrize", prize.getOrDefault("thirdPrize", 0) + 1);
			}
			if (count == 4){
				prize.put("fourthPrize", prize.getOrDefault("fourthPrize", 0) + 1);
			}
			if (count == 3) {
				prize.put("fifthPrize", prize.getOrDefault("fifthPrize", 0) + 1);
			}
		}
		return prize;
	}
}

package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoResult {
	private final List<List<Integer>> lottoTickets;
	private final List<Integer> winningNumber;
	private final int bonusNumber;

	public LottoResult(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
		this.lottoTickets = lottoTickets;
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}

	public HashMap<String, Integer> countWin() {
		HashMap<String, Integer> prize = new HashMap<>() {{
			put("firstPrize" ,0);
			put("secondPrize" ,0);
			put("thirdPrize" ,0);
			put("fourthPrize" ,0);
			put("fifthPrize" ,0);
		}};

		for (List<Integer> lottoTicket : lottoTickets) {
			int count = 0;
			for (Integer i : lottoTicket) {
				if (winningNumber.contains(i)) {
					count++;
				}
			}
			if (count == 6) {
				prize.put("firstPrize", prize.get("firstPrize") + 1);
			}
			if (count == 5 && lottoTicket.contains(bonusNumber)) {
				prize.put("secondPrize", prize.get("secondPrize") + 1);
			}
			if (count == 5 && !lottoTicket.contains(bonusNumber)){
				prize.put("thirdPrize", prize.get("thirdPrize") + 1);
			}
			if (count == 4){
				prize.put("fourthPrize", prize.get("fourthPrize") + 1);
			}
			if (count == 3) {
				prize.put("fifthPrize", prize.get("fifthPrize") + 1);
			}
		}
		return prize;
	}
}

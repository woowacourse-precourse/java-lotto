package lotto.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoGameResult;
import lotto.domain.Rank;
import lotto.number.LottoWinningNumbers;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets;

	public LottoTickets(final List<LottoTicket> lottoTickets) {
		this.lottoTickets = new ArrayList<>(lottoTickets);
	}

	public List<String> getLottoTickets() {
		List<String> ticketsList = new ArrayList<>();
		for (LottoTicket lottoTicket : lottoTickets) {
			ticketsList.add(lottoTicket.getLottoNumbers().toString());
		}
		return ticketsList;
	}

	public LottoGameResult getMatchingResult(final LottoWinningNumbers lottoWinningNumbers,
			final Map<Rank, Integer> matchingResults) {
		for (LottoTicket lottoTicket : this.lottoTickets) {
			Rank rank = getRank(lottoWinningNumbers, lottoTicket);
			matchingResults.put(rank, matchingResults.get(rank) + 1);
		}
		return new LottoGameResult(matchingResults);
	}

	private Rank getRank(LottoWinningNumbers lottoWinningNumbers, LottoTicket lottoTicket) {
		int matchCount = lottoWinningNumbers.countMatchedWinningNumber(lottoTicket);
		boolean isBonusMatch = lottoWinningNumbers.isMatchBonusNumber(lottoTicket);
		return Rank.of(matchCount, isBonusMatch);
	}

}

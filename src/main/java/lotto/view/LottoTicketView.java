package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import org.mockito.internal.util.StringUtil;

public class LottoTicketView {
	public static void getLottoTicketView(Long numberOfPurchases, List<Lotto> ticket) {
		System.out.println();
		getNumberOfPurchasesView(numberOfPurchases);
		getLottoTicketView(ticket);
		System.out.println();
	}

	private static void getNumberOfPurchasesView(Long numberOfPurchases) {
		String purchase = String.format("%d개를 구매했습니다.", numberOfPurchases);
		System.out.print(purchase);
	}

	private static void getLottoTicketView(List<Lotto> ticket) {
		ticket.stream()
			.forEach(lotto -> getLottoView(lotto));
	}

	private static void getLottoView(Lotto lotto) {
		List<String> lottoNumbers = toList(lotto.getNumbers());
		String joinedLottoNumbers = StringUtil.join(lottoNumbers);
		System.out.print(joinedLottoNumbers);
	}

	private static List<String> toList(List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
			.map(number -> Integer.toString(number))
			.collect(Collectors.toList());
	}
}

package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoReceipt;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class LottoReceiptTest extends NsTest {

	@DisplayName("compareTickets는 각 로또들의 번호와 당첨 번호를 비교 하여 등수를 저장한다")
	@Test
	void compareTicketst() {

		LottoReceipt lottoReceipt = getLottoReceipt();
		lottoReceipt.printResult();
		assertThat(output()).contains("6개 일치 (2,000,000,000원) - 1개");
	}

	@DisplayName("calculateRevenue는 수익률을 계산한다")
	@Test
	void calculateRevenue() {
		LottoReceipt lottoReceipt = getLottoReceipt();
		lottoReceipt.calculateRevenue();
		Money money = new Money(1000);
		lottoReceipt.printYield(money);
		assertThat(output()).contains("200000000.0%");
	}

	private LottoReceipt getLottoReceipt() {
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(lotto);
		LottoTickets lottoTickets = new LottoTickets(lottos);
		WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

		return new LottoReceipt(lottoTickets, winningNumbers);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

}

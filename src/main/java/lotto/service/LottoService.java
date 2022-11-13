package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.dto.LottoTicketDTO;

public class LottoService {
    private static final Integer LOTTO_PRICE = 1000;
    private final LottoPurchase lottery;

    public LottoService() {
	this.lottery = new LottoPurchase();
    }

    public LottoTicketDTO purchaseLottoByPaidAmount(Integer paidAmount) {
	List<Lotto> lottoTicket = LottoNumberGenerator.createManyLotto(paidAmount / LOTTO_PRICE);
	lottery.purchaseLottery(lottoTicket);

	LottoTicketDTO lottoTicketDTO = new LottoTicketDTO(lottery.getLottery().stream()
	    .map(Lotto -> Lotto.getLottoNumbers()).collect(Collectors.toList()));
	return lottoTicketDTO;
    }
}

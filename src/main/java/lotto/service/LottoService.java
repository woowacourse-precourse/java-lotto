package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.dto.LottoTicketDTO;

public class LottoService {
    private static final Integer LOTTO_PRICE = 1000;
    public static LottoTicketDTO issueLottoByPaidAmount(Integer paidAmount) {
	List<Lotto> Lottery = LottoNumberGenerator.createManyLotto(paidAmount / LOTTO_PRICE);
	LottoTicketDTO lottoTicketDTO = new LottoTicketDTO(Lottery.stream()
	    .map(Lotto -> Lotto.getLottoNumbers()).collect(Collectors.toList()));
	return lottoTicketDTO;
    }
}

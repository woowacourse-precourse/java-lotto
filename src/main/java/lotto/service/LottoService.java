package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningLotto;
import lotto.dto.LottoTicketDTO;

public class LottoService {
    private static final Integer LOTTO_PRICE = 1000;
    private static LottoPurchase lottery;
    private static WinningLotto winningLotto;

    public LottoTicketDTO purchaseLottoByPaidAmount(Integer paidAmount) {
	List<Lotto> lottoTicket = LottoNumberGenerator.createManyLotto(paidAmount / LOTTO_PRICE);
	lottery = new LottoPurchase(lottoTicket);

	LottoTicketDTO lottoTicketDTO = new LottoTicketDTO(lottery.getLottery().stream()
	    .map(Lotto -> Lotto.getLottoNumbers()).collect(Collectors.toList()));
	return lottoTicketDTO;
    }

    public void announceWinningLottoNumber(List<Integer> winningLottoNumber, Integer bonusLottoNumber) {
	winningLotto = new WinningLotto(winningLottoNumber, bonusLottoNumber);
    }
}

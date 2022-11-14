package lotto.application.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.port.in.LottoServiceUseCase;
import lotto.application.port.in.RequestBuyLottoDto;
import lotto.application.port.in.ResponseBuyLottoDto;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoService implements LottoServiceUseCase {

    @Override
    public ResponseBuyLottoDto buyLotto(RequestBuyLottoDto requestBuyLottoDto) {
        List<Lotto> lottos = new ArrayList<>();
        Money money = new Money(requestBuyLottoDto.convertToInteger());
        int lottoCount = money.exchangeLotto();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }
        return new ResponseBuyLottoDto(lottos);
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
package lotto.application.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.application.port.in.*;
import lotto.application.port.in.dto.RequestBuyLottoDto;
import lotto.application.port.in.dto.RequestMatchDto;
import lotto.application.port.in.dto.ResponseBuyLottoDto;
import lotto.application.port.in.dto.ResponseMatchDto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.ResultTable;

import java.util.ArrayList;
import java.util.List;

public class LottoService implements LottoServiceUseCase {

    @Override
    public ResponseMatchDto matchWinningNumber(RequestMatchDto requestMatchDto) {
        //비교하여 Result 객체로 리턴.
    }

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

    private ResultTable compareLottoNumbers() {

    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
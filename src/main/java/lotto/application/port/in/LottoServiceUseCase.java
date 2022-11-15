package lotto.application.port.in;

import lotto.application.port.in.dto.RequestBuyLottoDto;
import lotto.application.port.in.dto.RequestMatchDto;
import lotto.application.port.in.dto.ResponseBuyLottoDto;
import lotto.application.port.in.dto.ResponseMatchDto;

public interface LottoServiceUseCase {
    ResponseBuyLottoDto buyLotto(RequestBuyLottoDto requestBuyLottoDto);
    ResponseMatchDto matchWinningNumber(RequestMatchDto requestMatchDto);
}

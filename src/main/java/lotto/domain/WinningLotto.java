package lotto.domain;

import lotto.dto.ResponseRankAggregationDto;
import lotto.service.LottoRankAggregation;
import lotto.view.InputView;

public class WinningLotto {

    private LottoRankAggregation lottoRankAggregation;

    public WinningLotto(LottoRankAggregation lottoRankAggregation) {
        this.lottoRankAggregation = lottoRankAggregation;
    }

    public ResponseRankAggregationDto compareTo(Customer customer) {
        return lottoRankAggregation.aggregation(customer, InputView.readWinningLotto(), InputView.readBonusNumber());
    }
}

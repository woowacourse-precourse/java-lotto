package lotto.mvc.dto.output;

import lotto.mvc.model.LottoResult;

public final class OutputLottoStatisticsDto {

    private final String lottoStatistics;

    public OutputLottoStatisticsDto(final LottoResult lottoResult) {
        this.lottoStatistics = lottoResult.toString();
    }

    public String getLottoStatistics() {
        return lottoStatistics;
    }
}

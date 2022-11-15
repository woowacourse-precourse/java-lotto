package lotto.data.dto;

import java.util.HashMap;
import lotto.type.LottoResultType;

public class LottoQueryResponseDto {

    private final HashMap<LottoResultType, Integer> lottoResults;

    public LottoQueryResponseDto(HashMap<LottoResultType, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public HashMap<LottoResultType, Integer> getLottoResults() {
        return lottoResults;
    }
}

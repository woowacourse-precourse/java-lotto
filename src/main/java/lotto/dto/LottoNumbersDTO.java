package lotto.dto;

import java.util.List;

public class LottoNumbersDTO {
    private final List<Integer> lottoNumbers;

    public LottoNumbersDTO(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

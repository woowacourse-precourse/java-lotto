package lotto;

import java.util.List;

public class Model {
    private List<int[]> lottoNumbers;

    public Model(List<int[]> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<int[]> getLottoNumbers() {
        return lottoNumbers;
    }
}

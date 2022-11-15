package lotto.domain;

import java.util.List;

public class UserLotto {
    private List<Integer> lottoNumbers;

    public UserLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }


}

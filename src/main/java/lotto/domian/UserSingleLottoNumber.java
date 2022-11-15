package lotto.domian;
import java.util.List;

public class UserSingleLottoNumber {
    private final List<Integer> lottoNumbers;
    public UserSingleLottoNumber(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

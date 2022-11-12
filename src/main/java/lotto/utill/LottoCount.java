package lotto.utill;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCount {
    private MakeLottoNumber makeLottoNumber;

    public LottoCount(MakeLottoNumber makeLottoNumber) {
        this.makeLottoNumber = makeLottoNumber;
    }

    public List<Lotto> createLottos(String purchaseLotto) {
        int lottoCount = Integer.parseInt(purchaseLotto) / 1000;

        return IntStream.rangeClosed(1, lottoCount)
                .mapToObj(x -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto() {
        List<Integer> numbers = makeLottoNumber.makeLottoNumbers();

        return new Lotto(numbers);
    }
}

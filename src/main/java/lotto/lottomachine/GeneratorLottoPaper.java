package lotto.lottomachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.lottopaper.LottoPaper;
import lotto.view.OutputView;

public class GeneratorLottoPaper {
    private static final int ZERO = 0;
    public static LottoPaper generateLottoPaper(int lottoPrice) {
        int lottoCount = lottoPrice / LottoEnum.PRICE.getValue();
        OutputView.showLottoCount(lottoCount);
        return insertLottoIntoLottoPaper(lottoCount);
    }

    private static LottoPaper insertLottoIntoLottoPaper(int lottoCount) {
        LottoPaper lottoPaper = new LottoPaper();
        while (lottoCount != ZERO) {
            lottoPaper.addLotto(generateLotto());
            lottoCount--;
        }
        return lottoPaper;
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        OutputView.showGeneratedLotto(lottoNumbers);
        return lotto;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(
            LottoEnum.MIN_NUMBER.getValue(),
            LottoEnum.MAX_NUMBER.getValue(),
            LottoEnum.LENGTH.getValue());
        return lottoNumber.stream().sorted().collect(Collectors.toList());
    }
}

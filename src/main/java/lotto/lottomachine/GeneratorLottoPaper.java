package lotto.lottomachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.GameMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.lottopaper.LottoPaper;

public class GeneratorLottoPaper {
    public static LottoPaper generateLottoPaper(int lottoPrice) {
        int lottoCount = lottoPrice / LottoEnum.PRICE.getValue();
        showLottoCount(lottoCount);

        LottoPaper lottoPaper = new LottoPaper();

        while (lottoCount != 0) {
            lottoPaper.addLotto(generateLotto());
            lottoCount--;
        }

        return lottoPaper;
    }

    private static void showLottoCount(int lottoCount) {
        System.out.println(String.valueOf(lottoCount) + GameMessage.RESULT_RANK_UNITS + GameMessage.BUY_RESULT);
    }

    private static Lotto generateLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        System.out.println(lottoNumbers);
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

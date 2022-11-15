package lotto.lotto;

import static lotto.constant.Rules.END_INCLUSIVE;
import static lotto.constant.Rules.NUMBER_LENGTH;
import static lotto.constant.Rules.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return lottos;
    }

    private static Lotto generate() {
        List<LottoNumber> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,
                        END_INCLUSIVE, NUMBER_LENGTH).stream().sorted().map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}

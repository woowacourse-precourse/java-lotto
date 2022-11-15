package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMake {

    private List<Lotto> lottoPapers;

    public LottoMake(int lottoCount) {
        lottoPapers = makeLottoPapers(lottoCount);
    }

    private List<Lotto> makeLottoPapers(int lottoCount) {
        List<Lotto> lottoPapers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lottoPaper = new Lotto(makeLottoNumbers());
            lottoPapers.add(lottoPaper);
        }

        return lottoPapers;
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> lottoPaper = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream().sorted().collect(Collectors.toList());

        return lottoPaper;
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }
}

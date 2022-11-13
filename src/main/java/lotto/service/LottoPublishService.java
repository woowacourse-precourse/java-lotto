package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.domain.lotto.repository.Lotto;

public class LottoPublishService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();

    private LottoPublishService() {
    }

    private static class InnerLottoPublishService {
        private static final LottoPublishService instance = new LottoPublishService();
    }

    public static LottoPublishService getInstance() {
        return InnerLottoPublishService.instance;
    }

    public void createLottoNumber () {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumberInclusive.START.getValue(),
                LottoNumberInclusive.END.getValue(),
                LottoRule.LOTTO_MAX_COUNT.getValue());
        publishedLottoNumbers.add(new Lotto(numbers));
    }

    public List<Lotto> getPublishedLottoNumbers() {
        return publishedLottoNumbers;
    }
}

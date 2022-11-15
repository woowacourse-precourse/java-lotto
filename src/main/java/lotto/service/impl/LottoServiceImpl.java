package lotto.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistic;
import lotto.service.LottoService;
import lotto.type.ErrorCode;
import lotto.type.LottoInformation;
import lotto.type.LottoStandard;

public class LottoServiceImpl implements LottoService {

    @Override
    public List<Lotto> createLottos(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ErrorCode.MINIMUM_SIZE_CREATE_ERROR.getMessage());
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(createLotto());
        }
        return result;
    }

    @Override
    public LottoStatistic makeStatistic(final List<Lotto> lottos, final long purchaseAmount,
        final List<Integer> winningNumbers, final int bonusNumber) {
        LottoStatistic statistic = new LottoStatistic();
        long totalPrize = 0L;
        for (Lotto lotto : lottos) {
            LottoStandard lottoStandard = LottoStandard.judge(lotto, winningNumbers, bonusNumber);
            statistic.addLottoStandard(lottoStandard);
            totalPrize += lottoStandard.getPrize();
        }
        statistic.calculateYield(purchaseAmount, totalPrize);
        return statistic;
    }


    private Lotto createLotto() {
        List<Integer> makeNumbers = Randoms.pickUniqueNumbersInRange(LottoInformation.START.value(),
            LottoInformation.END.value(), LottoInformation.SIZE.value());
        ArrayList<Integer> numbers = new ArrayList<>(makeNumbers);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
}

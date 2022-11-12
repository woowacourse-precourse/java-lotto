package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.constants.LottoConstants;

public class LottoRandom {
    private List<Integer> lottoNumbers;

    public List<Integer> pickNumbers() {
        lottoNumbers = pickUniqueNumbers();
        return sortLottoNumbers();
    }

    public List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN,
                LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_TICKET_SIZE);
    }

    public List<Integer> sortLottoNumbers() {
        return lottoNumbers.stream().sorted().collect(Collectors.toList());
    }
}

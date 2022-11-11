package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Exceptions;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public List<Integer> createRandomNumbers(String numbers) {
        lottoNumbers = new ArrayList<>();
        if (!Exceptions.validLottoNumbers(numbers)) {
            throw new IllegalArgumentException("입력 오류");
        }
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

}

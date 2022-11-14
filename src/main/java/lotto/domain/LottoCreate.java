package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoCreate {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public List<Integer> createLottoNum() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLottoNumbers(lottoNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }



}

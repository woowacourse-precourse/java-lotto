package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CoreProcess {

    ProcessData bring = new ProcessData();

    public List<Integer> setLottoNumber() {
        List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return LottoNumber;
    }

    public int compareNumber(List<Integer> Lotto, List<Integer> pickedNumber) {
        List<Integer> overlapList = Lotto.stream()
                .filter(old -> pickedNumber.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
        return overlapList.size();
    }

}


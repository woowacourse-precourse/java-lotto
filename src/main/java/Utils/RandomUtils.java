package Utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtils {
//    - 당첨 번호 및 보너스 번호의 중복성 체크
//    - 1~45까지 랜덤 숫자 생성

    public static List<Integer> getRandomLottoNumber() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    public static boolean isUniqueNumber(List<Integer> input) {
        Set<Integer> inputWithoutDuplicate = new HashSet<>(input);
        return input.size() == inputWithoutDuplicate.size();
    }

    public static boolean isUniqueBonusNumber(int BonusNumber, List<Integer> lotto) {
        return !lotto.contains(BonusNumber);
    }
}

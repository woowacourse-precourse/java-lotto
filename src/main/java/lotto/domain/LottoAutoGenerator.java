package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator {
    public static List<Lotto> generateBunchOfLottos(int money) {
        List<Lotto> bunchOfLottos = new ArrayList<>();
        int amountOfLotto = money / LottoRule.COST.getValue();
        int countOfLotto = 0;

        //난수 생성 라이브러리에서 오류가 생긴 경우에는 생성한 에러 문구를 출력하고 그 배열을 제외하되 종료시키지는 않는다.
        while (countOfLotto < amountOfLotto) {
            try {
                bunchOfLottos.add(generateLotto());
                countOfLotto++;
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }

        return bunchOfLottos;
    }

    public static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoRule.MINIMUM_NUMBER.getValue(),
                LottoRule.MAXIMUM_NUMBER.getValue(),
                LottoRule.AMOUNT_OF_NUMBER.getValue()
        ));

        Collections.sort(numbers);

        return Lotto.from(numbers);
    }
}

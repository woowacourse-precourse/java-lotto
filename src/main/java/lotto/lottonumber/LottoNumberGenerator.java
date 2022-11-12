package lotto.lottonumber;

import java.util.ArrayList;
import java.util.List;

import static lotto.randomnumber.RandomGenerator.generateRandomNumbers;

/**
 * 여러 장수를 가지는 로또들을 생성하는 클래스입니다.
 */
public class LottoNumberGenerator {

    /**
     * 여러 장의 로또를 생성하는 클래스입니다.
     * @param number 몇 장의 로또를 생성할 것인지
     * @return 생성된 로또들을 가지는 리스트
     */
    public static List<LottoNumber> generateLotto(int number) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoNumbers.add(new LottoNumber(generateRandomNumbers()));
        }
        return lottoNumbers;
    }
}

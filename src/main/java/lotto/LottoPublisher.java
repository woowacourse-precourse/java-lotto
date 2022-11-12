package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 로또 발행을 담당하는 클래스
 */
public class LottoPublisher {

    public static List<Lotto> publishLottos(int money){
        validateMultipleOfLottoCost(money);

        int lottoCount = money / Lotto.LOTTO_COST;
        return new ArrayList<>(Stream.generate(() -> publishLotto()).limit(lottoCount).collect(Collectors.toList()));
    }
    public static Lotto publishLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    private static void validateMultipleOfLottoCost(int money){
        if(money % Lotto.LOTTO_COST != 0 || money / Lotto.LOTTO_COST == 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 " + Lotto.LOTTO_COST +"의 배수여야 합니다");
        }
    }
}

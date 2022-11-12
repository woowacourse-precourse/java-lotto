package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

/**
 * 보너스 번호가 해당 되는 로또 찾기 구현
 */
public class BonusBallUsedLottery {

    public List<Integer> getLocations(Lotto lottoAnswer, List<List<Integer>> random,
            List<Integer> resultNumber, int bonus) {
        List<Integer> result = new ArrayList<>();
        List<Integer> numbers = lottoAnswer.getNumbers();

        for (int i = 0; i < resultNumber.size(); i++) {
            int cont = 0;
            int checkIndex = 0;

            if (resultNumber.get(i) == 5) { // 5개까지 맞는 티켓인가 확인

                // 여기까지 온 상태면 로또 맞은 갯수가 5개라는 것이다.
                for (List<Integer> randomNumber : random) {

                    // i번째애랑 비교를 해야된다 나머지는 없어도 된다.
                    for (int lotto : numbers) { // 1,2,3,4,5,6
                        if (randomNumber.contains(lotto)) { // 5,6,7,8,9 == 1
                            checkIndex++;
                        }
                    }

                    if (checkIndex == 5 && randomNumber.contains(bonus)) {
                        cont++; // 있다면 카운트
                        break;
                    }
                    checkIndex = 0;
                }
            }
            result.add(cont);
        }

        return result;
    }

}

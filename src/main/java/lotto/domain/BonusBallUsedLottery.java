package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 보너스 번호가 해당 되는 로또 찾기 구현
 */
public class BonusBallUsedLottery {
    public List<Integer> getLocations(List<List<Integer>> random, List<Integer> resultNumber, int bonus) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < resultNumber.size(); i++) {
            int cont = 0;

            if (resultNumber.get(i) == 5) { // 5개까지 맞는 티켓인가 확인

                // 여기까지 온 상태면 로또 맞은 갯수가 5개라는 것이다.
                for (List<Integer> randomNumber : random) {
                    if (randomNumber.contains(bonus)) { // 보너스랑 같은 숫자가 있는지 확인다.
                        cont++; // 있다면 카운트
                        break;
                    }
                }
            }
            result.add(cont);
        }

        return result;
    }

}

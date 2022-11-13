package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Model {
    /**
     * 1에서 45까지 서로 다른 임의의 수 6개의 로또 숫자를 생성한다.
     * @return 로또 숫자를 ArrayList로 return 한다.
     */
    private static ArrayList<Integer> CreateLottoNumber() {
        ArrayList<Integer> lottoNumber = new ArrayList<>();

        // 1에서 45까지 서로 다른 임의의 수 6개를 생성한다.
        while (lottoNumber.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }

        return lottoNumber;
    }

}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static int MONEY;

    public RandomLotto(int money) {
        this.MONEY = money;
    }

    public List<List<Integer>> getLottos () {
        return repeatGettingLottoNumber();
    }

    // 1~45 사이의 랜덤 숫자들로 로또 번호 6개를 만드는 메서드
    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    // 로또 번호 만드는 메서드를 입력한 돈의 크기 만큼 반복하는 메서드
    public List<List<Integer>> repeatGettingLottoNumber() {
        List<List<Integer>> usersLottos = new ArrayList<>();

        for (int temp = 0; temp < MONEY; temp++) {
            usersLottos.add(getLottoNumber());
        }

        return usersLottos;
    }
}

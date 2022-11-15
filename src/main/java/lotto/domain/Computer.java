package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    // 2주차 피드백 반영
    static final String BUY_STR = "개를 구매했습니다.";
    static final int START_RANGE = 1;
    static final int END_RANGE = 45;
    static final int LOTTO_NUMBER_LENGTH = 6;
    static final int LOTTO_CHARGE = 1000;
    static final int VALID_TIME_CRITERIA = 0;
    static final int PASS_TURN = -1;

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_NUMBER_LENGTH);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<List<Integer>> createLottos(int money) {
        int times = countTimes(money);

        List<List<Integer>> lottos = new ArrayList<>();

        while (times > VALID_TIME_CRITERIA) {
            List<Integer> lotto = new Lotto(createLottoNumbers()).getNumbers();
            lottos.add(lotto);
            times += PASS_TURN;
        }
        return lottos;
    }

    public int countTimes(int money) {
        int times = money / LOTTO_CHARGE;
        // 실행 결과 예시와 맞추기 위해 한 칸 띄우기
        System.out.println();
        System.out.println(times + BUY_STR);
        return times;
    }

    public void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }
}

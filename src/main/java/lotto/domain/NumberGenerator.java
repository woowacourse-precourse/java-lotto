package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    Message message = null;

    final private int MIN_LOTTO_NUM = 1;
    final private int MAX_LOTTO_NUM = 45;
    final private int COUNT_LOTTO_NUM = 6;


    // 구매 티켓만큼 로또번호 생성
    public List<List<Integer>> createRandomNumbers(int numberOfTicket) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfTicket; i++) {
            lottoList.add(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, COUNT_LOTTO_NUM));
        }
        return lottoList;
    }
}
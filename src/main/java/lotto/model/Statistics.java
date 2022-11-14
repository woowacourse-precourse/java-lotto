package lotto.model;

import java.util.List;
import java.util.Map;

public class Statistics {

    // 당첨 갯수와 상을 모아두는 변수
    int PRIZE1 = 0, PRIZE2 = 0, PRIZE3 = 0, PRIZE4 = 0, PRIZE5 = 0;

    // 당첨 여부를 확인하는 매서드 checkPrize
    public void checkPrizeQuantity(List<Integer> answerLottoNumbers, int bounsNumber, List<Lotto> myLottoNumberBundle) {

        // 몇개 맞는지 확인
        for (Lotto lottoNumbers : myLottoNumberBundle) {
            Map matchNumberCount = checkMatchNumbersCount(answerLottoNumbers, bounsNumber, lottoNumbers);
        }

        // 이게 무슨 상인지 확인

    }

}

package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public void checkValidateNumber(String money) {
        for (int i = 0; i < money.length(); i++) {
            if ((int) money.charAt(i) < 48 || (int) money.charAt(i) > 57) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
            }
        }
    }

    // 구매 티켓만큼 로또번호 생성
    public List<List<Integer>> createRandomNumbers(int numberOfTicket) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfTicket; i++) {
            lottoList.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottoList;
    }
}
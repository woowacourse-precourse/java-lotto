package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    // 구매 티켓만큼 로또번호 생성
    public List<List<Integer>> createRandomNumbers(int numberOfTicket){
        List<List<Integer>> lottoList =  new ArrayList<>();
        for(int i = 0; i < numberOfTicket; i++){
            lottoList.add(Randoms.pickUniqueNumbersInRange(1,45,6));
        }
        return lottoList;
    }
}
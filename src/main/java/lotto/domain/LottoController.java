package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoController {
    private int price;
    private int lottoNumber;
    private static final int oneLottoPrice = 1000;
    private static final int start_Range = 1;
    private static final int end_Range = 45;
    private static final int count = 6;
    private List<Integer> winningLotto;
    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(start_Range,end_Range, count);
    }

    public int calculateLottoNumber(int price){
        if(price % oneLottoPrice != 0){
            throw new IllegalArgumentException("[ERROR] 가격은 천원 단위로 입력해주세요.");
        }
        return price / oneLottoPrice;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //구입금액 입력 받기
        int price = InputNum.askPrice();

        //로또 개수 구하기
        int lotto_cnt = Calculate.countLotto(price);
        
        //로또 발행하기
        List<Lotto> lottos = Lotto.makeLottoNums(lotto_cnt);
        



    }



}

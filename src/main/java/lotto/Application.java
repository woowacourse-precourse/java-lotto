package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // num개의 lotto를 발행하는 함수
    public List<Lotto> makeLottoNumber(List<Lotto> lottos, int num){
        for(int i = 0; i < num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public int checkPayMoney(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 가능합니다.");
        }
        return money/1000;
    }

    public int checkLottoSame(Lotto winningLotto, Lotto lotto){
        int same = 0;
        List<Integer> winNum = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i : lottoNumbers){
            if(winNum.contains(i)){
                same++;
            }
        }
        return same;
    }



}

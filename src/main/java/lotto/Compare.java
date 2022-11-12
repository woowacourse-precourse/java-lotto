package lotto;

import java.util.List;

// 로또 번호 비교
public class Compare {

    public static final int NUMBER_SIZE = 6;

    public Compare() {

    }

    public int compareNumbers(List<Integer> winNumber, List<Integer> lottoNumber) {
        int sameNumber = 0;
        int sameBonusNumber = -1;

        for(int i = 0; i < NUMBER_SIZE; i++) {
            if(lottoNumber.contains(winNumber.get(i))) {
                sameNumber++;
            }
        }

        // '5개 일치, 보너스 볼 일치 (30,000,000원)'일 때 -1 리턴
        if(sameNumber == NUMBER_SIZE - 1) {
            if(lottoNumber.contains(winNumber.get(6))) {
                return sameBonusNumber;
            }
        }

        return sameNumber;
    }

}

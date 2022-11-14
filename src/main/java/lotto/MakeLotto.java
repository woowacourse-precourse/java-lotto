package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class MakeLotto {

    Output output = new Output();
    public void makeLottoNumber(Lotto[] lottoArray ,int lottoCount){
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray[i] = new Lotto(numbers);

            output.lottoNumberPrinter(lottoArray[i]);
        }
    }

}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class MakeLotto {

    Output output = new Output();
    public void makeLottoNumber(int[][] lottoArray ,int lottoCount){
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            for (int j = 0; j < lottoArray[i].length; j++){
                lottoArray[i][j] = numbers.get(j);
            }

            Arrays.sort(lottoArray[i]);
            output.lottoNumberPrinter(lottoArray[i]);
        }
    }

}

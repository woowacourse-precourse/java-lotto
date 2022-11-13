package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Generator {

    public List<List<Integer>> generateRandomLottoNumber(int inputMoney){

        int lottoAmount = inputMoney/1000;

        List<List<Integer>> twoDimensionLottoNumberList = new ArrayList<>();

        for (int i = 0; i<lottoAmount; i++) {
            List<Integer> randomLottoNumber = pickUniqueNumbersInRange(1, 45, 6);

            twoDimensionLottoNumberList.add(randomLottoNumber);
        }


        return twoDimensionLottoNumberList;
    }





}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MakeLotto {

    Output output = new Output();

    public List<Integer> countSort(List<Integer> numbers){
        int[] numCount = new int[50];
        for(int i = 0; i < 6; i++){
            numCount[numbers.get(i)]++;
        }

        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i <= 45; i++){
            if (numCount[i] != 0){
                sortedList.add(i);
            }
        }

        return sortedList;
    }
    public void makeLottoNumber(Lotto[] lottoArray ,int lottoCount){
        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> inputNumbers = countSort(numbers);

            lottoArray[i] = new Lotto(numbers);

            output.lottoNumberPrinter(lottoArray[i]);
        }
    }

}

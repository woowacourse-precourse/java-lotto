package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class result {
    public static void printSixRange(List<Integer> randomLottos, int row) {
        List<Integer> seperateRandomLotto = new ArrayList<>();

        for(int j=row*6 ; j<(row+1)*6 ; j++){
            int target = randomLottos.get(j);
            seperateRandomLotto.add(target);
        }
        Collections.sort(seperateRandomLotto);
        System.out.println(seperateRandomLotto);
    }


}

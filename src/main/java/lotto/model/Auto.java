package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auto {

    public static List<List<Integer>> AUTOLOTTOS = new ArrayList<>();

    public Auto() {}
    public Auto(int lottoCount) {
        for(int i=0; i<lottoCount; i++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lotto);
            AUTOLOTTOS.add(lotto);
        }
    }
}

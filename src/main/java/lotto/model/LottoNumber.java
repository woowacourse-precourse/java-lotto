package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    static OutputView outputView = new OutputView();

    public static List<List<Integer>> userLotto(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(oneLotto());
        }
        return lottos;
    }

    public static void printUserLotto(List<List<Integer>> lotto) {
        for(int index=0;index<lotto.size();index++){
            outputView.userLottoMsg(index, lotto);
        }
    }

    private static List<Integer> oneLotto() {
        List<Integer> lotto = new ArrayList<>(RandomNumber());
        sortLotto(lotto);
        return lotto;
    }

    private static void sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
    }

    private static List<Integer> RandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}

package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    OutputView outputView = new OutputView();

    public List<List<Integer>> userLotto(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(oneLotto());
        }
        return lottos;
    }

    public void printUserLotto(List<List<Integer>> lotto) {
        for(int index=0;index<lotto.size();index++){
            outputView.userLottoMsg(index, lotto);
        }
    }

    private List<Integer> oneLotto() {
        List<Integer> lotto = RandomNumber();
        return lotto;
    }

    private List<Integer> RandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}

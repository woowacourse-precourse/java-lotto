package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCounting {

    // 로또 한장한장 세어서, Map 에다가 집어넣기. 그래서, 몇개 맞췄는지 매핑하기.
    public Map<Lotto, Integer> countedLotto(Lotto[] lottoPapers, Lotto winningLotto){
        Map<Lotto, Integer> lottoBox = new HashMap<>();
        for (Lotto oneLottoPaper : lottoPapers) {
            storeLottoInBox(lottoBox, oneLottoPaper, winningLotto);
        }

        return lottoBox;
    }
    // 한 장의 로또가 몇개 맞췄는지, 세어서 로또박스에 매핑해야 한다.
    private void storeLottoInBox(Map<Lotto, Integer> lottoBox, Lotto oneLottoPaper, Lotto winningLotto){
        int howManyNumbersCorrect = compareLottoAndCount(oneLottoPaper, winningLotto);
        lottoBox.put(oneLottoPaper,howManyNumbersCorrect);
    }

    int compareLottoAndCount(Lotto oneLottoPaper, Lotto winningLotto){
        int lottoCount = 0;
        List<Integer> lottoNumbers = oneLottoPaper.getNumbers();
        for (Integer oneLottoNumber : lottoNumbers) {
            if (winningLotto.getNumbers().contains(oneLottoNumber)) {
                lottoCount++;
            }
        }
        return lottoCount;
    }
}

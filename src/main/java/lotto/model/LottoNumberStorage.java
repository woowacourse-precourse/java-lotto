package lotto.model;

import lotto.util.MathUtil;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberStorage {
    private MathUtil mathUtil = new MathUtil();
    private RandomUtil randomUtil = new RandomUtil();
    public List<List<Integer>> lottoNumbers(int purchasePrice){
        List<List<Integer>> lottos = new ArrayList<>();
        Lotto lotto;
        for(int i=0;i<mathUtil.divide(purchasePrice);i++){
            List<Integer> list = randomUtil.makeRandomNumber();
            lotto = new Lotto(list);
            lottos.add(lotto.getNumbers());
        }
        return lottos;
    }
}

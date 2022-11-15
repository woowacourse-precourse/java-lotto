package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public List<Integer> publishLotto(){
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,NUMBER_COUNT);
    }

    public int decideToBuyLotto(int money){
        return money / LOTTO_PRICE;
    }

    public Set<Integer> compareLottoNumber(List<Integer> lottoNumber, List<Integer> winLottoNumber){
        Set<Integer> common = new HashSet<>(lottoNumber);
        common.retainAll(winLottoNumber);
        return common;
    }

    public int countMatchNumber(Set<Integer> common){
        return common.size();
    }

    public Boolean isInclude(List<Integer> winLottoNumber, int bonusNumber){
        return winLottoNumber.contains(bonusNumber);
    }

    public Boolean compareBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}

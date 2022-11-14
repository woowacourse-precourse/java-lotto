package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class UIException {
    public void notNumberException(String money){
        try {
            int moneyInt = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void notMultipleOf1000Exception(String money){
        int moneyInt = Integer.parseInt(money);
        if(moneyInt % 1000 != 0) throw new IllegalArgumentException("[ERROR]");
    }

    public void duplicateNumberException(List<Integer> lotto){
        Set<Integer> set = new HashSet<>(lotto);
        if(set.size() != lotto.size()) throw new IllegalArgumentException("[ERROR]");
    }

    public void overBoundaryException(List<Integer> lotto){
        for(Integer e: lotto)
        {
            if(e > 45) throw new IllegalArgumentException("[ERROR]");
            if(e < 1) throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void CheckLottoLength(List<String> lottoNumber){
        if(lottoNumber.size() != 6) throw new IllegalArgumentException("[ERROR] 유저숫자 입력 - 로또 번호 길이 오류");
    }

    public void BonusNumberException(List<Integer> lotto, int bonus){
        if(lotto.contains(bonus)) throw new IllegalArgumentException("[ERROR]");
    }




}

package lotto;

import java.util.*;
import lotto.Lotto;

public class Manager {
    public final int LOTTO_MIN = 1;
    public final int LOTTO_MAX = 45;
    public final int LOTTO_LENGTH = 6;

    public final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public final String PURCHASE_MENT = "개를 구매했습니다.";
    public final String INPUT_WINNING = "당첨 번호를 입력해 주세요.";
    public final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    public final String INIT_RESULT = "당첨 통계\n---\n";
    public final String INIT_WINNING_RATE = "총 수익률은 ";
    public final String CLOSE_WINNING_RATE = "%입니다.";

    public boolean isNumber(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }

    public boolean ValidityOfNumber(List<String> list){
        for(int i=0; i<list.size(); i++){
            if(isNumber(list.get(i))) continue;
            return false;
        }
        return true;
    }

    public boolean ValidRangeOfLottoNumber(List<Integer> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) < LOTTO_MIN || list.get(i) > LOTTO_MAX) return false;
        }
        return true;
    }

    public boolean OverlapOfLottoNumber(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(list.get(i));
        }
        return set.size() != LOTTO_LENGTH;
    }
}

package lotto;

import java.util.List;
import lotto.Lotto;

public class Manager {
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
            if(list.get(i) < 1 || list.get(i) > 45) return false;
        }
        return true;
    }
}

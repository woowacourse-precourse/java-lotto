package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exceptions {
    public static void isSameBonusNum(List<Integer> numberlist, int bonusNumber){
        if(numberlist.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 로또번호가 중복되었습니다.");
        }
    }
    public static void isSameNumber(List<Integer> numList){
        if(numList.size() != numList.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 로또번호가 있습니다.");
        }
    }








}

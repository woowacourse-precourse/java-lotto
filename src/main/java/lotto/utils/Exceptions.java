package lotto.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exceptions {

    public static void isNumber(String str){
        try{
            Integer.parseInt(str);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    };

    public static void checkPay(int num){
        if (num %1000 >0 || num==0){
            throw new IllegalArgumentException("[ERROR]");
        }
    };
    public static void checkBonusNum(List<Integer> numList, int bonusNum){
        if (numList.contains(bonusNum)){
            throw new IllegalArgumentException("[ERROR]");
        }
    };
    public static void checkDuplicated(List<Integer> numList){
        Set<Integer> numSet = new HashSet<>(numList);
        if (numSet.size() != numList.size()){
            throw new IllegalArgumentException("[ERROR]");
        };
    };

    public static void checkInput(List<Integer> numList){
        if (numList.size() != 6 ){
            throw new IllegalArgumentException("[ERROR] 수는 6개를 입력하셔야 합니다.");
        }
        for (int i=0; i<numList.size(); i++){
            if (1>numList.get(i) || numList.get(i)>45){
                throw new IllegalArgumentException("[ERROR] 1에서 45까지의 숫자만 가능합니다.");
            }
        }
    }
}

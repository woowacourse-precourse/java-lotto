package lotto;

import java.util.List;

public class Exceptions {
    public static void Number_exception(String purchase_Input){
        for(int i=0; i<purchase_Input.length(); i++){
            if((int)(purchase_Input.charAt(i))>57 || (int)(purchase_Input.charAt(i))<48){
                throw new IllegalArgumentException("[ERROR] 자연수 값을 입력해주세요.") ;
            }
        }
    }

    public static void Unit_exception(String purchase_Input){
        if((Integer.parseInt(purchase_Input)%1000)!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public static void Lotto_Number_exception(String [] strings){
        for(int i=0; i<strings.length; i++){
            Number_exception(strings[i]);
            Range_exception(strings[i]);
        }
    }

    public static void Range_exception(String str){
        if(Integer.parseInt(str)<1 || Integer.parseInt(str)>45){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 정수를 입력해주세요.");
        }
    }

    public static void Duplicate_exception(List<Integer> list){
        int key = list.size()-1;
        int temp = list.get(key);

        list.remove(key);
        if(list.contains(temp)){
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 입력해주세요.");
        }
        list.add(temp);
    }

    public static void Duplicate_exception_bonus(int bonus, List<Integer> winner_number){
        if(winner_number.contains(bonus)) throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 값을 입력해주세요.");
    }

}

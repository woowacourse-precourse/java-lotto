package lotto;

import java.util.List;

import static lotto.Application.error_Status;

public class Exceptions {

    public static void Number_exception(String purchase_Input){
        for(int i=0; i<purchase_Input.length(); i++){
            if((int)(purchase_Input.charAt(i))>57 || (int)(purchase_Input.charAt(i))<48){
                System.out.println("[ERROR] 자연수 값을 입력해주세요.");
                error_Status = true;
//                throw new IllegalArgumentException("[ERROR] 자연수 값을 입력해주세요.") ;
            }
        }
    }

    public static void Unit_exception(String purchase_Input){
        if((Integer.parseInt(purchase_Input)%1000)!=0){
            System.out.println("[ERROR] 1000원 단위로 입력해주세요");
            error_Status = true;
//            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public static void Lotto_Number_exception(String [] strings){
        for(int i=0; i<strings.length; i++){
            Number_exception(strings[i]);
            if(error_Status) break;
            Range_exception(strings[i]);
            if(error_Status) break;
        }
    }

    public static void Range_exception(String str){
        if(Integer.parseInt(str)<1 || Integer.parseInt(str)>45){
            System.out.println("[ERROR] 1~45사이의 정수를 입력해주세요");
            error_Status = true;
//            throw new IllegalArgumentException("[ERROR] 1~45사이의 정수를 입력해주세요.");
        }
    }

    public static void Duplicate_exception(List<Integer> list){
        int key = list.size()-1;
        int temp = list.get(key);

        list.remove(key);
        if(list.contains(temp)){
//            System.out.println("[ERROR] 중복되지 않는 값을 입력해주세요.");
//            error_Status = true;
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 입력해주세요.");
        }
        list.add(temp);
    }

}

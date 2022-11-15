package lotto;

import java.util.List;

public class Validate {

    public static void validatePrice(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액이여야 합니다.");
        }
    }


    public static void validateLotto(String InputNums){
        if(!InputNums.contains(",") || InputNums.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.]")){
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분하여 1~45사이의 숫자 6개를 입력하여 주세요.");
        }

    }

    public static void validateBonus(String inputNum) {

        if (inputNum.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.,]")){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 1개를 입력하여 주세요.");
        }

    }

    public static void validateRange(int Num){
        if(Num < 1 || Num > 45){
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자 를 입력하여 주세요.");
        }
    }

    public static void validateDuplication(List<Integer> winningNums){
        if(winningNums.size() != winningNums.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    public static void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또는 1~45사이의 숫자 6개여야 합니다.");
        }
    }




}

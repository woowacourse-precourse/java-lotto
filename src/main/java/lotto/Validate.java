package lotto;

import java.util.List;

public class Validate {

    public static void validatePrice(int price){

        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }


    }


    public static void validateLotto(String InputNums){

        if(!InputNums.contains(",") || InputNums.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.]")){
            throw new IllegalArgumentException();
        }

    }

    public static void validateInt(String inputNum) {

        if (!inputNum.matches("[0-9]+")||inputNum.matches("[a-zA-Z ㄱ-ㅎㅏ-ㅣ가-힣.]")){
            throw new IllegalArgumentException();
        }

    }

    public static void validateRange(int Num){

        if(Num < 1 || Num > 45){
            throw new IllegalArgumentException();
        }

    }

    public static void validateDuplication(List<Integer> winningNums){

        if(winningNums.size() != winningNums.stream().distinct().count()){
            throw new IllegalArgumentException();
        }


    }

    public static void validateSize(List<Integer> numbers){

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

    }




}

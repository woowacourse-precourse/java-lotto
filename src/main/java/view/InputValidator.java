package view;

public class InputValidator {

    private InputValidator(){
    }

    public static int validateInt(String str){
        try {
            int stringToInt = Integer.parseInt(str);
            return stringToInt;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수로 입력하셔야 합니다.");
        }
    }

    public static void validatePrice(int price){
        if (price%1000!=0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력하셔야 합니다.");
    }
}

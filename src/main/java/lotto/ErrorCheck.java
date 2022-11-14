package lotto;

public class ErrorCheck {
    public static boolean isValidPrice(String userInput){
        try{
            Integer.parseInt(userInput);
            return true;
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 금액을 제대로 입력해주세요.");
        }
    }

    public static boolean isValidNumber(String inputBonus){
        try{
            Integer.parseInt(inputBonus);
            return true;
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 제대로 입력해 주세요.");
        }
    }
}

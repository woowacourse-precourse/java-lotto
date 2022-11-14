package lotto;

public class ErrorCheck {
    public static boolean isValidPrice(String userInput){
        try{
            Integer.parseInt(userInput);
            return true;
        }catch(Exception e){
            System.out.println("[ERROR] 금액을 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}

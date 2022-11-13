package lotto;

public class UserMissChecking {

    // 금액 입력 시 숫자를 입력하지 않은 경우에 대한 에러체킹
    public static int numberChecking(String input){
        try {
            return Integer.parseInt(input);
        } catch (Exception e){
            System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            return -1;
        }
    }
}

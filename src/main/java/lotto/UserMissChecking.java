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

    // 금액을 1000원 단위로 입력하지 않았을 시 발생하는 에러체킹
    public static boolean thousandChecking(int money){
        try{
            if(money % 1000 != 0) throw new IllegalArgumentException();
        }catch (Exception e){
            System.out.println("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
            return false;
        }
        return true;
    }
}

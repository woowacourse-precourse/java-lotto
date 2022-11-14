package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    // 로또 구입 메소드
    private static int buyLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        if(!checkNumber(input)) {
            System.out.println("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if(money%1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        int lottoCount = money/1000;
        return lottoCount;
    }

    // 입력값 숫자인지 확인 메소드
    private static boolean checkNumber(String input){
        char check;
        if(input.equals("")) {
            return false;
        }
        for(int i = 0; i < input.length(); i++){
            check = input.charAt(i);
            if(check < 48 || check > 58) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}

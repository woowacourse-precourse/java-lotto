package lotto;

import java.util.Collections;
import java.util.List;

public class UserMissChecking {

    // 금액 입력 시 숫자를 입력하지 않은 경우에 대한 에러체킹
    public static void numberChecking(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("[ERROR] 금액은 숫자로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 금액을 1000원 단위로 입력하지 않았을 시 발생하는 에러체킹
    public static void thousandChecking(int money) {
        try {
            if (money % 1000 != 0) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 유저가 입력한 금액이 1~45 사이의 숫자가 아닌 경우 발생하는 에러
    public static void numberLimitChecking(int num) {
        if (num > 45 || num < 1) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 보너스 숫자 확인 메서드
    public static int bonusNumberChecking(List<Integer> lottoNum, String input) {
        numberChecking(input);
        int bonusNum = Integer.parseInt(input);
        numberLimitChecking(bonusNum);
        bonusRepeat(lottoNum, bonusNum);
        return bonusNum;
    }

    // 로또 구매 시 반복 되는 숫자 기입 여부 확인 메소드
    public static void numRepeatCheck(List<Integer> lottoNum) {
        for (int i = 0; i < lottoNum.size() - 1; i++) {
            if (Collections.frequency(lottoNum,lottoNum.get(i)) > 1) {
                System.out.println("[ERROR] 같은 숫자를 두 번 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void bonusRepeat(List<Integer> lottoNum, int bonusNum){
        if(lottoNum.contains(bonusNum)){
            System.out.println("[ERROR] 같은 숫자를 두 번 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}

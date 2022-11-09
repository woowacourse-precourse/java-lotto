package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public int getMoney(){
        String inputMoney = Console.readLine();
        isInteger(inputMoney);

        int money = Integer.parseInt((inputMoney));
        isSplit(money);

        int lottoCnt;
        lottoCnt = money / 1000;
        return lottoCnt;
    }
    public static void isSplit(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("다시 입력 해주세요");
        }
    }
    public static void isInteger(String inputMoney){
        for(int i = 0; i < inputMoney.length(); i++){
            if (inputMoney.charAt(i) < '0' || inputMoney.charAt(i) > '9' ){
                throw new IllegalArgumentException("다시 입력 해주세요");
            }
        }
    }
    public ArrayList<Integer> GenerateLotto(){ // 숫자 생성
        ArrayList<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 8) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }
        return lotto;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

}

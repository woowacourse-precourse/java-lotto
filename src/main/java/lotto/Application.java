package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> numbers = new ArrayList<>();

        System.out.println("로또 프로그램입니다. \n금액을 입력해 주세요");
        String purchase = Console.readLine();           // 구매 금액

        // 유효한 구매 금액인지 확인 - 1000원 단위로 나누어지지 않으면 잘못된 입력
        if(!isValidPurchase(purchase)){
            System.out.println("잘못된 입력입니다! 수량에 맞는 금액을 입력해 주세요!");
            purchase = Console.readLine();
        }

        // 로또 수량
        int amount = Integer.parseInt(purchase) / 1000;
        System.out.println(amount+"개를 구매했습니다.");

        // 로또 생성
        generateLotto(numbers, amount);

        // 당첨 번호 입력(콤마로 구분)
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        Lotto winLotto = new Lotto(winningNumber);
        //System.out.println(winLotto.getNumbers());

        // 보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }

    // 구매 금액이 유효한지 확인하고 리턴
    static boolean isValidPurchase(String purchase) {
        if (Integer.parseInt(purchase) % 1000 != 0) {
            return false;
        }return true;
    }

    // 로또 생성 & 오름차순으로 정렬
    static void generateLotto(List<List<Integer>> numbers, int amount){

        // 로또 번호 생성
        for(int i=0; i<amount; i++){
            numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        for(int i=0; i<numbers.size(); i++){
            Collections.sort(numbers.get(i));     // 오름차순 정렬
        }
    }

}

package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    static int money;   // 돈 액수
    static int[] correctNums;   // 당첨 번호 리스트
    static int bonusNum;    // 보너스 번호

    /**
     * 발행한 로또 수량 및 번호를 출력한다.
     * 로또 번호는 오름차순으로 정렬하여 보여준다.
     */
    static void printLotto(){
        int cntLotto = money / 1000;    // 로또 수량
        System.out.println("cntLotto = " + cntLotto);   // 로또 수량 출력
        for(int i = 0; i < cntLotto; i++){
            
        }
    }

    /**
     * 숫자를 입력받아 1000으로 나누어 떨어지지 않을 경우 예외 처리
     * @param num
     */
    static void checkCanDivideBy1000(int num){
        if(num % 1000 != 0){
            System.out.println("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();

        // 1000원으로 나누어 떨어지지 않는 경우 예외 처리
        checkCanDivideBy1000(money);

        // 당첨 번호를 입력
        String inputNumbers = sc.next();
        String[] splitedNumbers = inputNumbers.split(",");

        correctNums = Arrays.stream(splitedNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        // 보너스 번호 입력
        bonusNum = sc.nextInt();

        // 발행한 로또 수량 및 번호를 출력. 로또 번호는 오름차순으로 정렬해서 보여준다.
        printLotto();


    }
}

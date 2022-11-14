package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {


    static long purchaseAmount = 0;
    static int numberOfTickets = 0;


    public static void enterPurchaseAmount() {

        String strAmount = Console.readLine();
        long amount = Long.parseLong(strAmount);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수만 입력 가능합니다.");
        }
        purchaseAmount = amount;
        numberOfTickets = (int) amount / 1000;
    }


    public static void printNumberOfTickets() {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
    }


    public static int[] enterTheWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinningNums = Console.readLine();
        String[] tmpArr = strWinningNums.split(",");
        int[] winningNums = new int[tmpArr.length];

        for (int i = 0; i < tmpArr.length; ++i) {
            winningNums[i] = Integer.parseInt(tmpArr[i]);
        }
        return winningNums;

    }

    public static List<Integer> generateLotto() {

        List<Integer> lottoList = new ArrayList<>();

        while (lottoList.size() < 6) {

            int r = Randoms.pickNumberInRange(1, 45);   // 1, 45 포함
            if (lottoList.contains(r)) {
                continue;
            }

            lottoList.add(r);
            System.out.println(r);
        }

        Lotto lotto = new Lotto(lottoList); // 생성한 로또에 대해 유효성 검사
        Collections.sort(lottoList);

        return lottoList;

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        enterPurchaseAmount();      // 구매 금액 입력
        printNumberOfTickets();     // 로또 개수 출력

        List<Integer> lotto = generateLotto();   // 로또 랜덤으로 생성

        int [] winningNums = enterTheWinningNumber();   // 당첨번호 입력 받기

    }
}

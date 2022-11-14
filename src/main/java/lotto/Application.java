package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.nio.sctp.IllegalReceiveException;
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

            if (tmpArr[i].equals("")) {       // 콤마를 연달아 입력한 경우
                throw new IllegalReceiveException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");

            }

            for (char c : tmpArr[i].toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalReceiveException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");

                }
            }

            winningNums[i] = Integer.parseInt(tmpArr[i]);
        }

        // 입력한 String에 대한 유효성 검사
        List<Integer> list = new ArrayList<>();
        for (int winningNum : winningNums) {
            list.add(winningNum);
        }

        Lotto lotto = new Lotto(list);
        return winningNums;

    }

    public static int validateBonusNum(int[] winningNums) {

        List<Integer> winningNumsList = List.of(winningNums[0], winningNums[1], winningNums[2],
            winningNums[3], winningNums[4], winningNums[5]);

        System.out.println("보너스 번호를 입력해 주세요.");
        String tmp = Console.readLine();

        if (tmp.equals("")) {       // 콤마를 연달아 입력한 경우
            throw new IllegalReceiveException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");

        }

        for (char c : tmp.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalReceiveException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
            }
        }

        int bonusNum = Integer.parseInt(tmp);

        if (winningNumsList.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        if (bonusNum < 1 || 45 < bonusNum) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 부터 45 사이의 숫자여야 합니다.");
        }

        return bonusNum;
    }


    public static List<Integer> generateLotto() {

        List<Integer> lottoList = new ArrayList<>();

        while (lottoList.size() < 6) {

            int r = Randoms.pickNumberInRange(1, 45);   // 1, 45 포함
            if (lottoList.contains(r)) {
                continue;
            }

            lottoList.add(r);
//            System.out.println(r);
        }

        Lotto lotto = new Lotto(lottoList); // 생성한 로또에 대해 유효성 검사
        Collections.sort(lottoList);

        return lottoList;

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        enterPurchaseAmount();      // 구매 금액 입력
        printNumberOfTickets();     // 로또 개수 출력

        List<List<Integer>> allLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; ++i) {
            List<Integer> lotto = generateLotto();   // 로또 랜덤으로 생성
            allLottoList.add(lotto);
        }

        for (List<Integer> lotto : allLottoList) {
            System.out.println(lotto);
        }

        int[] winningNums = enterTheWinningNumber();   // 입력한 당첨
        Lotto lotto = new Lotto(List.of(winningNums[0], winningNums[1], winningNums[2],
            winningNums[3], winningNums[4], winningNums[5]));
        int bonusNum = validateBonusNum(winningNums);   // 보너스 번호 입력

    }
}

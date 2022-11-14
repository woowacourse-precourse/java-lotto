package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.nio.sctp.IllegalReceiveException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {


    public static int enterPurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
        String strAmount = Console.readLine();
        int amount = Integer.parseInt(strAmount);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }

        return amount;

    }


    public static int printNumberOfTickets(int amount) {

        int cnt  = amount / 1000;
        System.out.println(cnt + "개를 구매했습니다.");
        return cnt;

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


    public static List<List<Integer>> generateAllLotto(int numberOfTickets){

        List<List<Integer>> allLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; ++i) {
            List<Integer> lotto = generateLotto();   // 로또 랜덤으로 생성
            allLottoList.add(lotto);
        }

        for (List<Integer> lotto : allLottoList) {
            System.out.println(lotto);
        }

        return allLottoList;

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int amount = enterPurchaseAmount();      // 구매 금액 입력
        int numberOfTickets = printNumberOfTickets(amount);     // 로또 개수 출력

        List<List<Integer>> allLotto = generateAllLotto(numberOfTickets);

        int[] winningNums = enterTheWinningNumber();   // 당첨 번호 입력
        List<Integer> tmp = new ArrayList<>();

        for(int winningNum : winningNums){
            tmp.add(winningNum);

        }

        Lotto lotto = new Lotto(tmp);


        int bonusNum = validateBonusNum(winningNums);   // 보너스 번호 입력




    }
}

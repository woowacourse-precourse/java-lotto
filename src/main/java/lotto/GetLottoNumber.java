package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetLottoNumber {
    static String strWinNum; //당첨번호
    static int[] winNum; // 당첨번호
    static int bonusNumber; //보너스번호
    List<Integer> temp = new ArrayList<>();

    public GetLottoNumber(List<Integer> numbers) {}

    public List<Integer> GetLotto(List<Integer> numbers) {
        int cnt = 0;
        temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.addAll(temp);
        System.out.println(numbers);
        return numbers;
    }

    public String WinNumInput() { // 당첨번호 입력
        winNum = new int[6];
        String[] temp;
        strWinNum = Console.readLine();
        temp = strWinNum.split(",");

        if (temp.length != 6) {
            System.out.println("[ERROR] 입력하신 당첨 번호는 6개가 아닙니다.");
            return "0";
        }

        try {
            for (int i = 0; i < 6; i++)
                winNum[i] = Integer.parseInt(temp[i]);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            return "0";
        }
        return strWinNum;
    }

   public int[] WinNum(String strWinNum) { // 당첨번호 배열에 저장
        if(strWinNum.equals("0")){
            return new int[]{0};
        }

        winNum = new int[6];
        String[] temp = strWinNum.split(",");

        for (int i = 0; i < 6; i++) {
            winNum[i] = Integer.parseInt(temp[i]);
            if (winNum[i] < 1 || winNum[i] > 45) {
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                return new int[]{0};
            }
        }
        return winNum;
    }

    public int Bonus() {// 보너스번호
        bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            return 0;
        }
        return bonusNumber;
    }

}
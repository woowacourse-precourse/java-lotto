package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> winningNumbers;
    static int bonusNumber;
    public enum Places{
        FIFTH, FOURTH, THIRD, SECOND, FIRST, OTHERS
    }
    public static void main(String[] args) {


        User user = new User();
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();

    }
    public static List<Integer> getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = readLine();
        winningNumberValidTest(winningNumber);
        String[] splittedWinningNumbers = winningNumber.trim().split("\\s*,\\s*"); // 공백 제거 + ","로 split

        List<Integer> winningNumbers = new ArrayList<>();

        for(int order=0;order<splittedWinningNumbers.length;order++) winningNumbers.add(Integer.parseInt(splittedWinningNumbers[order]));

        return winningNumbers;
    }
    public static int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        bonusNumberValidTest(bonusNumber,winningNumbers);

        return Integer.parseInt(bonusNumber);
    }
    public static void winningNumberValidTest(String winningNumber){ // winningNumber의 validTest 진행
        // 1. 숫자와 , 로 이루어져 있는가?
        // 2. 숫자가 6개가 인가?
        // 3. 숫자가 1~45 사이의 범위 인가?
        // 4.
    }
    public static void bonusNumberValidTest(String bonusNumber, List<Integer> winningNumbers){
        // 1. 숫자 인가?
        // 2. 숫자 1개 인가?
        // 3. 숫자가 1~45 사이의 범위 인가?
        // 4. 당첨 번호 6개와 다른 숫자 인가?
    }
}

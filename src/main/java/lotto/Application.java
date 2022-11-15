package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public boolean checkSort(List<Integer> temp){
        boolean flag = true;

        for (int i = 0; i < temp.size() - 1; i++){
            if (temp.get(i) > temp.get(i + 1))
                flag = false;
        }
        return flag;
    }
    WinningGrade winningGrade = new WinningGrade();
    InputPrime prime = new InputPrime();
    WinningNumber winnum = new WinningNumber();
    GetGrade grade = new GetGrade();
    List<Integer> winningNumber;
    public void startLotto(){
        int lottoCount;
        int bonusNumber;
        EnumMap emap = winningGrade.enumMapinit();

        lottoCount = prime.inputPrime();
        if (lottoCount == -1)
            return ;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<List<Integer>> numbers = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++){
            numbers.add(Randoms.pickUniqueNumbersInRange(1,45,6));
            if (checkSort(numbers.get(i)) == false){
                Collections.sort(numbers.get(i));
            }
            System.out.println(numbers.get(i));
        }
        winningNumber = winnum.getWinningNumber();
        bonusNumber = winnum.BonusNumber();
        for (int i = 0; i < lottoCount; i++){
            Lotto lo = new Lotto(numbers.get(i));
            emap = winningGrade.inputGrade(emap, grade.getGrade(winningNumber, numbers.get(i)), grade.getBonus(numbers.get(i), bonusNumber));
        }
        winningGrade.printGrade(emap, lottoCount);
    }
    public static void main(String[] args) {
        Application app = new Application();
        // TODO: 프로그램 구현

        app.startLotto();
    }
}

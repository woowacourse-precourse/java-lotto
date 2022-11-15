package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumber {
    public List<Integer> getWinningNumber(){
        List<Integer> winNumber;
        String winNumberstr;

        System.out.println("담첨 번호를 입력해 주세요.");
        winNumberstr = Console.readLine();
        winNumber = ChangeList(winNumberstr);

        return winNumber;
    }

    public List<Integer> ChangeList(String winNumberstr){
        List<Integer> winNumber = new ArrayList<>();
        String[] divwinNumber;

        divwinNumber = winNumberstr.split(",");
        try {
            for (int i = 0; i < divwinNumber.length; i++) {
                winNumber.add(Integer.parseInt(divwinNumber[i]));
            }
            if (winNumber.size() != 6){
                throw new IllegalArgumentException("[Error]6개의 숫자만 입력해 주세요");
            }
            return winNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[Error]숫자만 입력하세요");
        }
    }

    public int BonusNumber(){
        int bonusNumber;

        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            return bonusNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]숫자만 입력하세요.");
        }
    }

    public boolean checkException(int num){
        if (num < 1 || num > 45)
            return false;
        return true;
    }
}

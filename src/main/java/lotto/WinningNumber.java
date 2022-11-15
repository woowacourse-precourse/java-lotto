package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

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
            if (checkException(winNumber) == false){
                throw new IllegalArgumentException(("[ERROR]로또번호는 45가 넘을 수 없습니다."));
            }
            if (checkDouble(winNumber) == false){
                throw new IllegalArgumentException(("[ERROR]중복된 수룰 넣을 수 없습니다."));
            }
            if (winNumber.size() != 6){
                throw new IllegalArgumentException("[ERROR]6개의 숫자만 입력해 주세요");
            }
            return winNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]숫자만 입력하세요");
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

    public boolean checkException(List<Integer> num){
        for (int i = 0; i < num.size(); i++){
            if (num.get(i) < 1 || num.get(i) > 45)
                return false;
        }
        return true;
    }

    public boolean checkDouble(List<Integer> num){
        Set<Integer> numList = new HashSet<>(num);

        if (num.size() != numList.size()){
            return false;
        }
        return true;
    }
}

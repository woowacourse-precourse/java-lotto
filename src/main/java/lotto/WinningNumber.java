package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public Lotto inputWinningNum(String winningString) {
        try {
            String[] strArray = winningString.split(",");
            List<Integer> winningLottoNumbers = changeIntArr(strArray);

            Lotto Winninglotto = new Lotto(winningLottoNumbers);
            return Winninglotto;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    public int inputBonusNum(String BonusStr) {
        int bonusNum = 0;

        if (isNumeric(BonusStr) && inRange(Integer.parseInt(BonusStr))) {
            bonusNum = Integer.parseInt(BonusStr);
        }

        return bonusNum;
    }

    public List<Integer> changeIntArr(String[] strArray) { // string 배열을 받아서 조건이 맞으면 int 배열로 바꿔준다.
        List<Integer> winningArray = new ArrayList<>();
        for(int i = 0; i < strArray.length; i++) {
            if(isNumeric(strArray[i])) {
                winningArray.add(Integer.parseInt(strArray[i]));
            }
        }
        return winningArray;
    }

    private boolean isNumeric(String s) { // input string이 숫자인지 문자인지 판단
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean inRange(int num) { // 범위 안에 드는지 판단
        if((1 > num || num > 45)){
            throw new IllegalArgumentException();
        }
        return true;
    }
}


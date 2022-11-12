package lotto;
import camp.nextstep.edu.missionutils.Console;

public class WinningNumber {

    public void inputWinningNum(String winningString) {
        String[] strArray = winningString.split(",");
        int[] winningNumbers = changeIntArr(strArray);
        winningSize(winningNumbers);
    }

    public void inputBonusNum(String BonusStr) {
        int bonusNum = 0;
        if (isNumeric(BonusStr) && inRange(Integer.parseInt(BonusStr))) {
            bonusNum = Integer.parseInt(BonusStr);
        }
    }

    public int[] changeIntArr(String[] strArray) {
        int[] intArr = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            if(isNumeric(strArray[i]) && inRange(Integer.parseInt(strArray[i]))) {
                intArr[i] = Integer.parseInt(strArray[i]);
            }
        }
        return intArr;
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }

    private boolean inRange(int i) {
        if((1 <= i && i <= 45)){
            return true;
        }
        System.out.println("[ERROR] 잘못된 범위의 값을 입력하셨습니다");
        throw new IllegalArgumentException();
    }

    private void winningSize(int[] arr) {
        if(arr.length != 6) {
            System.out.println("[ERROR] 6개의 당첨 번호가 아닙니다");
            throw new IllegalArgumentException();
        }
    }
}


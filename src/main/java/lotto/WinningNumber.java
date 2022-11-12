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
        if (isNumeric(BonusStr)) {
            bonusNum = Integer.parseInt(BonusStr);
        }
    }

    public int[] changeIntArr(String[] strArray) {
        int[] intArr = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            if(isNumeric(strArray[i])){
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

    private void winningSize(int[] arr) {
        if(arr.length != 6) {
            System.out.println("[ERROR] 잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }
}


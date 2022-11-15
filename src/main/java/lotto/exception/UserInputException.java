package lotto;

public class UserInputException {
    public UserInputException() {
    }

    // 입력 자료형이 정수인지와 입력 숫자의 크기를 동시 확인
    boolean checkInputTypeAndRange(String inputString){
        if (checkInputIsInteger(inputString)
                && checkWinningNumberRange(Integer.valueOf(inputString))){
            return true;
        }
        return false;
    }

    // 입력받은 값이 정수가 아니라면 false 리턴
    boolean checkInputIsInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 입력값이 1000의 배수인지 확인하는 함수
    boolean checkMultipleOfThousand(int purchasingAmount) {
        if (purchasingAmount % 1000 != 0)
            return false;
        return true;
    }

    boolean checkWinningNumberSize(int size) {
        if (size != 6)
            return false;
        return true;
    }

    boolean checkWinningNumberRange(int num) {
        if (num > 0 && num < 46)
            return true;
        return false;
    }

}

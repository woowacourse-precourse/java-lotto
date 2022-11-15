package lotto.exception;

public class UserInputException {
    final static int minimumUnitOfAmount = 1000;
    final static int lottoNumLength = 6;
    final static int numSizeStart = 1;
    final static int numSizeEnd = 45;

    // 입력 자료형이 정수인지와 입력 숫자의 크기를 동시 확인
    public boolean checkInputTypeAndRange(String inputString){
        if (checkInputIsInteger(inputString)
                && checkWinningNumberRange(Integer.valueOf(inputString))){
            return true;
        }
        return false;
    }
    // 입력받은 값이 정수가 아니라면 false 리턴
    public boolean checkInputIsInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    // 입력값이 1000의 배수인지 확인하는 함수
    public boolean checkMultipleOfThousand(int purchasingAmount) {
        if (purchasingAmount % minimumUnitOfAmount != 0)
            return false;
        return true;
    }
    // 입력받은 사이즈가 6인지 확인하는 함수
    public boolean checkWinningNumberSize(int size) {
        if (size != this.lottoNumLength)
            return false;
        return true;
    }
    //
    boolean checkWinningNumberRange(int num) {
        if (num >= this.numSizeStart && num <= this.numSizeEnd)
            return true;
        return false;
    }
}

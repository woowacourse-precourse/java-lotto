package lotto.exception;
public class ErrorHandler {
    final static String ERROR_PREFIX = "[ERROR] ";
    public static void sizeOverException(){
        errorThrow(ERROR_PREFIX + "로또 번호는 6개 입력되어야 합니다.");
    }
    public static void numberUnCorrectException(){
        errorThrow(ERROR_PREFIX+"로또 번호는 1-45사이로 입력되어야 합니다.");
    }
    public static void mutualInputException(){
        errorThrow(ERROR_PREFIX+"로또 번호는 중복되지 않게 입력되어야 합니다.");
    }
    public static void unCorrectMoneyRangeException(){
        errorThrow(ERROR_PREFIX+"로또 금액은 숫자만 입력되어야 합니다.");
    }
    public static void unCorrectMoneyInputException(){
        errorThrow(ERROR_PREFIX+"로또 금액은 1000의 배수여야 합니다.");
    }
    private static void errorThrow(String message){
        throw new IllegalArgumentException(message);
    }
}

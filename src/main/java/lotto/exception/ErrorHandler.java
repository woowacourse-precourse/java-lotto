package lotto.exception;

public class ErrorHandler {
    final static String ERROR_PREFIX = "[ERROR] ";
    public static void sizeOverException(){
        System.out.println(ERROR_PREFIX+"로또 번호는 6개 입력되어야 합니다.");
        errorThrow();
    }
    public static void numberUnCorrectException(){
        System.out.println(ERROR_PREFIX+"로또 번호는 1-45사이로 입력되어야 합니다.");
        errorThrow();
    }
    public static void mutualInputException(){
        System.out.println(ERROR_PREFIX+"로또 번호는 6개 입력되어야 합니다.");
        errorThrow();
    }
    public static void unCorrectMoneyRangeException(){
        System.out.println(ERROR_PREFIX+"로또 금액은 숫자만 입력되어야 합니다.");
        errorThrow();
    }
    public static void unCorrectMoneyInputException(){
        System.out.println(ERROR_PREFIX+"로또 금액은 1000의 배수여야 합니다.");
        errorThrow();
    }
    private static void errorThrow(){
        throw new IllegalArgumentException();
    }
}

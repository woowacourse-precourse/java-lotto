package lotto.view;

public final class ErrorMessage {
    public static void numberInRangeError(int startInclusive, int encInclusive){
        System.out.printf("[ERROR] 입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n");
    }

    public static void duplicationListError(){
        System.out.printf("[ERROR] 입력 값들은 서로 중복되지 않아야 합니다.\n");
    }

    public static void lengthError(int length){
        System.out.printf("[ERROR] 입력 값의 개수는 %d개 여야 합니다.\n",length);
    }

    public static void multipleNumberError(int divisor){
        System.out.printf("[ERROR] 입력 값은 %d의 배수여야 합니다.\n",divisor);
    }

    public static void exceedError(int limitNumber){
        System.out.printf("[ERROR] 입력 값은 %d 이하의 값이어야 합니다.\n",limitNumber);
    }

    public static void stringToIntegerError(){
        System.out.printf("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.\n");
    }

    public static void duplicatedNumberInListError(){
        System.out.printf("[ERROR] 입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.\n");
    }
}

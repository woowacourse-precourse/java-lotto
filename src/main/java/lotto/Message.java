package lotto;

public class Message {
    private static final String ERROR_HEADER = "[ERROR]";
    private static final String DELIMITER = " ";
    private static final String LOTTO_SIZE_ERROR_MESSAGE_BODY = "로또 번호의 개수는 6이여야 합니다.\n";
    private static final String LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE_BODY = "로또 번호는 1부터 45 사이의 숫자여야 합니다.\n";
    private static final String LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE_BODY = "로또 번호에 중복된 숫자가 존재합니다.\n";

    public static String getLottoSizeErrorMessage()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_SIZE_ERROR_MESSAGE_BODY);
    }
    public static String getLottoNumberOutOfBoundErrorMessageBody()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_NUMBER_OUT_OF_BOUND_ERROR_MESSAGE_BODY);
    }
    public static String getLottoNumberDuplicationErrorMessage()
    {
        return String.join(DELIMITER,ERROR_HEADER,LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE_BODY);
    }

}

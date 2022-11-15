package lotto.exception.lotto;

public class LottoNumberCountException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 갯수는 6개로 이루어져야만 합니다. : %d";

    public LottoNumberCountException(int numberCnt){
        super(String.format(ERROR_MESSAGE,numberCnt));
    }
}

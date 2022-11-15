package lotto.utils;

public class LottoNumberException extends RuntimeException{
    public LottoNumberException(){
        super("[ERROR] 6개 숫자를 입력해주세요 (','로 구분하며 중복불가)");
    }
}

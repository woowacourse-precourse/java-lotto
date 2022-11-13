package lotto.domain.model.request;

public class LottoNumberRequest {

    private final int number;

    public LottoNumberRequest(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
}

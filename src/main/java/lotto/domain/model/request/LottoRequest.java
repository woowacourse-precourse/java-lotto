package lotto.domain.model.request;

public class LottoRequest {

    private final String numbers;

    public LottoRequest(String numbers) {
        this.numbers = numbers;
    }

    public String getNumbers() {
        return numbers;
    }
    
}

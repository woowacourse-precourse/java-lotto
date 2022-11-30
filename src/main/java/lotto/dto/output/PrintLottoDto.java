package lotto.dto.output;

import java.util.List;

public class PrintLottoDto {

    private final List<String> purchaseLottos;

    public PrintLottoDto(List<String> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public List<String> getPurchaseLottos() {
        return purchaseLottos;
    }

    public int getPurchaseAmount() {
        return purchaseLottos.size();
    }
}

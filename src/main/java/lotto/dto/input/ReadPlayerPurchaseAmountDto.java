package lotto.dto.input;

import java.math.BigDecimal;

public class ReadPlayerPurchaseAmountDto {

    private final BigDecimal playerPurchaseAmount;

    public ReadPlayerPurchaseAmountDto(BigDecimal playerPurchaseAmount) {
        this.playerPurchaseAmount = playerPurchaseAmount;
    }

    public BigDecimal getPlayerPurchaseAmount() {
        return playerPurchaseAmount;
    }
}

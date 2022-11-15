package lotto.mvc.dto.input;

public final class InputPurchaseAmountDto {

    private final String inputPurchaseAmount;

    public InputPurchaseAmountDto(String inputPurchaseAmount) {
        this.inputPurchaseAmount = inputPurchaseAmount;
    }

    public String getInputPurchaseAmount() {
        return inputPurchaseAmount;
    }
}

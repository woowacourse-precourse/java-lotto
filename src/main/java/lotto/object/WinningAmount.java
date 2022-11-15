package lotto.object;

public class WinningAmount {
    private final WinningResult result;
    private Integer amount;

    public WinningAmount(WinningResult result) {
        this.result = result;
        this.amount = 0;
    }

    public void addAmount() {
        this.amount += 1;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPrize() {
        return result.getPrize() * amount;
    }

    public Integer getResultPrize() {
        return result.getPrize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(result.toString());
        sb.append(String.format(" - %d개", amount));

        return sb.toString();
    }
}

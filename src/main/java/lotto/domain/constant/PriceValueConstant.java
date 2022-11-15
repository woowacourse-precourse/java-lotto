package lotto.domain.constant;

public enum PriceValueConstant {
    LOTTO(1_000L),
    ;
    final Long price;

    PriceValueConstant(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

}

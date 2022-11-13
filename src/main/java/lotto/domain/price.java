package lotto.domain;

public enum price {
    Five_thousand(5000), Fifty_thousand(50000), A_million_and_a_half_million(1500000), Thirty_million(30000000), Two_billion(2000000000);

    private final int value;
    price(int value) { this.value = value; }
    public  int getValue() {return value;}
}

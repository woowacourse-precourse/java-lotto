package lotto.model;

public enum Winning {
    FIRST(2_000_000_000, "1등"),
    SECOND(30_000_000, "2등"),
    THIRD(1_500_000, "3등"),
    FOURTH(50_000, "4등"),
    FIFTH(5_000, "5등");


    Winning(int prize, String detail) {
    }
}

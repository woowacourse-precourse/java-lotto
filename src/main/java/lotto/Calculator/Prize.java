package lotto.Calculator;

public enum Prize {
    FIFTH_PLACE_PRIZE(5000),
    FOURTH_PLACE_PRIZE(5000),
    THIRD_PLACE_PRIZE(1500000),
    SECOND_PLACE_PRIZE(30000000),
    FIRST_PLACE_PRIZE(2000000000);

    public Integer prize;
    Prize(Integer prize){
        this.prize = prize;
    }

}

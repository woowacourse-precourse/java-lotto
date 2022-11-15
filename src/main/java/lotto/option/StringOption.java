package lotto.option;

public enum StringOption {

    FIFTH_PRICE_TEXT("5,000원"),
    FOURTH_PRICE_TEXT("50,000원"),
    THIRD_PRICE_TEXT("1,500,000원"),
    SECOND_PRICE_TEXT("30,000,000원"),
    FIRST_PRICE_TEXT("2,000,000,000원");
    public String option;
    StringOption(String option){this.option = option;}

}

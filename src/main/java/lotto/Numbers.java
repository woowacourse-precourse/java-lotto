package lotto;

public enum Numbers {
    Win("^\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}$"),
    Bonus("^[1-9]{1,2}$");
    public final String regex;

    Numbers(String regex){
        this.regex=regex;
    }
}

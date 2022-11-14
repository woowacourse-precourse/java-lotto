package util;

public enum WinNum {
    Three("5000"),
    Four("50000"),
    Five("1500000"),
    Bonus("30000000"),
    Six("2000000000"),

    Nothing("0")
    ;
    private final String label;

    WinNum(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}

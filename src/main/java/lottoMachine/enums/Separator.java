package lottoMachine.enums;

public enum Separator {
    WINNING_NUMBER_SEPARATOR(",");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        return separator;
    }
}

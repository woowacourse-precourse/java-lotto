package lotto;

public class Error {
    private static boolean isError = false;

    public Error() {
    }

    public Error(boolean isError) {
        Error.isError = isError;
    }

    public void check() {
        if (isError) {
            throw new IllegalArgumentException();
        }
    }
}

package lotto.exception;

public class NonNumberFailure extends IllegalArgumentException{
    public NonNumberFailure(String s) {
        super(s);
    }
}

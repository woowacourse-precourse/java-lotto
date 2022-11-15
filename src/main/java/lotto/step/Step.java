package lotto.step;

public interface Step {

    void execute();

    Step next();

    boolean executable();
}

package lotto;

import lotto.system.Program;

public class Application {

    private static final Program program = new Program();

    public static void main(String[] args) {
        program.startProgram();
        program.winningProgram();
        program.statisticsProgram();
    }
}

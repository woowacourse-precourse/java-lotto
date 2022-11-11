package io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputKeyboard implements Input{

    @Override
    public String getInput() {
        return readLine();
    }
}

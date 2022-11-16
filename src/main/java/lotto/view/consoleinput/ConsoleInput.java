package lotto.view.consoleinput;

import lotto.exception.UnexpectedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private final BufferedReader userInputReader =
            new BufferedReader(new InputStreamReader(System.in));

    public String readInput() {
        try {
            return userInputReader.readLine();
        } catch (IOException error) {
            throw new UnexpectedException();
        }
    }
}

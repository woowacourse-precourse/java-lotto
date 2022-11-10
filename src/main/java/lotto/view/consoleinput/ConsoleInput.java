package lotto.view.consoleinput;

import lotto.constant.ErrorMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    private final BufferedReader userInputReader =
            new BufferedReader(new InputStreamReader(System.in));

    public Integer readNumber() {
        try {
            return Integer.parseInt(userInputReader.readLine());
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        } catch (IOException error) {
            throw new IllegalArgumentException(ErrorMessage.UNEXPECTED.getMessage());
        }
    }
}

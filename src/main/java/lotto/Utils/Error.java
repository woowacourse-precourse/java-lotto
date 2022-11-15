package lotto.Utils;

import java.util.NoSuchElementException;

public class Error {
    public static void generate(Message message) {
        try {
            throw new IllegalArgumentException(message.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }
}

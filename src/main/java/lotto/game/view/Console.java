package lotto.game.view;

import lotto.util.ErrorMessage;
import lotto.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public interface Console {
    class Out {
        public static void print(Message message) {
            System.out.print(message.text());
        }

        public static void printLine(Message message) {
            System.out.println(message.text());
        }

        public static void print(String text) {
            System.out.print(text);
        }

        public static void printLine(String text) {
            System.out.println(text);
        }

        public static void printError(ErrorMessage errorMessage) {
            System.out.println(errorMessage.text());
        }
    }

    class In {
        public static String inputLine() {
            String message = readLine();
            validate(message);
            return message;
        }

        private static void validate(String message) {
            Validator.validateNotNull(message);
            Validator.validateNotEmpty(message);
        }
    }
}

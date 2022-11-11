package lotto.view;

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

        public static void print(String message) {
            System.out.print(message);
        }

        public static void printLine(String message) {
            System.out.println(message);
        }
    }

    class In {
        public static String inputLine() {
            String message = readLine();
            validate(message);
            return message;
        }

        private static void validate(String message) {
            if (!Validator.isNotNull(message)
                    || !Validator.isNotEmpty(message)) {
                throw new IllegalArgumentException();
            }
        }
    }
}

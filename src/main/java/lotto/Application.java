package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printLottoQuantity(int quantity) {

        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumberList) {

        System.out.print("[");

        for (int i = 0; i < lottoNumberList.size() - 1; i++) {
            System.out.print(lottoNumberList.get(i) + ", ");
        }

        System.out.println(lottoNumberList.get(lottoNumberList.size() - 1) + "]");
    }

    public static void printWinningNumbersInputBox() {

        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputBox() {

        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printCashInputBox() {

        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printErrorAboutRange() {

        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void printErrorAboutInteger() {

        System.out.println("[ERROR] 입력된 값이 숫자가 아닙니다.");
    }

    public static void printErrorAboutDuplicate() {

        System.out.println("[ERROR] 중복된 번호가 존재합니다.");
    }

    public static void printErrorAboutDivisionByThousand() {

        System.out.println("[ERROR] 입력된 값이 1,000으로 나누어 떨어지지 않습니다.");
    }

    public static void printErrorAboutForm() {

        System.out.println("[ERROR] 올바른 형식으로 입력해야 합니다.");
    }

    public static void printErrorAboutSize() {

        System.out.println("[ERROR] 알맞은 개수의 숫자를 입력해야 합니다.");
    }

    public static void validateCashIsInteger(String input) {

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) < 48 || input.charAt(i) > 57) {

                printErrorAboutInteger();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateCashIsDividedThousand(String input) {

        if (input.length() < 4) {

            printErrorAboutDivisionByThousand();
            throw new IllegalArgumentException();
        }

        for (int i = input.length() - 4; i < input.length(); i++) {

            if (input.charAt(i) != 48) {

                printErrorAboutDivisionByThousand();
                throw new IllegalArgumentException();
            }
        }
    }
}

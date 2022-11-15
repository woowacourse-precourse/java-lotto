package lotto.view;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getWinner() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}

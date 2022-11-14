package lotto.view;

public class Message {

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void countLotto(int countLotto) {
        System.out.printf("%n%d개를 구매했습니다.%n", countLotto);
    }
}

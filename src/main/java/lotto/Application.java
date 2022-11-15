package lotto;

import lotto.Service.Service;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Service service = new Service();
        service.startService();
    }
}

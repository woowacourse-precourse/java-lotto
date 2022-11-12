package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Comment comment = new Comment();
        Service service = new Service();

        comment.printPayment();
        int payment = service.stringToInt(Console.readLine());

        int numberOfLottery = service.numberOfLottery(payment);
    }


}

package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MakeLottoNumber makeLottoNumber = new MakeLottoNumber();
        makeLottoNumber.returnLottoNumber();

        System.out.println("구입금액을 입력해 주세요.");
        Cash cash = new Cash();
        cash.Input();

    }
}

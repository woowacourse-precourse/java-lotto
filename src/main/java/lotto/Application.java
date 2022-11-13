package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        int purchasedValue;
        String userInputLotto;
        String[] userInputLottoTmp;
        int[] userInputLottoNumber = new int[6];
        int userInputBonusNumber;

        System.out.println("구입금액을 입력해 주세요.");
        purchasedValue = scanner.nextInt();

        if (purchasedValue % 1000 != 0){
            System.out.println("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        int lottoCount = purchasedValue / 1000;
        System.out.println("\n" +lottoCount+ "개를 구매했습니다.");

        // TODO: 로또 구매 갯수만큼 로또 생성

        System.out.println("당첨 번호를 입력해 주세요.");
        userInputLotto = scanner.nextLine();
        userInputLottoTmp = userInputLotto.split(",");
        for (int i = 0; i < userInputLottoTmp.length; i++){
            userInputLottoNumber[i] = Integer.parseInt(userInputLottoTmp[i]);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        userInputBonusNumber = scanner.nextInt();

        // TODO: 사용자가 입력한 당첨 번호, 보너스 번호와 생성한 당첨 번호 비교

        // TODO: 비교값에 따라 당첨 내역 출력

        // TODO: 수익률 계산 및 출력
    }
}

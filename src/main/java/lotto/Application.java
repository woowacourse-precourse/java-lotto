package lotto;

import java.util.Scanner;

public class Application {
    public static void makeLottoNumber(int lottoCount){
        int[][] lottoArray = new int[lottoCount][6];

        for(int i = 0; i < lottoCount; i++){
            for(int j = 0; j < lottoArray[i].length; j++){
                int number = (int)(Math.random() * 45) + 1;
                lottoArray[i][j] = number;

                for(int k = 0; k < j; k++){
                    if (lottoArray[i][k] == number){
                        j--;
                        break;
                    }
                }
            }

            System.out.print("[");
            for(int j = 0; j < lottoArray[i].length - 1; j++){
                System.out.print(lottoArray[i][j] + ", ");
            }
            System.out.println(lottoArray[i][5] + "]");
        }
    }

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

        makeLottoNumber(lottoCount);

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

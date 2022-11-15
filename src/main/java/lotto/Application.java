/*
    구현 순서

    1. 출력 : "구입금액을 입력해 주세요.\n"
    2. 입력 : [ 로또를 구입하기 위한 금액 ]
    2-1. 예외처리
        1)  입력 받은 금액 % 1000 != 0일 때
        2)  입력 받은 금액이 음수일 때
        3)  아무것도 입력받지 않았을 때
    2-2. 예외 발생 시
        1)  IllegalArgumentException 발생
        2)  출력 : "[ERROR]\n"
        3)  프로세스 종료
    2-3. 예외 사항 없음
        1) 출력 : "입력 받은 금액 / 1000개를 구매했습니다."
    3. 입력 받은 금액 / 1000 개의 랜덤 로또 배열 생성
    3-1. 1~45, 중복없는 난수 6개를 배열에 삽입
        1) 배열 내부의 6개 숫자 오름차순 sort

    4. 출력 : "당첨 번호를 입력해주세요.\n"
    5. 입력 : [ ,를 기준으로 한 6개의 숫자 ]
    5-1. 배열삽입
        1) ,를 기준으로 배열에 숫자를 삽입
    5-2. 예외처리
        1) 중복 숫자
        2) 입력 숫자의 개수
        3) 1-45의 범위를 벗어난 숫자 혹은 공백
    5-3. 예외 발생 처리
    6. 출력 : "보너스 번호를 입력해 주세요.\n"
    7. 입력 : [ 보너스 번호 1개 ]
    7-1. 예외처리
        1) 1-45 범위 혹은 공백
        2) 당첨 번호 중복 검사
    7-2. 예외 발생 처리

    8.로또연산
    8-1. 구현
        1) 당첨번호 i, n 번째 복권배열 j 비교
        2) i와 j가 같을때마다 count++
        3) 검사가 끝났을때, count = 5 라면 보너스 번호 검사
            3-1) count = 5, 보너스 번호가 있으면 bean = 1
    9. 등수, 금액 계산
        1) if ( bean = 0 )
            1-1) if ( count < 2 ) = 미당첨
            1-2) else if ( count == 3 ) 5등
            1-3) else if ( count == 4 ) 4등
            1-4) else if ( count == 5 ) 3등
            1-5) else if ( count == 6 ) 1등
        2) else 2등
        3) 총액 합산
            1) if 당첨 없을시 0원, 0%
            2) else
                2-1) 수익률 = (double)당첨금 / (double)구입금 * 100.0

    10. 출력 : "당첨 통계\n---\n"
        1) : 출력 : "3개 일치 (5,000원) - rank5 개\n
                    4개 일치 (50,000원) - rank4 개\n
                    5개 일치 (1,500,000원) - rank3 개\n
                    5개 일치, 보너스 볼 일치 (30,000,000원) - rank2 개\n
                    6개 일치 (2,000,000,000원) - rank1 개\n"
        2) : 출력 : "총 수익률은 " + String.format("%.2f", 수익률) + "%입니다.\n"
 */

package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        int Money = scanner.nextInt();
//        if (Money % 1000 != 0)
//            throw new IllegalArgumentException("Error\n");

        int lotto = Money / 1000;
        System.out.println("\n" + lotto + "개를 구매하였습니다.\n---");

        int arrLotto[][] = new int[lotto][6];
        for (int i = 0; i < lotto; i++) {
            for (int j = 0; j < 6; j++) {
                int num = (int) (Math.random() * 45) + 1;
                arrLotto[i][j] = num;
                for (int k = 0; k < j; k++) {
                    if (arrLotto[i][j] == arrLotto[i][k]) {
                        j--;
                        break;
                    }
                }
            }

            Arrays.sort(arrLotto[i]);
        }

        for (int a = 0; a < lotto; a++) {
            System.out.print("[");
            for (int b = 0; b < 6; b++) {
                System.out.print(arrLotto[a][b]);
                if (b != 5)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        String Numbers = scanner.next();

        String Number[] = Numbers.split(",");
        int Numbertmp[] = new int[6];
        for (int i = 0; i < 6; i++) {
            Numbertmp[i] = Integer.parseInt(Number[i]);
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = scanner.nextInt();

        System.out.println("\n당첨 통계\n---");

        int result = 0;
        int rank5 = 0;
        int rank4 = 0;
        int rank3 = 0;
        int rank2 = 0;
        int rank1 = 0;
        for (int i = 0; i < lotto; i++) {
            int count = 0;
            boolean bean = false;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (arrLotto[i][j] == Numbertmp[k]) {
                        count++;
                    }
                }
            }
            if (count == 5) {
                for (int j = 0; j < 6; j++) {
                    if (arrLotto[i][j] == bonus)
                        bean = true;
                }
            }
            if (count == 3) {
                result += 5000;
                rank3++;
            }
            else if (count == 4) {
                result += 50000;
                rank4++;
            }
            else if (count == 5) {
                if (bean = true) {
                    result += 30000000;
                    rank2++;
                }
                else {
                    result += 1500000;
                    rank3++;
                }
            }
            else if (count == 6) {
                result += 2000000000;
                rank1++;
            }
        }
        System.out.println("3개 일치 (5,000원) - " + rank5 +"개");
        System.out.println("4개 일치 (50,000원) - " + rank4 +"개");
        System.out.println("5개 일치 (1,500,000원) - " + rank3 +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank2 +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank1 +"개");
        System.out.println("총 수익률은 " + String.format("%.2f", (double)result / (double) Money) + "%입니다.\n");

    }
}

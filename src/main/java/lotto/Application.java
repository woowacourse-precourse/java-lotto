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

        
    }


}

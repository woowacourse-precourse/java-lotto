자바 Lotto Program

***역할***
LottoManager - 메인 로직 담당, Flow Controller
ScreenPrinter - 입 출력 담당 객체
Lotto - Domain
LottoResult - 최종 결과 계산 및 데이터 이동용 Dto
PrizeMoney - 등수별 상금 저장 Enumeration

**흐름**
main 함수
    ScreenPrinter 생성
    LottoManager 생성 및 ScreenPrinter 주입
    LottoManager - playLotto(메인 로직) 실행
    
    playLotto
        1. 금액 입력(inputMoney())
        2. 로또 자동 발행(publishLotto())
        3. 발행된 로또 출력(showReceipt())
        4. 당첨 번호 입력(inputPrizeNums())
        5. 보너스 번호 입력(inputBonusNum())
        6. 최종 결과 출력(showResult())
        
**예외상황**
1. 입력된 숫자가 범위 밖 ( 1 ~ 45 )
2. 입력 값이 숫자가 아닌 경우
3. 중복된 숫자가 입력(보너스 번호까지 포함)
4. 입력 개수 초과
--문제 요구사항은 IllegalArgumentException이었으나 NsTest 내부의 runException 메서드에 NoSuchElementException이 있으므로
모든 예외는 NoSuchElementException 발생

미션 - 로또
===
---
### 기능 목록
1. **UI**
    + PurchaseView
        - 구입금액 입력 메시지 출력
        - 구입 금액 input 받기
    + LotteryView
        - 구매 금액에 따른 로또 번호 출력
    + NumberView
        - interface
        - 메시지 출력 함수
        - input 받는 함수
    + WinningNumberView
        - implements NumberView
        - 당첨 번호 입력 메시지 출력
        - 당첨 번호 input 받기.
    + BonusNumberView
        - implements NumberView
        - 보너스 입력 메시지 출력
        - 보너스 번호 input 받기
    + ResultView
        - 당첨 통계 종합 출력
        - 3개 일치 출력
        - 4개 일치 출력
        - 5개 일치 출력
        - 5개 일치, 보너스볼 일치 출력
        - 6개 일치 출력
        - 수익률 출력
2. **Controller**
    + Domain 통신
        - purchase 금액 PurchaseService에 전달
        - 당첨 번호 WinningNumberService에 전달
    + UI 통신
        - 생성된 로또 번호 LotteryView에 전달
        - 당첨결과 ResultView에 전달
    + 전체 게임 동작 관리
        - 전체 게임 cycle 관리
3. **Domain**
    + PurchaseService
        - 로또 구매 처리
        - List<List<Integer>> 로 로또 티켓 생성하는 기능
        - 각 로또가 중복되지 않게 처리하는 기능
        - [예외] 입력값이 숫자인지 확인
        - [예외] 음수가 아닌 지 확인
        - [예외] 1000의 배수인지 확인
    + WinningNumberService
        - Controller에서 받은 당첨번호 처리
        - Stringparser를 통해 당첨 번호 파싱
        - Controller에서 받은 보너스 번호 처리
        - [예외] 1~45 내의 범위에 있는 숫자인지 확인
        - [예외] 숫자가 아닌 경우 확인
        - [예외] 보너스 포함 중복이 없는지 확인
        - [예외] 6개의 숫자인지 확인
    + AllNumbersCalculateService
        - 모든 당첨 통계 처리
        - EachNumberCalcalateService를 통해 각 번호 처리
        - 수익률 계산
    + EachNumberCalculateService
        - 각 로또 당첨 처리
        - 상위 당첨으로 처리
        - 보너스 번호가 필요한 지 확인

4. **utils**
    + stringParser
        - 쉼표 단위로 input 자르기
        - 정수 List로 반환
        - [예외] 쉼표로 구별되지 않는 등 양식에 맞지 않는 지 확인
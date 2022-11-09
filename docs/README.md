## 도메인 기능 목록

- [ ] 금액에 해당하는 로또의 개수를 계산한다. -Amount#calculateAvailable()
    - 예외상황
        - 1,000원으로 나누어 떨어지지 않는 경우
        - 1,000원 이하의 금액(0원)
- [ ] 1부터 45까지의 서로 다른 임의의 수 6개를 추출할 수 있다 -NumberGenerate#createRandom()
- [ ] 당첨 번호(6자리)와 구매한 로또 번호(6자리)를 비교해 등수를 알 수 있다. -Rank#determine()
    - [ ] 몇 개의 숫자가 같은지 확인한다. - Lotto#checkNumbers()
    - [ ] 보너스 번호를 포함하는지 판단한다. Lotto#checkBonus()
- [ ] 당첨 등수 당 개수를 확인한다. -Rank#countWinCards()
- [ ] 수익률을 계산한다. - Amount#calculateEarningRate()
    - 구입 금액 / 총 당첨 금액 * 100

## enum 목록

- [ ] 등수와 당첨 금액 -Place#FIRST,SECOND, THIRD, FOURTH, FIFTH
    - n개 일치(금액)
- [ ] 안내 문자열 -InputGuide#PURCHASING_AMOUNT, WINNING_NUMBER, BONUS_NUMBER
- [ ] 에러 문구 -ErrorGuide#

## UI 기능 목록

- [ ] 구입 금액을 입력 받는다.
    - [ ] 구입 금액 입력 안내 메시지를 출력한다.
    - [ ] 발핸한 로또 수량 및 번호를 오름차순으로 정렬해 출력한다.


- [ ] 당첨 번호를 쉼표(,)를 기준으로 구분해 입력 받는다. -winning number
    - [ ] 당첨 번호 입력 안내 메시지를 출력한다.


- [ ] 보너스 번호를 입력 받는다.
    - [ ] 보너스 번호 입력 안내 메시지를 출력한다.
    - [ ] 당첨 내역을 출력한다.
    - [ ] 수익률을 소수점 첫째 자리까지 출력한다.

## 예외 상황

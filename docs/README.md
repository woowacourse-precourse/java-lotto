# 미션 - 로또 

## 🔍 ️게임 소개
* 로또 구입 금액에 해당하는 자동 로또를 발행하여 발행 개수와 각 로또 번호를 출력한다. 
* 당첨번호와 보너스 번호를 입력하면 당첨 통계와 수익률을 출력하는 게임이다.
---
## 🧀기능 목록
- 로또를 구입한다. LottoSeller
  - [x] 로또 구입 금액을 입력받는다. LottoSeller#getPayAmount()
  - [x] 입력 받은 금액에 따른 로또 개수를 구한다. LottoSeller#countTicket()
    - [x] 천원단위 아닐 경우 예외처리한다.
- [x] 입력 받은 금액 만큼의 로또를 랜덤으로 발행한다. NumberGenerator#generateNumbers()
- [x] 당첨번호와 보너스 번호를 입력받는다. LottoDrawing#getWinningNumber(),getBonusNumber()
  - [x] 각 번호는 쉼표(,)를 기준으로 구분
  - [x] 당첨번호 오름차순 아닐수도 있음
- [x] 구매번호와 당첨번호를 비교하여 일치하는 숫자가 몇개인지 구한다. NumberChecker#compareResult()
- [ ] 수익률을 구한다. LottoResult#getRateOfReturn()
  - [ ] LottoResult enum 을 이용하여 수익률을 계산한다. 
- [x] Lotto#
  - [x] 오름차순 정렬한다. Lotto#sort()
  - [x] Lotto#validate()
    - [x] 6자리 숫자
    - [x] 중복되지 않는 숫자
    - [x] 1~45의 숫자
---

### 로또 구입 - 2 (출력)
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
1. 발행한 로또 수량 및 번호를 출력한다.
- ex. "n개를 구매했습니다. [.....][.....]"
- 로또 번호는 오름차순으로 정렬하여 보여준다.
2. 당첨 내역을 출력한다.
3. 수익률을 출력한다.
- 소수점 둘째 자리에서 반올림한다. 

# 🎖️ 3주차 과제
- 클래스 분리로 Model, Controller, View로 나누어서 기능 구현.
- 데이터 관련 검증은 Model에서, 입력 관련 검증은 Input에서, 컨트롤러에서는 검증하지 않는다.
- 테스트 코드는 도메인 로직에 단위 테스트로 구현. 

---
## 🚀 구현 기능 목록

- Model 
  - [x] Lotto
  - [x] Ticket (구입 금액에 맞는 로또 발행)
  - [x] PurchaseAmount
  - [x] WinningLotto
  - [x] BonusNumber
  - [x] Prize (Enum 으로 구현)
  - [x] LottoResult
  - [x] ProfitRate


- Controller
  - [x] 구입 금액 입력
  - [x] Ticket 출력
  - [x] 당첨 번호 입력
  - [x] 보너스 번호 입력
  - [x] 당첨 통계 출력
  - [x] 수익률 출력


- View
  - [x] Ticket 정보 출력
  - [x] LottoResult 당첨 통계 출력
  - [x] ProfitRate 수익률 출력


- Input
  - [x] 구입 금액 입력
  - [x] 당첨 번호 입력
  - [x] 보너스 번호 입력
    
---
## ⭐️ 검증 목록
- Lotto
  - [x] 로또 번호의 개수가 6개가 맞는지 검증
  - [x] 로또 번호들이 중복이 없는지 검증
  

- PurchaseAmount
  - [x] 1000원 단위로 나누어 떨어지는지 검증


- WinningLotto
  - [x] 보너스 번호가 당첨 번호와 중복되는지 검증
  

- BonusNumber
  - [x] 보너스 번호가 1~45사이에 숫자가 맞는지 검증


- Input
  - [x] 구입 금액이 정수인지 확인
  - [x] 당첨 번호가 쉼표(,)를 기준으로 올바른 형식인지 확인
  - [x] 당첨 번호가 중복되는지 검증
  - [x] 각 번호가 1~45사이에 숫자가 맞는지 검증
  - [x] 당첨 번호 개수가 6개인지 확인
  - [x] 보너스 번호가 정수인지 확인

---
## 🚨 에러 출력 목록
- [x] PurchaseAmount
    - [x] 숫자가 아닌 경우 - InputPurchaseAmount
    - [x] 1000원 보다 작은 경우 - PurchaseAmount
    - [x] 1000원으로 나누어 떨어지지 않는 경우 - PurchaseAmount


- [x] WinningLotto
    - [x] 쉼표(,)를 기준으로 올바른 형식이 아닌경우 - InputWinningNumbers
    - [x] 개수가 6개가 넘는 경우 - InputWinningNumbers
    - [x] 각 숫자의 범위가 1~45가 아닌 경우 -InputWinningNumbers
    - [x] 번호들이 중복이 있는 경우 - InputWinningNumbers


- [x] 보너스 번호
    - [x] 숫자가 아닌경우 - InputBonusNumber
    - [x] 숫자의 범위가 1~45가 아닌 경우 - BonusNumber
    - [x] 해당 번호가 당첨 번호에 있는 경우 - WinningLotto

---
## ✔️ 단위 테스트 목록
- Lotto
  - [x] 로또 번호가 6개가 넘어가면 예외 발생
  - [x] 로또 번호에 중복된 숫자가 있으면 예외 발생
  - [x] 로또 번호가 1~45 사이의 숫자가 아니면 예외 발생
  - [x] 오름차순으로 출력되는지 테스트


- Ticket
  - [x] 구입 금액만큼 로또가 발행됐는지 테스트


- PurchaseAmount
  - [x] 구입 금액이 1000원 이하이면 예외 발생
  - [x] 구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외 발생


- WinningLotto
  - [x] 보너스 숫자가 당첨 번호과 중복되면 예외 발생


- BonusNumber
  - [ ] 보너스 번호가 1~45 사이의 숫자가 아니면 예외 발생


- LottoResult
  - [ ] 당첨 내역이 일치하는지 테스트
  - [ ] 총 상금이 당첨 내역 상금의 합계와 같은지 테스트


- ProfitRate
  - [ ] 수익률 계산이 정확한지 테스트
  - [ ] 수익률이 소수점 둘째 자리에서 반올림 하는지 테스트
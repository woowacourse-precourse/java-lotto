3주차 미션 - 로또
=========
---
## 로또 기능 구현 목록
**1. 로또 구입** Controller#buyLotto
- [x] 로또 구입 금액 입력 Purchase
  - [x] 1000원 단위로 구매금액 유효성 검사 Purchase#validatePurchase()
- [ ] 당첨 번호 입력 Lotto
  - [ ] 당첨 번호 입력 유효성 검사 (중복되지 않는 숫자 6개) Lotto#validate()
- [ ] 보너스 번호 입력 Lotto#getLottoBonusNumber
  - [ ] 보너스 번호 입력 유효성 검사 Lotto#validateBonusNumber

**2. 로또 발행 및 출력** Controller#publishLotto
- [ ] 로또 발행 User#getUserLotto
- [ ] 발행된 로또 오름차순 출력 User#printUserLotto

**3. 로또 당첨 , 수익률 확인** Controller#resultLotto
- [ ] 당첨 내역 출력 User#printWinningResult
- [ ] 수익률 출력 User#printWinningRatio

---
## 기능 요구 사항
1. 로또를 구매한다.
2. 발행한 로또 수량 및 번호를 확인 한다.
3. 당첨 내역을 출력한다.
4. 수익률을 출력한다.

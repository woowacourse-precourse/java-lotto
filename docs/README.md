# 기능 목록 ver 1.1
<hr>

### 예외처리 상황
- 구입금액
  - 입력 값이 숫자가 아닌 경우 - UserLotto
  - 구입금액이 1000 으로 나누어 떨어지지 않는 경우 - UserLotto


- 당첨 번호
  - 입력 값이 숫자가 아닌 경우 - Lotto
  - 번호가 1 ~ 45 사이가 아닌 경우 - Lotto
  - 번호가 6개가 아닌 경우 - Lotto


- 보너스 번호
  - 입력 값이 숫자가 아닌 경우 - Bonus
  - 번호가 1 ~ 45 사이가 아닌 경우 - Bonus
  - 번호가 1개가 아닌 경우 - Bonus
  - 번호가 당첨 번호랑 중복되는 경우 - Bonus

<hr>

### 기능 구현 목록

- [ ] 당첨 정보 enum 생성
- [ ] 출력 기능
  - [ ] 구입 금액 입력받기 문구 출력 - Guide
  - [ ] 구매 개수 출력 - Guide
  - [ ] 구매한 복권 번호 목록 출력 - UserLotto
  - [ ] 당첨 번호 입력받기 문구 출력 - Guide
  - [ ] 보너스 번호 입력받기 문구 출력 - Guide
  - [ ] 당첨 통계 출력 - UserLotto
- [ ] 입력 기능
  - [ ] 구입 금액 입력받기 - UserLotto
  - [ ] 당첨 번호 입력받기 - PrizeNumber
  - [ ] 보너스 번호 입력받기 - Bonus


- [ ] 구매 개수 계산 - UserLotto
- [ ] 구매 리스트 생성(랜덤) - NumberGenerator
- [ ] 몇 개의 번호가 당첨 번호와 일치하는지 확인 - Judgment
- [ ] 보너스 번호 일치 여부 확인 - Judgment
- [ ] 수익률 계산 - UserLotto
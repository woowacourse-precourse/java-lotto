## 🛠 MVC에 따른 기능 목록

---

**Domain**

- User
  - [x]  로또 구입 금액 입력 받기

    [예외]

    - 1000원으로 나누어 떨어지지x 경우
    - 숫자가 아닌 경우
  - [ ]  로또 번호 생성
  - [ ]  Getter

- Lotto
  - [ ]  로또 번호 생성

    [예외]

    - 1~45 범위x
    - 숫자x
    - 6개 x
    - 중복x
  - [ ]  번호 검증
- Prize
  - [ ]  당첨 결과
  - Enum 사용
  - [ ]  Getter

- LuckyNumber
  - [ ]  당첨 번호 입력
  - [ ]  보너스 번호 입력
  - [ ]  Getter


**View**

- [ ]  구매 수량 출력
- [ ]  로또 번호 출력
  - 오름차순
- [ ]  당첨 내역 출력
- [ ]  수익률 출력

**Exception**

- [x]  에러 문구 출력
  - Enum적용
- [x]  Getter

**Controller**

- [ ]  run

**Service**

- [ ]  로또 번호 비교
- [ ]  수익률 계산
- [ ]
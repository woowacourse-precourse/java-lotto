# 기능 목록 ver 1.4.5
<hr>

### 예외처리 상황
- 구입금액
  - [x] 입력 값이 숫자가 아닌 경우 - UserLotto
  - [x] 구입금액이 1000 으로 나누어 떨어지지 않는 경우 - UserLotto


- 당첨 번호
  - [x] 입력 값이 숫자가 아닌 경우 - Lotto
  - [x] 번호가 1 ~ 45 사이가 아닌 경우 - Lotto
  - [x] 번호가 6개가 아닌 경우 - Lotto
  - [x] 중복 번호가 당첨 번호 내에 존재하는 경우 - Lotto

- 보너스 번호
  - [x] 입력 값이 숫자가 아닌 경우 - Bonus
  - [x] 번호가 1 ~ 45 사이가 아닌 경우 - Bonus
  - [x] 번호가 당첨 번호랑 중복되는 경우 - Bonus

<hr>

### 기능 구현 목록

- [x] 당첨 정보 enum 생성 - Prize
  - [x] 일치하는 번호 개수로 당첨 정보 반환 - Prize
  - [x] 당첨금 접근자 - Prize


- [ ] 출력 기능
  - [x] 구입 금액 입력받기 문구 출력 - Guide
  - [x] 구매 개수 출력 - Guide
  - [x] 구매한 복권 번호 목록 출력 - Guide
  - [x] 당첨 번호 입력받기 문구 출력 - Guide
  - [x] 보너스 번호 입력받기 문구 출력 - Guide
  - [x] 정수에다가 구두점 표시 후 반환 - Preprocessor
  - [x] 당첨 통계 출력 - Guide
    - [x] 당첨 통계 메시지 생성 - Guide
  - [x] int 형식에 대한 String 형변환 - Preprocessor
  - [x] 수익률 출력 - Guide
    - [x] 소수점 n번째 자리에서 반올림 - Preprocessor


- [x] 입력 기능
  - [x] 입력받은 구입금액에 대한 생성자 - UserLotto
    - [x] String 형식에 대한 int 형변환 - Preprocessor
  - [x] 입력받은 당첨 번호에 대한 생성자 - Lotto
    - [x] String 형식인 당첨 번호를 콤마로 구분하여 List\<String>로 변환 - Preprocessor
    - [x] List\<String> 을 List\<Integer>로 변환 - Preprocessor
  - [x] 입력받은 보너스 번호에 대한 생성자 - Bonus
    - [x] String 형식에 대한 int 형변환 - Preprocessor


- [x] 로또 번호 접근자 - Lotto
- [x] 보너스 번호 접근자 - Bonus
- [x] 구매 개수 계산 - UserLotto
- [x] 구매 리스트 생성(랜덤) - NumberGenerator
- [x] 몇 개의 번호가 당첨 번호와 일치하는지 확인 - Judgment
- [x] 보너스 번호 일치 여부 확인 - Judgment
- [x] 당첨결과 리스트 생성(당첨 통계) - UserLotto
- [x] 수익률 계산 - UserLotto
# 🚀 기능 요구 사항
## Buyer
- [x] 로또 구입 금액 저장
- [x] 1000원 단위인지 확인, 예외시 Exception

## Buyer Generate
- [x] 로또 구입 금액 ask 출력
- [x] 로또 구입 금액 입력
- [x] 입력된 구입 금액으로 Buyer 클래스 생성 

## Lotto Random Peek
- [x] 금액에 맞는 횟수만큼 복권발행
- [x] 1~45 사이의 중복되지 않는 숫자 6개 뽑기
- [x] 발행된 랜덤복권 반환

## Lotto Random Peek Output
- [ ] 발행된 랜덤복권 출력 

## Lotto
- [x] 랜덤 번호 6자리, 보너스 번호 유효한지 확인 후 저장
- [x] 랜덤 번호 갯수 확인, 예외시 Exception 발생
- [x] 랜덤 번호 1~45 내의 숫자인지 확인, 예외시 Exception
- [x] 랜덤 번호 중복 확인, 예외시 Exception

## Win Lotto
- [x] 당첨 번호와 보너스 번호 유효한지 확인 후 저장
- [x] 당첨 번호, 보너스 번호 중복 확인, 예외시 Exception

## Win Lotto Generate
- [ ] 당첨 번호 ask 출력
- [ ] 당첨 번호 입력
- [ ] 당첨 번호 "," 기준으로 스플릿
- [ ] 보너스 번호 ask 출력
- [ ] 보너스 번호 입력
- [ ] 당첨번호 6자리 인지 확인 예외시 Exception
- [ ] 당첨번호 모두 숫자인지 확인 예외시 Exception
- [ ] 보너스 번호 숫자인지 확인 예외시 Exception
- [ ] 입력된 당첨번호, 보너스 번호로 Win Lotto 클래스 생성

## Statistics
- [ ] 당첨 번호,보너스 번호와 발행된 복권 비교 일치된 숫자 카운트
- [ ] 로또 구입금액과 수입금 비교로 수익률 계산

## Statistics Output
- [ ] 당첨내역과 수익률 출력




# 🚀 추가된 프로그래밍 요구 사항
1. 메서드의 길이 15라인 넘어가지 않게 구현
2. else 쓰지 않기
3. Java Enum 적용(주관적인 이해 static final 변수 -> enum)
4. 도메인 로직에 단위 테스트 구현
5. 메인 로직과 UI 로직은 분리해서 구현
6. 제공된 Lotto 클래스 활용해 구현
7. Lotto에 매개변수가 없는 생성자 추가 안됨
8. numbers의 접근자인 private 변경 불가
9. Lotto에 필드 추가 안됨
10. Lotto의 패키지는 변경 가능

# 🚀 추가된 과제 진행 요구 사항
1. git의 커밋단위는 현 파일의 기능목록 단위로 추가
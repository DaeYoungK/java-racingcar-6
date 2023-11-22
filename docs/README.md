### 구현해야할 기능

1. view
   1. InputView
   - [X] 사용자에게 입력받는 기능 구현
   2. OutputView
   - [X] 사용자에게 보여줄 문구 출력 기능 구현

2. controller
   1. GameController
   - [X] 핵심 기능을 호출하여 게임을 진행하는 기능 구현

3. domain
   1. Car
   - [X] 전진 횟수와 로그를 가지는 객체 생성 기능 구현
   - [X] 랜덤 숫자를 받아 전진 or 멈춤 기능 구현
   2. CarStore
   - [X] 경주하는 자동차들을 모아두는 기능 구현
   3. CalculateManager
   - [X] 단일 우승자를 구하는 기능 구현
   - [X] 공동 우승자를 구하는 기능 구현
   4. AdvanceLog
   - [X] 결과 출력용 메시지를 생성하는 기능 구현
   5. ErrorMessage
   - [ ] 예외 사항 발생 시 출력할 메시지 구현

4. validation
   1. Validator
   - [ ] 경주할 자동차 이름이 쉼표로 정리되어 있는지 검증 기능 구현
   - [ ] 자동차 이름이 5자 이하인지 검증 기능 구현
   
5. utility
   1. RandomNumber
   - [X] 1 ~ 9 까지 랜덤 숫자를 구하는 기능 구현
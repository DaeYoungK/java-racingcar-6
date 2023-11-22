package racingcar.controller;

import racingcar.domain.AdvanceLog;
import racingcar.domain.CalculateManager;
import racingcar.domain.Car;
import racingcar.domain.CarStore;
import racingcar.utility.RandomNumber;
import racingcar.validation.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static racingcar.utility.RetryLogic.*;

public class GameController {

    private final CarStore carStore;
    private final InputView inputView;
    private final OutputView outputView;
    private final CalculateManager calculateManager;
    private final AdvanceLog advanceLog;
    private final Validator validator;

    public GameController() {
        carStore = new CarStore();
        inputView = new InputView();
        outputView = new OutputView();
        calculateManager = new CalculateManager();
        advanceLog = new AdvanceLog();
        validator = new Validator();
    }

    public void proceed() {
        setCars();
        start();
        winners();
    }

    private void winners() {
        carStore.getCars();
        List<String> winners = calculateManager.getWinners(carStore.getCars());
        String finalWinners = advanceLog.winners(winners);
        outputView.printFinalWinner(finalWinners);
    }

    private void start() {
        AtomicInteger racingCount = new AtomicInteger();
        retry(() -> racingCount.set(validator.validCount(inputView.readCount())));

        outputView.printStartMessage();
        for (int i = 0; i < racingCount.get(); i++) {
            outputView.printResultMessage(makeLog());
        }
    }

    private String makeLog() {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = carStore.getCars();
        List<Car> moveCars = moveCar(cars);
        moveCars.stream().forEach(car -> sb.append(advanceLog.make(car.getCarName(), car.getLevel())));

        return sb.toString();
    }

    private List<Car> moveCar(List<Car> cars) {
        RandomNumber randomNumber = new RandomNumber();
        cars.stream().forEach(car -> {
            car.move(randomNumber.make());
        });
        return cars;
    }

    private void setCars() {
        AtomicReference<List<String>> carNames = new AtomicReference<>();
        retry(() -> carNames.set(validator.validName(calculateManager.makeList(inputView.readCarName()))));
        addCars(carNames.get());
    }

    private void addCars(List<String> carNames) {
        carNames.stream().forEach(name -> carStore.add(name));
    }
}

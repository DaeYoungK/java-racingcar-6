package racingcar.controller;

import racingcar.domain.AdvanceLog;
import racingcar.domain.CalculateManager;
import racingcar.domain.Car;
import racingcar.domain.CarStore;
import racingcar.utility.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final CarStore carStore;
    private final InputView inputView;
    private final OutputView outputView;
    private final CalculateManager calculateManager;
    private final AdvanceLog advanceLog;

    public GameController() {
        carStore = new CarStore();
        inputView = new InputView();
        outputView = new OutputView();
        calculateManager = new CalculateManager();
        advanceLog = new AdvanceLog();
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
        int racingCount = Integer.parseInt(inputView.readCount());

        outputView.printStartMessage();
        for (int i = 0; i < racingCount; i++) {
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
        List<String> carNames = calculateManager.makeList(inputView.readCarName());
        addCars(carNames);
    }

    private void addCars(List<String> carNames) {
        carNames.stream().forEach(name -> carStore.add(name));
    }
}

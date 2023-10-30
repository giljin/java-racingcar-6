package racingcar;

import java.util.Objects;

public class Car {
    private static final String DISTANCE_ICON = "-";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVING_FORWARD_VALUE = 4;
    private final String name;
    private int distance;

    Car(String name) {
        validateNullOrEmpty(name);
        validateLengthLimit(name);
        this.name = name;
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    private void validateLengthLimit(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void go(RandomNumber randomNumber) {
        if (randomNumber.getNumber() >= MOVING_FORWARD_VALUE) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name + " : " + DISTANCE_ICON.repeat(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}

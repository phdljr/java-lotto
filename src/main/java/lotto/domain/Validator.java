package lotto.domain;

import lotto.config.LottoConfig;
import lotto.message.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    public static void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_COUNT);
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATED);
        }
    }

    public static void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConfig.RANGE_MIN || number > LottoConfig.RANGE_MAX) {
                throw new IllegalArgumentException(ExceptionMessage.ERROR_RANGE);
            }
        }
    }
}
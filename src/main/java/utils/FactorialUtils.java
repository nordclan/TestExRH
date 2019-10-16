package utils;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Класс для работы с факториалами
 * @author Хисметов Радик
 */
public class FactorialUtils {
    /**
     * Метод для подсчета факториала значения
     * @param num значение
     * @return возвращает факториал значения
     * @throws Exception
     */
    public static long calcFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Non positive value");
        }

        if (num < 2) {
            return 1;
        }

        return IntStream.range(2, num + 1).reduce(1, (res, value) -> res * value);
    }

    /**
     * Метод для расчета формулы m!/(r! * (m-r)!)
     * @param m значение m для расчета по формуле
     * @param r значение r для расчета по формуле
     * @return возвращает значение, расчитанное по формуле
     * @throws Exception
     */
    public static long calcF(int m, int r) {
        int a = Integer.min(m - r, r);
        int b = Integer.max(m - r, r);

        //подсчет факториала для минимального значения из 3-х
        long aFactorial = calcFactorial(a);
        //подсчет факториала следующего значения, домножив первый найденный факториал на недостоющие значения
        long bFactorial = LongStream.range(a + 1, b + 1).reduce(aFactorial, (res, value) -> res * value);
        //подсчет факториала следующего значения, домножив предыдущий факториал на недостоющие значения
        long mFactorial = LongStream.range(b + 1, m + 1).reduce(bFactorial, (res, value) -> res * value);

        return mFactorial / (aFactorial * bFactorial);
    }
}

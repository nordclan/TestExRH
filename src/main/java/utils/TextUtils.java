package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для работы с текстом
 * @author Хисметов Радик
 */
public class TextUtils {
    /**
     * Метод подсчитывает число вхождений каждого фрагмента из заданного текста, разбитого на фрагменты с помощью delimeter
     * @param text исходный текст
     * @param delimiter разделитель (может быть reg exp)
     * @return возвращает упорядоченный словарь по убыванию числа вхождений каждого фрагмента
     */
    public static Map<String, Long> getValuesByInnerCount(String text, String delimiter) {
        if (StringUtils.isEmpty(text) || StringUtils.isEmpty(delimiter)) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        Map<String, Long> wordsMap = Stream.of(text.split(delimiter))
                .map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LinkedHashMap<String, Long> result = wordsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return result;
    }
}

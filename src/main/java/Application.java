import utils.FactorialUtils;
import utils.NumberStringifierUtils;
import utils.TextUtils;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("task 1: " + NumberStringifierUtils.stringifyRange(1,100, Arrays.asList(2,7)));

        System.out.println("task 2: " + FactorialUtils.calcF(6,2));

        String s = "На вход программе подается литературный текст. Программа должна вывести список слов, встречающихся" +
                " в тексте, в котором для каждого слова указывается количество вхождений этого слова в текст, а слова " +
                "выводятся в порядке убывания частоты вхождения.";
        //подсчитаем кол-во вхождений каждого слова в тексте, для чего используем regexp: [^A-Za-zА-Яа-я]+
        System.out.println("task 3: " + TextUtils.getValuesByInnerCount(s, "[^A-Za-zА-Яа-я]+"));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int max = scanner.nextInt();
        logger.log("Создаём и наполняем список ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int num = random.nextInt(max);
            list.add(num);
        }
        System.out.print("Вот случайный список: ");
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации ");
        System.out.print("Введите порог для фильтра: ");
        int treshold = scanner.nextInt();
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> res = filter.filterOut(list);
        logger.log("Прошло фильтр " + res.size() + " элемента из " + list.size());
        logger.log("Выводим результат на экран ");
        System.out.print("Отфильтрованный список: ");
        for (int y : res) {
            System.out.print(y + " ");
        }
        System.out.println();
        logger.log("Завершаем программу");
    }
}

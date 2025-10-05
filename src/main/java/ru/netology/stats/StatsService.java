package ru.netology.stats;

public class StatsService {

    // 1. Сумма всех продаж
    public long calculateSum(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    // 2. Средняя сумма продаж в месяц
    public double calculateAverage(long[] sales) {
        if (sales.length == 0) {
            return 0.0; // Обработка случая пустого массива
        }
        long sum = calculateSum(sales);
        return (double) sum / sales.length;
    }

    // 3. Номер месяца, в котором был пик продаж (последний по условию)
    public int findMaxMonth(long[] sales) {
        int maxMonth = 0; // индекс месяца с максимальными продажами
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // Используем >= для поиска *последнего* месяца
                maxMonth = i;
            }
        }
        return maxMonth + 1; // Месяца нумеруются с 1
    }

    // 4. Номер месяца, в котором был минимум продаж (последний по условию)
    public int findMinMonth(long[] sales) {
        int minMonth = 0; // индекс месяца с минимальными продажами
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // Используем <= для поиска *последнего* месяца
                minMonth = i;
            }
        }
        return minMonth + 1; // Месяца нумеруются с 1
    }

    // 5. Количество месяцев, в которых продажи были ниже среднего
    public int countMonthsBelowAverage(long[] sales) {
        double average = calculateAverage(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }
        return count;
    }

    // 6. Количество месяцев, в которых продажи были выше среднего
    public int countMonthsAboveAverage(long[] sales) {
        double average = calculateAverage(sales);
        int count = 0;
        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }
        return count;
    }
}
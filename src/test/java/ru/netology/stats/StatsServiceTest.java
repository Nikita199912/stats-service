package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatsServiceTest {

    StatsService service;
    long[] sales;

    @BeforeEach // Этот метод будет запускаться перед каждым тестом
    void setUp() {
        service = new StatsService();
        sales = new long[]{8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    }

    @Test
    void shouldCalculateSum() {
        long expectedSum = 8 + 15 + 13 + 15 + 17 + 20 + 19 + 20 + 7 + 14 + 14 + 18; // 180
        long actualSum = service.calculateSum(sales);
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldCalculateAverage() {
        // Сумма 180, 12 месяцев -> 180 / 12 = 15.0
        double expectedAverage = 15.0;
        double actualAverage = service.calculateAverage(sales);
        Assertions.assertEquals(expectedAverage, actualAverage, 0.001); // 0.001 - допустимая погрешность для double
    }

    @Test
    void shouldFindMaxMonth() {
        // Максимальные продажи 20, в месяцах 6 и 8. По условию нужен *последний*, т.е. 8.
        int expectedMonth = 8;
        int actualMonth = service.findMaxMonth(sales);
        Assertions.assertEquals(expectedMonth, actualMonth);
    }

    @Test
    void shouldFindMinMonth() {
        // Минимальные продажи 7, в месяце 9.
        int expectedMonth = 9;
        int actualMonth = service.findMinMonth(sales);
        Assertions.assertEquals(expectedMonth, actualMonth);
    }

    @Test
    void shouldCountMonthsBelowAverage() {
        // Среднее = 15.0
        // [8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]
        // Месяцы с продажами < 15: 8, 13, 7, 14, 14. Всего 5 месяцев.
        int expectedCount = 5;
        int actualCount = service.countMonthsBelowAverage(sales);
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    void shouldCountMonthsAboveAverage() {
        // Среднее = 15.0
        // [8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]
        // Месяцы с продажами > 15: 17, 20, 19, 20, 18. Всего 5 месяцев.
        int expectedCount = 5;
        int actualCount = service.countMonthsAboveAverage(sales);
        Assertions.assertEquals(expectedCount, actualCount);
    }
}
package com.example;

public class Main {
    public static void main(String[] args) {


        // ПОДГОТОВКА ДАННЫХ (Задание 7 и 8)


        // Задание 7: Создаем объекты класса Payment (платежи)
        // Параметры: ФИО, день, месяц, год, сумма в копейках
        Payment p1 = new Payment("Иванов Иван", 12, 5, 2023, 150050); // 1500 руб 50 коп
        Payment p2 = new Payment("Петров Петр", 15, 6, 2023, 50000);  // 500 руб 00 коп
        Payment p3 = new Payment("Ильин Илья", 20, 7, 2023, 9999);    // 99 руб 99 коп

        Payment[] pays = { p1, p2, p3 };

        // Задание 8: Создаем объект FinanceReport (отчет)
        // Параметры: массив платежей, ФИО автора, день, месяц, год создания отчета
        FinanceReport report = new FinanceReport(pays, "Бухгалтер Сидоров", 25, 8, 2023);



        // ПРОВЕРКА ЗАДАНИЯ 9 (Метод toString в FinanceReport)

        System.out.println("=== ЗАДАНИЕ 9: ВЫВОД ИСХОДНОГО ОТЧЕТА ===");
        // Вызывается метод toString() класса FinanceReport.
        // Он должен красиво отформатировать данные с помощью String.format.
        System.out.println(report);



        // ПРОВЕРКА ЗАДАНИЯ 10 (Конструктор копирования)

        System.out.println("\n=== ЗАДАНИЕ 10: ТЕСТ ГЛУБОКОГО КОПИРОВАНИЯ ===");
        // Создаем копию отчета с помощью конструктора копирования
        FinanceReport copy = new FinanceReport(report);

        // Меняем сумму первого платежа ТОЛЬКО В КОПИИ
        copy.getPayment(0).setAmount(999999);

        // Проверяем: в оригинале сумма должна остаться прежней (150050 коп.)
        System.out.println("Сумма в ОРИГИНАЛЕ (должна быть 150050): " + report.getPayment(0).getAmount());
        // А в копии сумма должна измениться (стать 999999 коп.)
        System.out.println("Сумма в КОПИИ     (должна быть 999999): " + copy.getPayment(0).getAmount());



        // ПРОВЕРКА ЗАДАНИЯ 11 (Методы FinanceReportProcessor)


        // --- Задание 11.1: Платежи людей, чья фамилия начинается на 'И' ---
        System.out.println("\n=== ЗАДАНИЕ 11.1: ПЛАТЕЖИ НА БУКВУ 'И' ===");
        FinanceReport filteredByName = FinanceReportProcessor.getPaymentsBySurnameStart(report, 'И');
        System.out.println(filteredByName);

        // --- Задание 11.2: Платежи, размер которых меньше 1000 рублей (100000 копеек) ---
        System.out.println("\n=== ЗАДАНИЕ 11.2: ПЛАТЕЖИ МЕНЬШЕ 1000 РУБЛЕЙ ===");
        FinanceReport filteredByAmount = FinanceReportProcessor.getPaymentsLessThan(report, 100000);
        System.out.println(filteredByAmount);


    }
}
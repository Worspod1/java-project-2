package com.example;

import java.util.Arrays;

public class FinanceReport {
    private Payment[] payments;
    private String author;
    private int creationDay;
    private int creationMonth;
    private int creationYear;

    public FinanceReport(Payment[] payments, String author, int creationDay, int creationMonth, int creationYear) {
        this.payments = payments;
        this.author = author;
        this.creationDay = creationDay;
        this.creationMonth = creationMonth;
        this.creationYear = creationYear;
    }

    // Конструктор копирования (Задание 10)
    public FinanceReport(FinanceReport other) {
        this.author = other.author;
        this.creationDay = other.creationDay;
        this.creationMonth = other.creationMonth;
        this.creationYear = other.creationYear;

        // Глубокое копирование массива, чтобы изменения в копии не затрагивали оригинал
        this.payments = new Payment[other.payments.length];
        for (int i = 0; i < other.payments.length; i++) {
            Payment p = other.payments[i];
            this.payments[i] = new Payment(p.getFullName(), p.getDay(), p.getMonth(), p.getYear(), p.getAmount());
        }
    }

    // Получение количества платежей
    public int getPaymentsCount() {
        return payments.length;
    }

    // Доступ к i-му платежу (на чтение)
    public Payment getPayment(int index) {
        if (index >= 0 && index < payments.length) {
            return payments[index];
        }
        throw new IndexOutOfBoundsException("Неверный индекс платежа");
    }

    // Доступ к i-му платежу (на запись)
    public void setPayment(int index, Payment payment) {
        if (index >= 0 && index < payments.length) {
            this.payments[index] = payment;
        } else {
            throw new IndexOutOfBoundsException("Неверный индекс платежа");
        }
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    // Геттеры для даты создания отчета (могут пригодиться)
    public int getCreationDay() { return creationDay; }
    public int getCreationMonth() { return creationMonth; }
    public int getCreationYear() { return creationYear; }

    // Задание 9: toString с String.format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Автор: %s, дата: %d.%d.%d, Платежи: [\n",
                author, creationDay, creationMonth, creationYear));

        for (Payment p : payments) {
            sb.append(p.toString()).append("\n");
        }

        sb.append("]]");
        return sb.toString();
    }
}
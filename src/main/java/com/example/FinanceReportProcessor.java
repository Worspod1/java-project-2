package com.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {

    // 1) Платежи людей, чья фамилия начинается на указанный символ
    public static FinanceReport getPaymentsBySurnameStart(FinanceReport report, char startChar) {
        List<Payment> filtered = new ArrayList<>();

        for (int i = 0; i < report.getPaymentsCount(); i++) {
            Payment p = report.getPayment(i);
            // Проверяем, что имя не пустое и первый символ совпадает (без учета регистра)
            if (p.getFullName() != null && !p.getFullName().isEmpty()) {
                char firstLetter = Character.toUpperCase(p.getFullName().charAt(0));
                char targetLetter = Character.toUpperCase(startChar);

                if (firstLetter == targetLetter) {
                    filtered.add(p);
                }
            }
        }

        Payment[] newPayments = filtered.toArray(new Payment[0]);
        return new FinanceReport(newPayments, report.getAuthor(),
                report.getCreationDay(), report.getCreationMonth(), report.getCreationYear());
    }

    // 2) Платежи, размер которых меньше заданной величины
    public static FinanceReport getPaymentsLessThan(FinanceReport report, int maxAmount) {
        List<Payment> filtered = new ArrayList<>();

        for (int i = 0; i < report.getPaymentsCount(); i++) {
            Payment p = report.getPayment(i);
            if (p.getAmount() < maxAmount) {
                filtered.add(p);
            }
        }

        Payment[] newPayments = filtered.toArray(new Payment[0]);
        return new FinanceReport(newPayments, report.getAuthor(),
                report.getCreationDay(), report.getCreationMonth(), report.getCreationYear());
    }
}
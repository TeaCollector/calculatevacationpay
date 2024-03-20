package ru.alex.calculatevacationpay.service.impl;

import org.springframework.stereotype.Service;
import ru.alex.calculatevacationpay.service.VacationService;
import ru.alex.calculatevacationpay.web.dto.request.VacationDataRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationServiceImpl implements VacationService {

    @Override
    public BigDecimal calculateVacationPay(VacationDataRequest vacationDataRequest) {
        int vacationDate = vacationDataRequest.getVacationDay();
        double averageSalary = vacationDataRequest.getSalary();

        double averageDayInMonth = 29.3;
        double vacationPay = averageSalary / averageDayInMonth * vacationDate;

        return BigDecimal.valueOf(vacationPay).setScale(2, RoundingMode.HALF_UP);
    }
}
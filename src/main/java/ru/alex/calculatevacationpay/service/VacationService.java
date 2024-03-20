package ru.alex.calculatevacationpay.service;

import ru.alex.calculatevacationpay.web.dto.request.VacationDataRequest;

import java.math.BigDecimal;

public interface VacationService {
    BigDecimal calculateVacationPay(VacationDataRequest vacationDataRequest);
}

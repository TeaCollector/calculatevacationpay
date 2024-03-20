package ru.alex.calculatevacationpay.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.alex.calculatevacationpay.web.dto.request.VacationDataRequest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class VacationServiceImplTest {

    @Autowired
    VacationServiceImpl vacationService;

    @Test
    @DisplayName("Returns correct result while calculation vacation pay.")
    void correctResult() {
        VacationDataRequest dataRequest = VacationDataRequest.builder()
                .salary(100000D)
                .vacationDay(28)
                .build();

        BigDecimal vacationPay = vacationService.calculateVacationPay(dataRequest);

        assertEquals(95563.14, vacationPay.doubleValue());
    }

    @Test
    @DisplayName("Returns incorrect result while calculation vacation pay.")
    void inCorrectResult() {
        VacationDataRequest dataRequest = VacationDataRequest.builder()
                .salary(120000D)
                .vacationDay(14)
                .build();

        BigDecimal vacationPay = vacationService.calculateVacationPay(dataRequest);

        assertNotEquals(4059.34, vacationPay.doubleValue());
    }

    @Test
    @DisplayName("Returns correct result while passes zero.")
    void correctResultIfZero() {
        VacationDataRequest dataRequest = VacationDataRequest.builder()
                .salary(120000D)
                .vacationDay(0)
                .build();

        BigDecimal vacationPay = vacationService.calculateVacationPay(dataRequest);

        assertEquals(0, vacationPay.doubleValue());
    }
}
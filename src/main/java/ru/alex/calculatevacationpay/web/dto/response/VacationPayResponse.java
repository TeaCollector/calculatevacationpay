package ru.alex.calculatevacationpay.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class VacationPayResponse {
    private BigDecimal vacationPay;
}

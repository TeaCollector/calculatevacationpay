package ru.alex.calculatevacationpay.web.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@Builder
public class VacationDataRequest {

    @Positive
    @NotNull(message = "Salary must not be null")
    private Double salary;
    @Positive
    @NotNull(message = "Vacation day must not be null")
    private Integer vacationDay;
}

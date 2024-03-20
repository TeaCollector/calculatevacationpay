package ru.alex.calculatevacationpay.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.calculatevacationpay.service.VacationService;
import ru.alex.calculatevacationpay.web.dto.request.VacationDataRequest;
import ru.alex.calculatevacationpay.web.dto.response.VacationPayResponse;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/calculate")
public class VacationPayController {

    private final VacationService service;

    @GetMapping
    public ResponseEntity<VacationPayResponse> calculate(@RequestBody @Valid VacationDataRequest vacationDataRequest) {

        BigDecimal vacationPay = service.calculateVacationPay(vacationDataRequest);

        VacationPayResponse vacationPayResponse = VacationPayResponse
                .builder()
                .vacationPay(vacationPay)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacationPayResponse);
    }
}
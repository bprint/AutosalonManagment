package com.talas.autosalonmanagment.controller;

import com.talas.autosalonmanagment.dto.reference.ChargingDTO;
import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.services.ChargingsService;
import com.talas.autosalonmanagment.services.impl.ChargingsServiceImpl;
import com.talas.autosalonmanagment.util.CarErrorResponse;
import com.talas.autosalonmanagment.util.CarException;
import com.talas.autosalonmanagment.util.ChargingValidator;
import static com.talas.autosalonmanagment.util.ErrorsUtil.returnErrorsToClient;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/bc")
public class ChargingsController {

    private final ModelMapper modelMapper;
    private final ChargingValidator chargingValidator;
    private final ChargingsServiceImpl chargingsService;

    @GetMapping
    public List<ChargingDTO> getChargings() {

        return chargingsService.findAll().stream().map(this::convertToChargingDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid ChargingDTO chargingDTO,
                                          BindingResult bindingResult) {
        Charging chargingToAdd = convertToCharging(chargingDTO);

        chargingValidator.validate(chargingToAdd, bindingResult);
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        chargingsService.add(chargingToAdd);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleException(CarException e) {
        CarErrorResponse response = new CarErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Charging convertToCharging(ChargingDTO chargingDTO) {
        return modelMapper.map(chargingDTO, Charging.class);
    }

    private ChargingDTO convertToChargingDTO(Charging charging) {
        return modelMapper.map(charging, ChargingDTO.class);
    }
}

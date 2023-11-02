package com.talas.autosalonmanagment.controller;

import com.talas.autosalonmanagment.dto.ICECarDTO;
import com.talas.autosalonmanagment.model.ICECar;
import com.talas.autosalonmanagment.services.ICECarsService;
import com.talas.autosalonmanagment.util.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.talas.autosalonmanagment.util.ErrorsUtil.returnErrorsToClient;

@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class ICECarsController {
    private final ICECarsService icecarsService;
    private final ModelMapper modelMapper;
    private final ICECarValidator icecarValidator;

    @GetMapping
    public List<ICECarDTO> getICECars() {
        return icecarsService.findAll().stream().map(this::convertToICECarDTO).collect(Collectors.toList());
    }

    @GetMapping("/{vin}")
    public ICECarDTO getICECar(@PathVariable("vin") String vin) {
        return convertToICECarDTO(icecarsService.findOne(vin));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody ICECarDTO icecarDTO, BindingResult bindingResult) {
        ICECar icecarToAdd = convertToICECar(icecarDTO);
        icecarValidator.validate(icecarToAdd, bindingResult);

        if (bindingResult.hasErrors()) {
            returnErrorsToClient(bindingResult);
        }

        icecarsService.save(convertToICECar(icecarDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleException(NotFoundException e) {
        CarErrorResponse response = new CarErrorResponse(
                "Car with this ID wasn't found",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<CarErrorResponse> handleException(CarException e) {
        CarErrorResponse response = new CarErrorResponse(
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ICECar convertToICECar(ICECarDTO icecarDTO) {
        return modelMapper.map(icecarDTO, ICECar.class);
    }

    private ICECarDTO convertToICECarDTO(ICECar icecar) {
        return modelMapper.map(icecar, ICECarDTO.class);
    }
}

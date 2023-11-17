package com.talas.autosalonmanagment.controller;

import com.talas.autosalonmanagment.dto.reference.ChargingDTO;
import com.talas.autosalonmanagment.dto.reference.DefectDTO;
import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.model.reference.Defect;
import com.talas.autosalonmanagment.services.DefectsService;
import com.talas.autosalonmanagment.util.DefectValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.talas.autosalonmanagment.util.ErrorsUtil.returnErrorsToClient;

@RestController
@AllArgsConstructor
@RequestMapping("/defects")
public class DefectsController {

    private final ModelMapper modelMapper;
    private final DefectValidator defectValidator;
    private final DefectsService defectsService;

    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid DefectDTO defectDTO,
                                          BindingResult bindingResult) {
        Defect defectToAdd = convertToDefect(defectDTO);

        defectValidator.validate(defectToAdd, bindingResult);
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        defectsService.add(defectToAdd);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Defect convertToDefect(DefectDTO defectDTO) {
        return modelMapper.map(defectDTO, Defect.class);
    }

    private DefectDTO convertToDefectDTO(Defect defect) {
        return modelMapper.map(defect, DefectDTO.class);
    }
}

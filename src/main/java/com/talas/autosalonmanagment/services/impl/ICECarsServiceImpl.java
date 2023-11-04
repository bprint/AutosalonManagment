package com.talas.autosalonmanagment.services.impl;

import com.talas.autosalonmanagment.model.ICECar;
import com.talas.autosalonmanagment.repositories.ICECarsRepository;
import com.talas.autosalonmanagment.services.ICECarsService;
import com.talas.autosalonmanagment.util.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ICECarsServiceImpl implements ICECarsService {

    private final ICECarsRepository icecarsRepository;
    private final ModelMapper modelMapper;

    public List<ICECar> findAll() {
        return icecarsRepository.findAll();
    }

    public ICECar findOne(String vin) {
        Optional<ICECar> foundCar = icecarsRepository.findByVin(vin);
        return foundCar.orElseThrow(NotFoundException::new);
    }

    public Optional<ICECar> findByVin(String vin) {
        return icecarsRepository.findByVin(vin);
    }

    @Transactional
    public void save(ICECar icecar) {
        icecarsRepository.save(icecar);
    }

    @Transactional
    public void update(String vin, String changedVIN, ICECar updatedICECar) {
        Optional<ICECar> existingCarOptional = icecarsRepository.findByVin(vin);
        ICECar existingCar = existingCarOptional.get();
        Long id = existingCar.getId();
        modelMapper.map(updatedICECar, existingCar);
        existingCar.setId(id);
        existingCar.setVin(changedVIN);

        icecarsRepository.save(existingCar);
    }

    @Transactional
    public void delete(String vin) {
        icecarsRepository.delete(icecarsRepository.findByVin(vin).get());
    }
}

package com.labour.service;

import com.labour.models.Labour;
import com.labour.repository.LabourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabourService {

    @Autowired
    private LabourRepository labourRepository;

    public Labour addLabour(Labour labour) {
        return labourRepository.save(labour);
    }

    public List<Labour> getLabourByLocation(String location) {
        return labourRepository.findByLocationIgnoreCase(location);
    }

    public List<Labour> getAllLabours() {
        return labourRepository.findAll();
    }

    public Optional<Labour> getLabourById(Long id) {
        return labourRepository.findById(id);
    }

}


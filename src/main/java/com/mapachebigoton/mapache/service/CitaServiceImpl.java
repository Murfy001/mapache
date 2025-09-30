package com.mapachebigoton.mapache.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mapachebigoton.mapache.dto.CitaRequest;
import com.mapachebigoton.mapache.dto.CitaResponse;
import com.mapachebigoton.mapache.mapper.CitaMapper;

import com.mapachebigoton.mapache.model.Cita;

import com.mapachebigoton.mapache.repository.CitaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService{
    private final CitaRepository repository;

    @Override
    public List<CitaResponse> findAll() {
        return repository.findAll().stream()
                .map(CitaMapper::toResponse)
                .toList();
    }

    @Override
    public CitaResponse findById(Integer idCita) {
        Cita cita = repository.findById(idCita)
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada: " + idCita));
        return CitaMapper.toResponse(cita);
    }

    @Override
    public CitaResponse create(CitaRequest request) {
        Cita saved = repository.save(CitaMapper.toEntity(request));
        return CitaMapper.toResponse(saved);
    }

    @Override
    public CitaResponse update(Integer idCita, CitaRequest dto) {
        Cita existing = repository.findById(idCita)
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrado: " + idCita));
        CitaMapper.copyToEntity(dto, existing);
        Cita saved = repository.save(existing);
        return CitaMapper.toResponse(saved);
    }

    @Override
    public void delete(Integer idCita) {
        if (!repository.existsById(idCita)) {
            throw new EntityNotFoundException("Cita no encontrado: " + idCita);
        }
        repository.deleteById(idCita);
    }
    
}

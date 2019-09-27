package ru.kasyan.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.kasyan.example.model.Place;

public interface PlacesRepository extends JpaRepository<Place, Long> {
}

package ru.kasyan.example.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kasyan.example.model.Place;
import ru.kasyan.example.repository.PlacesRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlacesController {

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping("/places")
    public List<Place> getAllPlaces() {
        return placesRepository.findAll();
    }

    @GetMapping("/places/{vk_user_id}")
    public ResponseEntity<List<Place>> getEmployeeById(@PathVariable(value = "vk_user_id") int vkUserId) {
        List<Place> list = placesRepository.findAll().stream().filter(s -> s.getUserVkId() == vkUserId).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/save")
    public String createEmployee(@RequestParam("place") String placeStr, @RequestParam(value = "img", required = false) MultipartFile file) {
        Place place = new Place();
        String userId = "";

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(placeStr);
            place.setCity(actualObj.get("city").asText());
            place.setCountry(actualObj.get("country").asText());
            place.setDescription(actualObj.get("description").asText());
            place.setLatitude(actualObj.get("latitude").asDouble());
            place.setLongitude(actualObj.get("longitude").asDouble());
            place.setPhotoName(file.getOriginalFilename());
            place.setVk_link(actualObj.get("vk_link").asText());
            place.setUserVkId(actualObj.get("userVkId").asInt());
            place.setFileNameInFileSystem(file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(userId);
        savePhotoOnDisk(file);
        placesRepository.save(place);

        return "ok";
    }


    @GetMapping("/places/countries/{vk_user_id}")
    public ResponseEntity<Map<String, Integer>> getEmployeeCountCountriesById(@PathVariable(value = "vk_user_id") int vkUserId) {
        Map<String, Integer> counryNameMap = new HashMap<>();

        getUsersPlaces(vkUserId).forEach(el -> {
            if (counryNameMap.containsKey(el)) {
                counryNameMap.put(el.getCountry(), counryNameMap.get(el) + 1);
            } else {
                counryNameMap.put(el.getCountry(), 1);
            }
        });

        return ResponseEntity.ok().body(counryNameMap);
    }


    // TODO: 2019-09-27 нужно доделать
//    @GetMapping("/places/{country}/{vk_user_id}")
//    public ResponseEntity<Map<String, Integer>> getEmployeeCountCountriesById(@PathVariable(value = "vk_user_id") int vkUserId) {
//        Map<String, Integer> counryNameMap = new HashMap<>();
//
//        getUsersPlaces(vkUserId).forEach(el -> {
//            if (counryNameMap.containsKey(el)) {
//                counryNameMap.put(el.getCountry(), counryNameMap.get(el) + 1);
//            } else {
//                counryNameMap.put(el.getCountry(), 1);
//            }
//        });
//
//        return ResponseEntity.ok().body(counryNameMap);
//    }


    private List<Place> getUsersPlaces(int vkUserId) {
        return placesRepository.findAll().stream().filter(s -> s.getUserVkId() == vkUserId).collect(Collectors.toList());

    }

    private void savePhotoOnDisk(MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("У нас какие то проблемы с файлом" + file.getOriginalFilename());
            return;
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("img//" + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("Файл сохранился " + file.getOriginalFilename());

        } catch (IOException e) {

        }
    }

}
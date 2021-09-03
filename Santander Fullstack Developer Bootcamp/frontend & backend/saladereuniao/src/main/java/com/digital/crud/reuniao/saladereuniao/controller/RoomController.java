package com.digital.crud.reuniao.saladereuniao.controller;

import com.digital.crud.reuniao.saladereuniao.repository.RoomRepository;
import com.digital.crud.reuniao.saladereuniao.model.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.digital.crud.reuniao.saladereuniao.exception.ResourceNotFoundException;
import com.digital.crud.reuniao.saladereuniao.exception.GlobalExceptionHandler;
import com.digital.crud.reuniao.saladereuniao.exception.ErrorDetails;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> findAll() {
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting room not found:: " + id));

        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public Room create(@Valid @RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateById(@PathVariable(value = "id") Long id, @Valid @RequestBody Room roomDetails)
            throws ResourceNotFoundException {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting room not found for this id:: " + id));

        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());

        final Room updatedRoom = this.roomRepository.save(room);

        return ResponseEntity.ok().body(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meeting room not found for this id:: " + id));

        this.roomRepository.delete(room);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}

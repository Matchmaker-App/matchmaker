package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meet")
public class MeetController {
    private final MeetServiceImplementation meetServiceImplementation;

    @GetMapping("/")
    public List<Meet> getMeets() {
        return meetServiceImplementation.getMeets();
    }

    @GetMapping("/{id}")
    public Meet getMeet(@PathVariable(name = "id") Long id) {
        return meetServiceImplementation.getMeetById(id);
    }

    @PutMapping("/")
    public void putMeet(@RequestBody Meet meetRequest) {
        meetServiceImplementation.createMeet(meetRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteMeet(@PathVariable(name = "id") Long id) {
        meetServiceImplementation.deleteMeetById(id);
    }

}

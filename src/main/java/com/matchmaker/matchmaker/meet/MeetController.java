package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meet")
public class MeetController {
    //service injection
    private final MeetServiceImplementation meetServiceImplementation;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<MeetDTO> getMeets() {
        return meetServiceImplementation.getMeets();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Meet getMeet(@PathVariable(name = "id") Long id) throws Exception {
        return meetServiceImplementation.getMeetById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    public void postMeet(@RequestBody Meet meetRequest,@RequestParam Long userId,@RequestParam Long gameId) throws Exception {
        meetServiceImplementation.createMeet(meetRequest,userId,gameId);
    }

    @PutMapping("/")
    public void putMeet(@RequestBody Meet newMeetRequest, @PathVariable Long id) {
        meetServiceImplementation.updateMeet(newMeetRequest,id);
    }

    @DeleteMapping("/{id}")
    public void deleteMeet(@PathVariable(name = "id") Long id) {
        meetServiceImplementation.deleteMeetById(id);
    }

    @PutMapping("/{meetId}/users/{userId}")
    public void addUserToMeet(@PathVariable Long meetId,@PathVariable Long userId) throws Exception {
        meetServiceImplementation.addUserToMeet(meetId,userId);
    }

    @DeleteMapping("/{meetId}/users/{userId}")
    public void removeUserFromMeet(@PathVariable Long meetId,@PathVariable Long userId) throws Exception {
        meetServiceImplementation.removeUserFromMeet(meetId,userId);
    }
}

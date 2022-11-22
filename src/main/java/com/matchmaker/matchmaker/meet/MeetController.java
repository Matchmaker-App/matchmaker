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

    @GetMapping("/")
    public List<Meet> getMeets() {
        return meetServiceImplementation.getMeets();
    }

    @GetMapping("/{id}")
    public Meet getMeet(@PathVariable(name = "id") Long id) throws Exception {
        return meetServiceImplementation.getMeetById(id);
    }

    @PostMapping("/")
    public void postMeet(@RequestBody Meet meetRequest,@RequestParam String gameId,@RequestParam String userId) throws Exception {
        meetServiceImplementation.createMeet(meetRequest,Long.valueOf(gameId),Long.valueOf(userId));
    }

    @PutMapping("/{id}")
    public void putMeet(@RequestBody Meet newMeetRequest, @PathVariable Long id) {
        meetServiceImplementation.updateMeet(newMeetRequest,id);
    }

    @DeleteMapping("/{id}")
    public void deleteMeet(@PathVariable(name = "id") Long id) {
        meetServiceImplementation.deleteMeetById(id);
    }

}

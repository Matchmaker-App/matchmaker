package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
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
    public void postMeet(@RequestBody Meet meetRequest){
        meetServiceImplementation.createMeet(meetRequest);
    }

    @PutMapping("/")
    public void putMeet(@RequestBody Meet newMeetRequest, @PathVariable Long id) {
        meetServiceImplementation.updateMeet(newMeetRequest,id);
    }

    @DeleteMapping("/{id}")
    public void deleteMeet(@PathVariable(name = "id") Long id) {
        meetServiceImplementation.deleteMeetById(id);
    }

}

package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meet")
public class MeetController {
    private final MeetService meetService;

    @GetMapping("/")
    public List<MeetDTO> getMeets(){
        return meetService.getMeets();
    }

    @GetMapping("/{id}")
    public MeetDTO getMeet(@PathVariable(name = "id") Long id){
        return meetService.getMeetById(id);
    }

    @PutMapping("/")
    public void putMeet (@RequestBody MeetDTO meetDTO){
        meetService.createMeet(meetDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteMeet (@PathVariable(name = "id") Long id){
        meetService.deleteMeetById(id);
    }

}

package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetServiceImplementation {
    private final MeetRepository meetRepository;


    public List<Meet> getMeets(){
        return null;

    }

    public Meet getMeetById(Long id) {
        return null;

    }

    public void deleteMeetById(Long id) {
        meetRepository.deleteById(id);
    }

    public void createMeet(Meet meet) {


    }




}

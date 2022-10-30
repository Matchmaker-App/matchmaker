package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetService {
    private final MeetRepository meetRepository;


    public List<Meet> getMeets(){
        return meetRepository.findAll().stream()
                .map(meet -> converEntityToDTO())
                .collect(Collectors.toList());
    }

    public MeetDTO getMeetById(Long id) {
        return converEntityToDTO(meetRepository.getReferenceById(id));
    }

    public void deleteMeetById(Long id) {
        meetRepository.deleteById(id);
    }

    public void createMeet(MeetDTO meetDTO) {
        Meet meet = new Meet();
        meet.setDateAndTime(meetDTO.getDateAndTime());
        meet.setGame(meetDTO.getGame());
        meet.setUsersReady(meetDTO.getUsersReady());
        meetRepository.save(meet);

    }

    // Meet to MeetDTO converter for service class
    private MeetDTO converEntityToDTO(Meet meet){
        MeetDTO meetDTO = new MeetDTO();
        meetDTO.setId(meet.getId());
        meetDTO.setDateAndTime(meet.getDateAndTime());
        meetDTO.setGame(meet.getGame());
        meetDTO.setUsersReady(meet.getUsersReady());
        return meetDTO;
    }



}

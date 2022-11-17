package com.matchmaker.matchmaker.meet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetServiceImplementation {
    //Repo injection
    private final MeetRepository meetRepository;


    public List<Meet> getMeets() {
        return meetRepository.findAll();
    }

    public Meet getMeetById(Long id) throws Exception {
        return meetRepository.findById(id).orElseThrow(() -> new Exception("Not found."));

    }

    public void deleteMeetById(Long id) {
        meetRepository.deleteById(id);
    }

    public void createMeet(Meet meetRequest) {
        Meet meet = new Meet();
        meet.setDate(meetRequest.getDate());
        meet.setTime(meetRequest.getTime());
        meet.setAviability(meetRequest.isAviability());
        meet.setGame(meetRequest.getGame());
        //Todo adding user
        //meet.setUsersReady().add();
        meetRepository.save(meet);
    }

    public void updateMeet(Meet newMeetRequest, Long id) {
        meetRepository.findById(id).map(
                meet -> {
                    meet.setDate(newMeetRequest.getDate());
                    meet.setTime(newMeetRequest.getTime());
                    //Todo adding currently logged in user
                    meet.getUsersReady().add();
                    return meetRepository.save(meet);
                }
        );
    }
    //Todo adding logged in user to existing meet
    public void removeUserFromMeet(Long meetId,Long userId) throws Exception{
        Meet meet = meetRepository.findById(meetId).orElseThrow(() -> new Exception("Not found.")).getUsersReady().add();

    }
    //Todo removing logged in user from existing meet
        public void removeUserFromMeet(Long meetId,Long userId) throws Exception{
            Meet meet = meetRepository.findById(meetId).orElseThrow(() -> new Exception("Not found.")).getUsersReady().remove();

        }


}

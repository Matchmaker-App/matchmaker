package com.matchmaker.matchmaker.meet;

import com.matchmaker.matchmaker.game.GameRepository;
import com.matchmaker.matchmaker.user.User;
import com.matchmaker.matchmaker.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetServiceImplementation {
    //Repo injection
    private final MeetRepository meetRepository;
    private final GameRepository gameRepository;
    private final UserRepository userRepository;



    public List<Meet> getMeets() {
        return meetRepository.findAll();
    }

    public Meet getMeetById(Long id) throws Exception {
        return meetRepository.findById(id).orElseThrow(() -> new Exception("Not found."));

    }

    public void deleteMeetById(Long id) {
        meetRepository.deleteById(id);
    }

    public void createMeet(Meet meetRequest,Long userId,Long gameId) throws Exception {
        Meet meet = new Meet();
        meet.setDate(meetRequest.getDate());
        meet.setTime(meetRequest.getTime());
        meet.setAviability(meetRequest.isAviability());
        meet.setGame(gameRepository.findById(gameId).orElseThrow(()->new Exception("Not found.")));
        //Todo adding currently logged in user to existing meet with authentication
        meet.getUsersReady().add(userRepository.findById(userId).orElseThrow(()->new Exception("Not found.")));
        meetRepository.save(meet);
    }

    public void updateMeet(Meet newMeetRequest, Long id) {
        meetRepository.findById(id).map(
                meet -> {
                    meet.setDate(newMeetRequest.getDate());
                    meet.setTime(newMeetRequest.getTime());
                    return meetRepository.save(meet);
                }
        );
    }
    //Todo adding currently logged in user to existing meet with authentication
    public void addUserToMeet(Long meetId,Long userId) throws Exception{
        Meet meet = meetRepository.findById(meetId).orElseThrow(() -> new Exception("Not found."));
        meet.getUsersReady().add(userRepository.findById(userId).orElseThrow(()->new Exception("Not found.")));
        meetRepository.save(meet);

    }
    //Todo removing currently logged in user from existing meet with authentication
        public void removeUserFromMeet(Long meetId,Long userId) throws Exception{
            Meet meet = meetRepository.findById(meetId).orElseThrow(() -> new Exception("Not found."));
            meet.getUsersReady().remove(userRepository.findById(userId).orElseThrow(()->new Exception("Not found.")));
            meetRepository.save(meet);
        }


}

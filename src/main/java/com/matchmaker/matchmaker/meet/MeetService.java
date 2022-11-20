package com.matchmaker.matchmaker.meet;

import org.springframework.stereotype.Service;

import java.util.List;

public interface MeetService {

    public List<Meet> getMeets();
    public Meet getMeetById(Long id);
    public void deleteMeetById(Long id);
    public void createMeet(Meet meetRequest);

}

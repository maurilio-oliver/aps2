package controller.service;

import model.QuestModel;
import model.repository.QuestRepository;

public class QuestService {
  
    public void add(QuestModel other){
      QuestRepository.questList.add(other);
  }
  
  
}

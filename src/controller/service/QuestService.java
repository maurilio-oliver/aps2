package controller.service;

import model.QuestModel;
import model.repository.QuestRepository;

public class QuestService {
  
    public void add(String intro, String label_A, String label_B, String label_C, String label_D, String label_E, String response){
    
	QuestModel other = new QuestModel(intro, response, label_A, label_B, label_C, label_D, label_E);
     
    QuestRepository.questList.add(other);
  }

  public QuestModel getLegends(int i){
    if (i<QuestRepository.questList.size()) {
      
      return QuestRepository.questList.get(i);
    }else{
      System.out.println("valor de i invalido ${maior que repositorio}");
      return null;
    }
  }

  public String getResponse(int i){
   if (i<QuestRepository.questList.size()) {
     
     return QuestRepository.questList.get(i).getResponse();
   }else{
    System.out.println("valor de i invalido ${maior que repositorio}");
    return null;
  }
  }
  
  
}

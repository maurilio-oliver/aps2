package controller.Business;

import org.json.simple.JSONObject;

import controller.Business.helper.json.ConvertJson;
import controller.service.QuestService;

public class GameController {
    private ConvertJson convertJson = new ConvertJson();
    JSONObject list =  convertJson.getJson("resources/quest.json");
    QuestService service = new QuestService();
    
   private void loadingQuest(JSONObject quests){

         String intro = quests.get("intro").toString();
         String label_A = quests.get("a").toString();
         String label_B = quests.get("b").toString();
         String label_C = quests.get("c").toString();
         String label_D = quests.get("d").toString();
         String label_E = quests.get("e").toString();

         String response = quests.get("response").toString();
        service.add(intro, label_A, label_B, label_C, label_D, label_E, response);
        
    }

    public void loadingQList(){
    list.keySet().forEach(qst->{
        JSONObject a = convertJson.getObj(list.get(qst).toString());
        loadingQuest(a);
    });    
    
}

    public boolean checkResponse(int i, String palpite){
        String response = service.getResponse(i);
       
        if (palpite.equals(response)) {
            return true;
        } else {
            return false;
        }

    }


}

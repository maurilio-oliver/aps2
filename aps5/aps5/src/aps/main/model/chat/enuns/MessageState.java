package aps.main.model.chat.enuns;

public enum MessageState {
        //mensagem enviada
        SENDED(1L),
        //mensagem deletada
        DELETED(2L),
        //mensagem cancelada
        CANCELLED(3L),
        //mensagem recebida
        RECEIVED(4L),
        //mensagem visualizada
        VIEWED(5L);


 public Long id;

 //pegar o id do status
 public Long getStateId(){return this.id;}

 MessageState(Long id){this.id = id;}


}

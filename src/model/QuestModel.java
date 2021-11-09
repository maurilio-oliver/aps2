package model;

public class QuestModel {
    
    private String intro;
    private String response;
    private String label_A;
    private String label_B;
    private String label_C;
    private String label_D;
    private String label_E;

    public QuestModel(String intro, String response, String label_A, String label_B, String label_C, String label_D,
            String label_E) {
        this.intro = intro;
        this.response = response;
        this.label_A = label_A;
        this.label_B = label_B;
        this.label_C = label_C;
        this.label_D = label_D;
        this.label_E = label_E;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getLabel_A() {
        return label_A;
    }

    public void setLabel_A(String label_A) {
        this.label_A = label_A;
    }

    public String getLabel_B() {
        return label_B;
    }

    public void setLabel_B(String label_B) {
        this.label_B = label_B;
    }

    public String getLabel_C() {
        return label_C;
    }

    public void setLabel_C(String label_C) {
        this.label_C = label_C;
    }

    public String getLabel_D() {
        return label_D;
    }

    public void setLabel_D(String label_D) {
        this.label_D = label_D;
    }

    public String getLabel_E() {
        return label_E;
    }

    public void setLabel_E(String label_E) {
        this.label_E = label_E;
    }

    @Override
    public String toString() {
        return "QuestModel [intro=" + intro + ", label_A=" + label_A + ", label_B=" + label_B + ", label_C=" + label_C
                + ", label_D=" + label_D + ", label_E=" + label_E + ", response=" + response + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((intro == null) ? 0 : intro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QuestModel other = (QuestModel) obj;
        if (intro == null) {
            if (other.intro != null)
                return false;
        } else if (!intro.equals(other.intro))
            return false;
        return true;
    }

    
    
}

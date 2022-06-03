package aps.main.model.chat;

public class archivModel {
    private String name;
    private String pathFrom;
    private String pathTo;
    private String content;
    private String type;


    public String name() {
        return name;
    }

    public archivModel setName(String name) {
        this.name = name;
        return this;
    }

    public String pathFrom() {
        return pathFrom;
    }

    public archivModel setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
        return this;
    }

    public String pathTo() {
        return pathTo;
    }

    public archivModel setPathTo(String pathTo) {
        this.pathTo = pathTo;
        return this;
    }

    public String content() {
        return content;
    }

    public archivModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String type() {
        return type;
    }

    public archivModel setType(String type) {
        this.type = type;
        return this;
    }
}

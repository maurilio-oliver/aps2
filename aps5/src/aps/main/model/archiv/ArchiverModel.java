package aps.main.model.archiv;

import java.io.Serializable;

public class ArchiverModel implements Serializable {
    //caminho do arquivo na maquina
    private String localpath;

    private String name;

    private String content;
    private String destinyDirectory;

    public String localpath() {
        return localpath;
    }

    public String name() {
        return name;
    }

    public ArchiverModel setName(String name) {
        this.name = name;
        return this;
    }

    public ArchiverModel setLocalpath(String localpath) {
        this.localpath = localpath;
        return this;
    }

    public String content() {
        return content;
    }

    public ArchiverModel setContent(String content) {
        this.content = content;
        return this;
    }


    public String destinyDirectory() {
        return destinyDirectory;
    }

    public ArchiverModel setDestinyDirectory(String destinyDirectory) {
        this.destinyDirectory = destinyDirectory;
        return this;
    }
}

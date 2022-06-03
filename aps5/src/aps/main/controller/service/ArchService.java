package aps.main.controller.service;

import aps.main.model.archiv.ArchiverModel;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ArchService {
    private ArchiverModel archive = new ArchiverModel();
    private Scanner scan;

    public ArchiverModel getArchive(String path) throws IOException {
        String[] split = path.split("/");
        archive.setName(split[split.length -1]);
        archive.setLocalpath(path);
        archive.setContent(this.content(path));
        return this.archive;
    }

    public String content(String path) throws IOException {
        scan = new Scanner(Path.of(path));
        String content= "";

        while (scan.hasNextLine()){
            content = content + scan.nextLine();
        }
        return content;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(Path.of("/home/oliver/Documents/v.txt"));
        String content= "";

        while (scan.hasNextLine()){
            content = content + scan.nextLine();
        }

        System.out.println(content);
    }
}

package aps.main;

import aps.main.controller.config.socket.SocketClient;
import aps.main.model.archiv.ArchiverModel;
import aps.main.view.HomeView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ApsApplication {
    public static void main(String[] args) {

        new HomeView();
    }
}

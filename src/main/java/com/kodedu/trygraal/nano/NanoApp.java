package com.kodedu.trygraal.nano;

import com.kodedu.trygraal.websocket.TerminalSocket;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoWSD;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NanoApp extends NanoWSD {

    public static void main(String[] args) throws IOException {
        new NanoApp("0.0.0.0", 8080).start(2 * 60 * 1000, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
    }

    public NanoApp(String hostname, int port) {
        super(hostname, port);
    }

    @Override
    protected WebSocket openWebSocket(IHTTPSession handshake) {
        return new TerminalSocket(this, handshake);
    }

    @Override
    protected Response serveHttp(IHTTPSession session) {
        String contentType = null;
        try {
//            Path root = Paths.get("C:\\Users\\usta\\trygraal\\src\\main\\resources\\public");

            String uri = session.getUri();

            if (uri.length() == 1) {
                uri = "/index.html";
            }

            InputStream inputStream = NanoApp.class.getResourceAsStream("/public" + uri);

//            Path resolve = root.resolve(uri);
            contentType = Files.probeContentType(Paths.get(uri));

            return NanoHTTPD.newFixedLengthResponse(Response.Status.OK, contentType, inputStream, inputStream.available());
        } catch (Exception e) {
//            e.printStackTrace();
            return NanoHTTPD.newFixedLengthResponse("No Response");
        }

    }

}

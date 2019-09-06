package remote_proxy.download;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.util.Map;

/**
 * Простой web-сервер. Испрльзуется для обслуживания каталога download
 */
public class NanoServer extends NanoHTTPD {

  public NanoServer() throws IOException {
    super(8080);
    start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
  }

  public static void main(String[] args) {
    try {
      new NanoServer();
    } catch(IOException e) {
      System.err.println("Couldn't start remote_proxy.server:\n" + e);
    }
  }

  @Override
  public Response serve(IHTTPSession session) {
    String msg = "<html><body><h1>Hello remote_proxy.server</h1>\n";
    Map<String, String> parms = session.getParms();
    if (parms.get("username") == null) {
      msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
    } else {
      msg += "<p>Hello, " + parms.get("username") + "!</p>";
    }
    return newFixedLengthResponse(msg + "</body></html>\n");
  }
}
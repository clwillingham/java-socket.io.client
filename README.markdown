Java Socket.IO Client
=============

A Socket.IO client written in Java. See the offical [Socket.IO website](http://socket.io/) for more information. 

Dependencies
-----

This project has a dependency on [TooTallNate/Java-WebSocket](https://github.com/TooTallNate/Java-WebSocket), a barebones WebSocket client and server implementation written in 100% Java.

Usage
-----

Here is how you connect to a Socket.IO server at localhost:80:

    IOSocket socket = new IOSocket("http://localhost:80", new MessageCallback() {
      @Override
      public void on(String event, JSONObject... data) {
        // Handle events
      }

      @Override
      public void onMessage(String message) {
        // Handle simple messages
      }

      @Override
      public void onMessage(JSONObject message) {
        // Handle JSON messages
      }

      @Override
      public void onConnect() {
        // Socket connection opened
      }

      @Override
      public void onDisconnect() {
        // Socket connection closed
      }
    });

    socket.connect();

If you're using the namespace feature of Socket.IO, you can also set that in the socket address:

    IOSocket socket = new IOSocket("http://localhost:80/chat", ...)

Once the connection is opened, you can send messages to the server:

    // simple message
    socket.send("Hello world");

    // event with a json message
    socket.emit("see", new JSONObject().put("name", "Spot").put("action", "run"));
package com.clwillingham.socket.io;

public interface MessageCallback {
	public void on(String event, String data);
	public void onMessage(String message);
	public void onOpen();
	
	
}

package com.clwillingham.socket.io;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.Timer;

import net.tootallnate.websocket.WebSocketClient;

public class IOWebSocket extends WebSocketClient{
	
	private boolean connected;
	private IOBeat heartBeater;

	public IOWebSocket(URI arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIOError(IOException arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		IOMessage message = IOMessage.parseMsg(arg0);
		if(message.getType() == IOMessage.HEARTBEAT){
			try {
				send("2::");
				System.out.println("HeartBeat written to server");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onOpen() {
		// TODO Auto-generated method stub
		
	}
	
	public void init(String path, String query) throws IOException{
		this.send("1::"+path+"?"+query);
		
	}
	
	

}

package com.clwillingham.socket.io;

import java.io.IOException;
import java.net.URI;

public class IOSocketTest {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		IOSocket socket = new IOSocket("ws://ubuntu-server:8000", new MessageCallback() {
			
			@Override
			public void onOpen() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMessage(String message) {
				// TODO Auto-generated method stub
				System.out.println("message recieved from server: "+message);
			}
			
			@Override
			public void on(String event, String data) {
				// TODO Auto-generated method stub
				
			}
		});
		socket.connect("http://ubuntu-server:8000");
		System.out.println("connected to server");
		Thread.sleep(5000);
		socket.getWebSocket().sendMessage("this is a test");
		System.out.println("sen't message");
		
	}

}

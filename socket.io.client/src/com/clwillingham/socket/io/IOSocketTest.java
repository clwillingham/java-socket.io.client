package com.clwillingham.socket.io;

import java.io.IOException;
import java.net.URI;

public class IOSocketTest {
	
	public static void main(String[] args) throws IOException{
		IOSocket socket = new IOSocket("ws://ubuntu-server:8000");
		socket.connect("http://ubuntu-server:8000");
		
	}

}

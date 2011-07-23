package com.clwillingham.socket.io;

public class IOMessage {
	public static final int DISCONNECT = 0;
	public static final int CONNECT = 1;
	public static final int HEARTBEAT = 2;
	public static final int MESSAGE = 3;
	public static final int JSONMSG = 4;
	public static final int EVENT = 5;
	public static final int ACK = 6;
	public static final int ERROR = 7;
	
	private int type;
	private int id = -1;
	private String endpoint = "";
	private String messageData;
	
	
	public static IOMessage parseMsg(String message){
		String[] content = message.split(":");
		IOMessage msg = new IOMessage();
		msg.setType(Integer.parseInt(content[0]));
		if(message.endsWith("::")){
			msg.setId(-1);
			msg.setMessageData("");
			msg.setEndpoint("");
			return msg;
		}
		
		msg.setId(Integer.parseInt(content[1]));
		msg.setEndpoint(content[2]);
		msg.setMessageData(content[3]);
		return msg;
	}
	
	public String toString(){
		if(id == -1 && endpoint.equals("") && messageData.equals("")){
			return type+"::";
		}
		if(id > -1){
			return type+":"+id+":"+endpoint+":"+messageData;
		}
		else{
			return type+"::"+endpoint+":"+messageData;
		}
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getType() {
		return type;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}


	public String getEndpoint() {
		return endpoint;
	}


	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}


	public String getMessageData() {
		return messageData;
	}
	

}

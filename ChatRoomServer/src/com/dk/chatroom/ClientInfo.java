package com.dk.chatroom;
import java.net.Socket;
 
public class ClientInfo
{
    public Socket mSocket = null;
    public ClientListener mClientListener = null;
    public ClientSender mClientSender = null;
}
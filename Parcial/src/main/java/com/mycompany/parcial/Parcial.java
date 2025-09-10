/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial;
import  com.mycompany.parcial.HttpServer;
import  com.mycompany.parcial.HttpConnection;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author juan.parroquiano
 */
public class Parcial {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Hello World!");
        
        HttpServer.startServer(args);
        //HttpConnection.main(args);
    }
}

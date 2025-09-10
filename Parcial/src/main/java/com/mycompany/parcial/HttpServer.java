/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;

/**
 *
 * @author juan.parroquiano
 */
public class HttpServer {

    LinkedList<Integer> numeros = new LinkedList<>();
    
    public static void startServer(String[] args) throws IOException, URISyntaxException {
        HttpServer httpServer = new HttpServer();
        ServerSocket serverSocket = null;
        URI url = null;
        URI uri = null;
        Integer x = 0;
        try {
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        
        while ((inputLine = in.readLine()) != null) {
            String requestLine = in.readLine();
            String path = inputLine.split("'?'")[0]; // "/add?x=7"
            uri = new URI(in.readLine());
            
            if (uri.getPath().startsWith("/add")) {
                String query = path.substring(path.indexOf("?") + 1);
                String[] params = query.split("=");
                x = Integer.parseInt(params[1]);
                httpServer.addNum(x);
            }
            else if (uri.getPath().startsWith("/list")){
                httpServer.listNumeros();
            }
            else if (uri.getPath().startsWith("/clear"))
            {
                httpServer.listNumeros();
            }
            else if (uri.getPath().startsWith("/stats"))
            {
                httpServer.stats();
            }
            if (!in.ready()) {
                break;
            }
        }
        
        outputLine = bodyHttp();
        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    public String addNum(int num) {
        String response = "";
        numeros.add(num);
        
        /*response = String.format( "{
                            \"status\": \"OK\",
                            \"added\": %d,
                            \"count\": %d,
                            \"sum\": %d
                          }", num, count, sum);*/
        
        return response;
    }
    
    public LinkedList<Integer> listNumeros()
    {
        return numeros;
    }
    
    public void clearList()
    {
        numeros.clear();
    }
    
    public void stats()
    {
        double average = 0;
        double sum = 0;
        double desviacion = 0;
        double varianceSum = 0;
        double varianza = 0;
        double raiz = 0;
        int count = numeros.size();
                
        for (double num : numeros) {
            sum += num;
        }
        //Promedio
        average = sum / count;
        
        for (double num : numeros) {
            varianceSum += (num - average) * (num - average);
        }
        varianza = varianceSum / count;
        raiz = Math.sqrt(varianza);
    }
    
    public static String bodyHttp()
    {
        String ret;
        
        ret = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Mi propio mensaje</h1>\n"
                + "</body>\n"
                + "</html>\n";
        
        return ret ;
    }
}

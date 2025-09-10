/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial;

/**
 *
 * @author juan.parroquiano
 */
public class NewClass {
    
}/*
public class StatsCalculator {

    public static String calculateStats(List<Double> numbers) throws Exception {
        int count = numbers.size();
        if (count == 0) {
            throw new IllegalArgumentException("List must not be empty");
        }

        // Calculate average
        double sum = 0.0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / count;

        // Calculate standard deviation
        double varianceSum = 0.0;
        for (double num : numbers) {
            varianceSum += (num - average) * (num - average);
        }
        double variance = varianceSum / count;
        double stdDev = Math.sqrt(variance);

        // Create JSON object using Jackson
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();

        json.put("average", average);
        json.put("standard_deviation", stdDev);
        json.put("count", count);

        // Convert JSON object to String
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }

    // Example usage
    public static void main(String[] args) throws Exception {
        List<Double> numbers = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        String resultJson = calculateStats(numbers);
        System.out.println(resultJson);
    }
}


while (true) {
    Socket client = serverSocket.accept();
    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    PrintWriter out = new PrintWriter(client.getOutputStream(), true);

    // Leer la petición HTTP, por ejemplo la primera línea
    String requestLine = in.readLine();
    if (requestLine!= null && requestLine.startsWith("GET")) {
        // Extraer la ruta y parámetros
        String path = requestLine.split(" ")[1]; // "/add?x=7"
        if (path.startsWith("/add")) {
            // Extraer parámetro x
            String query = path.substring(path.indexOf("?") + 1);
            String[] params = query.split("=");
            int x = Integer.parseInt(params[1]);

            // Procesar la petición
            int resultado = x + 10; // ejemplo de lógica

            // Responder con HTTP
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println();
            out.println("Resultado: " + resultado);
        }
    }
    client.close();
}*/

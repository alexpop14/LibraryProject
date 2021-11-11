package com.audi.ja.libraryAlex.controller;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.repository.LibraryRepository;
import com.audi.ja.libraryAlex.service.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "bookServlet", value = "/books/*")
public class BookServlet extends HttpServlet {

    private LibraryService libraryService = new LibraryService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pathInfo = request.getPathInfo();
        if(pathInfo == null || pathInfo.equals("/getbookbyisbn")){

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.getBookFromDbByIsbn(67791741));

            PrintWriter writer = response.getWriter();
            writer.write(responseJson);

        }else if(pathInfo.equals("/allbooks")){
            List<Book> books = libraryService.showAllBooks();
            sendResponse(response, books);

        }else if(pathInfo.equals("/getmybooks")){

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showMyBooks(26424155));

            PrintWriter writer = response.getWriter();
            writer.write(responseJson);
        }else if(pathInfo.equals("/getIsbnOfAvailableBooks")){
            List<Integer> availableIsbnList = libraryService.getIsbnOfAvailableBooks();
            sendResponse(response, availableIsbnList);
        }
    }

    private void sendResponse(HttpServletResponse response, Object payload) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter printWriter = response.getWriter();

        String responseJson = new ObjectMapper().writer().writeValueAsString(payload);
        printWriter.write(responseJson);
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin","*");
        /*   String bodyAsJsonString = getBodyAsJsonString(request);
            System.out.println(bodyAsJsonString);
            Book book = new ObjectMapper().readValue(bodyAsJsonString, Book.class);
            libraryService.borrowBook(book.getIsbn(), 5984515);
            request.getRequestDispatcher("/postBook/id/borrow").forward(request, response);
*/
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("*/borrow")) {
            String isbn = getIsbnFromPath(pathInfo);
            int isbnInt = Integer.parseInt(isbn);
            libraryService.borrowBook(isbnInt, 5984515);
        }



    }

    private String getBodyAsJsonString(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line.trim());
        }

        String jsonString = sb.toString();
        return jsonString;
    }

    private boolean isBaseUrl(String pathInfo) {
        return pathInfo == null || pathInfo.equals("/");
    }

    private String getIsbnFromPath(String pathInfo) {
        String[] pathElements = pathInfo.split("/");
        String isbn = pathElements[2];
        System.out.println(isbn);
        return isbn;
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Allow", "GET, POST, DELETE, OPTIONS");
    }

}

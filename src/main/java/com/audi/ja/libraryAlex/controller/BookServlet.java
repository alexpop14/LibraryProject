package com.audi.ja.libraryAlex.controller;

import com.audi.ja.libraryAlex.model.Book;
import com.audi.ja.libraryAlex.repository.LibraryRepository;
import com.audi.ja.libraryAlex.service.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        }
    }

    private void sendResponse(HttpServletResponse response, Object payload) throws IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        PrintWriter printWriter = response.getWriter();

        String responseJson = new ObjectMapper().writer().writeValueAsString(payload);
        printWriter.write(responseJson);
        printWriter.flush();
    }
}

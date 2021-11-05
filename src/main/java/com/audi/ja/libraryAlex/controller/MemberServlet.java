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

@WebServlet(name = "memberServlet", value = "/members/*")
public class MemberServlet extends HttpServlet {

    private LibraryService libraryService = new LibraryService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pathInfo = request.getPathInfo();
         if(pathInfo == null || pathInfo.equals("/getallmembers")){

            String responseJson = new ObjectMapper().writeValueAsString(libraryService.showAllMembers());

            PrintWriter writer = response.getWriter();
            writer.write(responseJson);
        }
    }
}

package com.tepang.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tepang.common.Control;
import com.tepang.jdbc.TePangDAO;

public class searchHistoryControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        TePangDAO tdao = new TePangDAO();

        String id = req.getParameter("id");
        List<String> shis = tdao.searchHistory(id);

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(shis);

        resp.getWriter().write(json);

    }

}

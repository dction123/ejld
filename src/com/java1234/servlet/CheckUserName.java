package com.java1234.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CheckUserName extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if ("checkUserName".equals(action)) {
			this.checkUserName(request, response);
		}else if ("ejld".equals(action)) {
			this.ejld(request, response);
		}
	}	

	private void ejld(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String shengId = request.getParameter("shengId");
		System.out.println("shengId"+shengId);
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		JSONObject temp = null;
		JSONObject resultJson=new JSONObject();
		switch (Integer.parseInt(shengId)) {
		case 1:
			temp = new JSONObject();temp.put("id", 1);temp.put("text","南京");jsonArray.add(temp);
			temp = new JSONObject();temp.put("id", 2);temp.put("text","南通");jsonArray.add(temp);
			temp = new JSONObject();temp.put("id", 3);temp.put("text","泰兴");jsonArray.add(temp);
			break;
		case 2:
			temp=new JSONObject();temp.put("id", 4);temp.put("text", "济南");jsonArray.add(temp);
			temp=new JSONObject();temp.put("id", 5);temp.put("text", "烟台");jsonArray.add(temp);
			temp=new JSONObject();temp.put("id", 6);temp.put("text", "蓬莱");jsonArray.add(temp);
			break;
		
		case 3:
			temp=new JSONObject();temp.put("id", 7);temp.put("text", "杭州");jsonArray.add(temp);
			temp=new JSONObject();temp.put("id", 8);temp.put("text", "宁波");jsonArray.add(temp);
			temp=new JSONObject();temp.put("id", 9);temp.put("text", "温州");jsonArray.add(temp);
			break;
		
		}
		resultJson.put("rows", jsonArray);
		out.print(resultJson);
		out.flush();
		out.close();
	}

	private void checkUserName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		JSONObject resultJson = new JSONObject();
		
		if ("tom".equals(userName)) {
			resultJson.put("exit", true);
		}else {
			resultJson.put("exit", false);
		}
		out.print(resultJson);
		out.flush();
		out.close();
	}
}

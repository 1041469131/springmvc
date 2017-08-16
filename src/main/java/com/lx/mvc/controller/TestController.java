package com.lx.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lx.mvc.annotation.*;
import com.lx.mvc.service.TestService;

@Controller
@RequestMapping("/lx")
public class TestController {

	@Qualifier("TestServiceImpl")
	private TestService testService;

	@RequestMapping("/query")
	public void query(HttpServletRequest request, HttpServletResponse response, HttpSession session, Map map, @RequestParam("name") String userName, List list, @RequestHeader("Accept") String host) {

		try {
			PrintWriter pw = response.getWriter();
			String result = testService.query(null);
			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/insert")
	public void insert(HttpServletRequest request, HttpServletResponse response, String param) {
		try {
			PrintWriter pw = response.getWriter();
			String result = testService.insert(param);

			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, String param) {
		try {
			PrintWriter pw = response.getWriter();
			String result = testService.update(param);

			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

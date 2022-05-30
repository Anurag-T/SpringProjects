package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping("/todo-list")
	public String todo_list(ModelMap map) {
		
		map.addAttribute("todos", service.retrieveTodos("Anurag Tyagi"));
		return "todo-list";
	}
	
	@RequestMapping(value = "/add-todo", method =RequestMethod.GET)
	public String todo_add(ModelMap map) {
		Todo todo = new Todo();
		todo.setDesc("Enter Default Description");
		map.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value = "/add-todo", method =RequestMethod.POST)
	public String todoAdd(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		service.addTodo("Anurag Tyagi", todo.getDesc(), new Date(), false);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value = "/delete-todo", method =RequestMethod.GET)
	public String todoDelete(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value = "/update-todo", method =RequestMethod.GET)
	public String todoUpdate(ModelMap map,@RequestParam int id) {
		Todo todo = service.getById(id);
		if(todo == null) {
		return "redirect:add-todo";
		}
		map.addAttribute("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value = "/update-todo", method =RequestMethod.POST)
	public String todoUpdate(@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		service.deleteTodo(todo.getId());
		service.addTodo("Anurag Tyagi", todo.getDesc(), todo.getDate(), false);
		return "redirect:todo-list";
	}

}

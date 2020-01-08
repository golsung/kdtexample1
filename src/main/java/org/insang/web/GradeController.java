package org.insang.web;

import java.util.List;

import org.insang.domain.Student;
import org.insang.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GradeController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView list(@ModelAttribute Student student, ModelAndView mav) {
		mav.setViewName("create");
		Iterable<Student> students = studentService.findAll();
		mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping(value="/deleteall", method=RequestMethod.POST)
	public ModelAndView deleteAll(@ModelAttribute Student student, ModelAndView mav) {
		studentService.deleteAll();
		ModelAndView r= new ModelAndView("redirect:/");
		return r;
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam Long id, ModelAndView mav) {
		Student student = studentService.findById(id);	
		mav.setViewName("edit");
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping(value={"/", "/edit"}, method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Validated Student student, BindingResult result, 
			ModelAndView mav) {
		
		ModelAndView r=null;
		if (!result.hasErrors()) {
			studentService.addStudentGrade(student);
			r= new ModelAndView("redirect:/");
		} else {
			mav.setViewName("create");
			Iterable<Student> students = studentService.findAll();
			mav.addObject("students", students);
			r = mav;
		}
		return r;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@RequestParam Long id, ModelAndView mav) {
		studentService.deleteStudentGrade(id);
		return new ModelAndView("redirect:/");
	}
}
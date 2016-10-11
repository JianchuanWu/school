package org.school.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.school.hb.entities.StudentSubject;
import org.school.hb.entities.Subjectinfo;
import org.school.hb.entities.Userinfo;
import org.school.mdservice.ModelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUnit {
private static ApplicationContext app;
	
	@BeforeClass
	public static void before(){
		app = new ClassPathXmlApplicationContext("app1.xml");
	}
	
	//@Test
	public void testGetStudentBySubject(){
		ModelService service = app.getBean("modelService",ModelService.class);
		
		Subjectinfo sub = new Subjectinfo();
		sub.setSubid(2);
		List<StudentSubject> ss = service.getStudentBySubject(sub);
		for (StudentSubject studentSubject : ss) {
			System.out.println(studentSubject);
		}
	}
	//@Test
	public void testDeleteSubject(){
		ModelService service = app.getBean("modelService",ModelService.class);
		
		Subjectinfo sub = new Subjectinfo();
		sub.setSubid(2);
		service.delete_subject_clear(sub);
	}
	
	@Test
	public void testOfLogin(){
		ModelService service = app.getBean("modelService",ModelService.class);
		Userinfo user = new Userinfo("admin","admin");
		user = service.login(user);
		System.out.println(user);
		
	}
}

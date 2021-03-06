package com.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pulapakas on 24-02-2017.
 */
@Transactional
@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

   @Autowired
    private StudentService service;
  @RequestMapping(value = "/",method = RequestMethod.GET)
   //public  List<StudentPojo> findByName( )
  public ResponseEntity<Response> findByName( )
   {

       log.info("Getting Student ByName");
       Response response = new Response();
       //return Lists.newArrayList(service.findStudentsByName());
       List<StudentPojo> studentsList=service.findStudentsByName();
       if(studentsList==null||studentsList.size()==0){
           response.setStatus(StatusCode.E400);
           return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
       }else{
           response.setContent(studentsList);
           response.setStatus(StatusCode.U200);
           return new ResponseEntity<Response>(response, response.getHttpStatus());
       }

    }

    public String valida
}

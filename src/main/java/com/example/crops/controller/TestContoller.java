package com.example.crops.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor
public class TestContoller {
    private static PythonInterpreter intPre;

    @GetMapping("/test")
    public String getTest(){
        intPre = new PythonInterpreter();
        System.out.println("5:");
        intPre.execfile("src/main/clt/test.py");
        System.out.println("6:");
//        intPre.exec("print(test(5, 10))");

        PyFunction pyFunction = (PyFunction) intPre.get("testFunc", PyFunction.class);
        System.out.println("7:");
        int a = 10, b = 20;
        System.out.println("8:");
                PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("9:" + pyobj.toString());

        return pyobj.toString();
    }
}

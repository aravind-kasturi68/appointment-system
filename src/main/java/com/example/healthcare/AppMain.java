package com.example.healthcare;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml")) {
            AppointmentService service = (AppointmentService) ctx.getBean("appointmentService");

            System.out.println(service.book("DOC101", "2025-04-10"));
            System.out.println(service.book("DOC101", "2025-04-10"));
            System.out.println(service.book("DOC102", "2025-04-13"));
            System.out.println(service.book("DOC999", "2025-04-10"));
        }
    }
}

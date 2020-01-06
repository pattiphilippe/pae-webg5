package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaeApplication.class, args);
	}

}
//TODO update css for footer
/*
html, body {
    height: 100%
}

#page-wrapper {
    min-height: 100%;
    padding-bottom: 1rem;
    margin-bottom: -130px
}

#page-wrapper::after {
    content: "";
    display: block;
    min-height: 130px
}

#page-footer {
    min-height: 130px;
    text-align: left
}
 */
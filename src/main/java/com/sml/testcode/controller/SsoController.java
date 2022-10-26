package com.sml.testcode.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class SsoController {
//    POST	/api/auth/signup	signup new account
//    POST	/api/auth/signin	login an account
//    GET	/api/test/all	    retrieve public content
//    GET	/api/test/user	    access User’s content
//    GET	/api/test/mod	    access Moderator’s content
//    GET	/api/test/admin	    access Admin’s content
}

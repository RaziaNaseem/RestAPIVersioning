package com.example.demo.versioning;

import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
// 1. URL versioning
    @GetMapping(path = "/v1/Person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");

    }
    @GetMapping("/v2/Person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));

    }

    // 2. Request parameter versioning
    //localhost:8080/Person?version=1
    @GetMapping(path = "/Person",params ="version=1")
    public PersonV1 getFirstVersionOfPersoRequestParameter() {
        return new PersonV1("Bob Charlie");

    }
    @GetMapping(path = "/Person",params ="version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));

    }

    // 3. custom header versioning
    @GetMapping(path = "/person/header",headers ="X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersoRequestHeader() {
        return new PersonV1("Bob Charlie");

    }
    @GetMapping(path = "/person/header",headers ="X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));

    }

    // 4. Media type versioning/content negotiation
    @GetMapping(path = "/person/accept",produces ="application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersoAcceptHeader() {
        return new PersonV1("Bob Charlie");

    }
    @GetMapping(path = "/person/accept",produces ="application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));

    }
}

package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger logger = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        logger.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        logger.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        logger.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    @GetMapping("/variable2/{variable}/{var2}")
    public String getVariable2(@PathVariable("variable") String var, @PathVariable String var2) {
        return var + var2;
    }


    @GetMapping("/request1")
    @Operation(summary = "GET 메서드 예제", description = "@RequestParam을 활용한 GET Method")
    public String getRequestParam1(@Parameter(name = "name", description = "이름", required = true) @RequestParam String name,
                                   @Parameter(name = "email", description = "이메일", required = true) @RequestParam String email,
                                   @Parameter(name = "organization", description = "회사", required = true) @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}

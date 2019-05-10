package com.example.redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/redis")
public class GetSetController {

    private static final Logger log = LoggerFactory.getLogger(GetSetController.class);

    private final GetSetService getSetService;

    @Autowired
    public GetSetController(GetSetService getSetService) {
        this.getSetService = getSetService;
    }

    @PostMapping("/get")
    public Map<String, Object> get(@RequestBody Map<String, Object> body) {
        String key = (String) body.get("key");
        log.info("GetSetController/get : " + key);
        Object result = getSetService.get(key);
        body.put("value", result);

        return body;
    }

    @PostMapping("/set")
    public Map<String, Object> set(@RequestBody Map<String, Object> body) {
        String key = (String) body.get("key");
        Object value = body.get("value");
        log.info("GetSetController/set : " + key + " : " + value);
        Object result = getSetService.set(key, value);
        body.put("value", result);

        return body;
    }
}

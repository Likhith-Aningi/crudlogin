package com.h2example.crudlogin;

import com.h2example.crudlogin.Entities.entity.EmpEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = {"http://localhost:3000", "http://likhith:3000"})
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestWire testWre;
    @Value("${injectValue}")
    public String inValue;

    @Value("${url}")
    public String url;

    @Value("${server.port}")
    public int port;
    @Value("${sampleVal}")
    public float flot;

    @GetMapping("/rest")
    public String getRestOP(HttpServletRequest request) {
        System.out.println("rest op hit " + request.getHeader("User-Agent"));
        testWre.meth();
        return "Hello java dev this is rest output";
    }

    @GetMapping("/html")
    public ModelAndView getHtml() {
        ModelAndView mv = new ModelAndView("helloM");
        // ModelAndView mv=new ModelAndView();
        // mv.setViewName("helloM");
        return mv;
    }

    @GetMapping("/err")
    public ModelAndView throwErr() {
        try {
            throw new Exception("my exception");
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("error/500");
            mav.addObject("message", e.getMessage());
            return mav;
        }
    }

    @GetMapping("/err2")
    public ModelAndView throwErr2() {
        ModelAndView mav = null;
        try {
            Random rand = new Random();
            int b = rand.nextInt(2);
            System.out.println("b=============" + b);
            int a = 10 / b;
            System.out.println(a);
        } catch (Exception e) {
            mav = new ModelAndView("error/500");
            mav.addObject("message", e.getMessage());
            return mav;
        }
        mav = new ModelAndView("add");
        return mav;
    }

    @Value("${warfilename}")
    String war;

    @GetMapping("/injectValue")
    public String retInjectedValue() {
        return war + " " + inValue + " db url: " + url + " serverPort: " + port + " sampleFloatVal : " + flot;
    }

    // path var should me mandatory for request or else it will throw bad request
    // error
    @GetMapping("/path/{val}")
    public String pathVarImplemtnation(@PathVariable int val) {
        return "you have passed " + val + " with url";
    }

    // requestparam is optional and flexible
    @GetMapping("/request-param")
    public String requestParamImplementation(
            @RequestParam(name = "val", required = false, defaultValue = "\"this is default value\"") String val) {
        return "you hava passed " + val;
    }

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/NamedJdbc")
    public ResponseEntity<List<EmpEntity>> getNamedJdbcOP() {//Usage of dao should be in service layer but here using for demo
        List<EmpEntity> res = namedParameterJdbcTemplate.query("Select ename,esal  from EMP", new BeanPropertyRowMapper<>(EmpEntity.class));
        return ResponseEntity.ok().body(res);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/LimNamedJdbc")
    public JSONArray getNamedRepOP() {
        List<Map<String, Object>> res = namedParameterJdbcTemplate.getJdbcTemplate().queryForList("Select ename,esal  from EMP;");
        JSONArray jsonArray = new JSONArray();
        for (Map<String, Object> re : res) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ename",re.get("ename"));
            jsonObject.put("esal",re.get("esal"));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
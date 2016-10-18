package com.lc;

import com.service.RedisService;
import com.util.JedisUtil;
import com.util.ParamUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value="/mvc")
public class MvcController{
    @Autowired
    private MvcService service;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value="/login")
    public ModelAndView login(String username,String password){
        ModelAndView mdv = new ModelAndView("succ");
        mdv.addObject("username", username);
        mdv.addObject("password", password);
        return mdv;
    }
    @RequestMapping(value="/login2")
    public String login2(@ModelAttribute User user){
        System.err.println(service.service());
        //return user.getUserName();
        return "";
    }
    @RequestMapping(value = "/alluser")
    public ModelAndView findAllUser(){
        ModelAndView mav = new ModelAndView("userList");
        //mav.addObject("userList",service.findUserList());
        return mav;
    }
    @RequestMapping("/show")
    public ModelAndView showUser(@RequestParam(value = "username",required = true) String name){
        ModelAndView mav = new ModelAndView("show");
        mav.addObject("password",service.findUser(name));
        return mav;
    }
    @RequestMapping("/register")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView mav = new ModelAndView("succ");
        service.saveUser(user);
        //mav.addObject("userName",user.getUserName());
        //mav.addObject("passWord",user.getPassWord());
        return mav;
    }
  /*  @RequestMapping("/checkUser")
    @ResponseBody
    public Map<String,String> checkUser(@ModelAttribute User user){
        Map<String,String> result = new HashMap<String,String>();
        result.put("isExist",service.checkUser(user));
        return result;
    }*/
  @RequestMapping("/checkUser")
  @ResponseBody
  public Map checkUser(@ModelAttribute User user){

      Map result = new HashMap();
      //Map result2 = new HashMap();
      List list = new ArrayList();
      //Map result3 = new HashMap();

      List list2 = new ArrayList();
      User user1 = new User();
      /*user1.setUserId(1);
      user1.setUserName("lc");
      user1.setPassWord("123");
      user1.setCreateTime(new Date());

      User user2 = new User();
      user2.setUserId(2);
      user2.setUserName("zy");
      user2.setPassWord("123");
      user2.setCreateTime(new Date());*/
      //list2.add(result2);
      /*result2.put("name","lc");
      result2.put("sex","M");
      result2.put("phone","1234565");
      result2.put("email","123@qq.com");
      result2.put("remark","lclclc");
      result2.put("id","123");*/
      list2.add(user1);
      //list2.add(user2);
      //result.put("isExist",service.checkUser(user));
      result.put("total","1");
      //result.put("rows",list2);
      list.add(result);
      list.add(list2);
      //String result = "{'username':'lc'}";
      return result;
  }
    @RequestMapping("/saveGrade")
    public String saveGrade(Model model)
                    throws Exception{
            Logger logger = LoggerFactory.getLogger(MvcController.class);
            logger.debug("LCLC>>1234567");

            service.saveOne();
            model.addAttribute("uname","kk");
            return "err";
    }

    @RequestMapping("/showList")
    @ResponseBody
    public Map showList(@ModelAttribute User user){
        List list = new ArrayList();
        Map result = new HashMap();
        Map result2 = new HashMap();
        //Map result3 = new HashMap();
        System.out.println("LCLCLC>>>>>>>"+user.getUser_name()+":"+user.getUser_passWord()+":"+user.getCreate_time());
        List list2 = new ArrayList();
        list2 = service.findUserList(user);
       /* list2.add(result2);
        result2.put("phone","142425125");
        result2.put("sex","M");
        result2.put("name","lc");*/
        /*result2.put("sex","M");
        result2.put("phone","1234565");
        result2.put("email","123@qq.com");
        result2.put("remark","lclclc");
        result2.put("id","123");*/

        //result.put("isExist",service.checkUser(user));
        result.put("total",10);
        result.put("rows",list2);
        list.add(result);
        list.add(list2);
        //String result = "{'username':'lc'}";
        return result;
    }
    @RequestMapping("/delRow")
    @ResponseBody
    public Map delRow(@RequestParam("userId") String userId)
            throws Exception{
        System.out.println("LCLCLCLCLL>>DELETE:"+userId);
        Map map = new HashMap();
        map.put("result","succ");
        //service.delRow(Integer.parseInt(userId));
        return map;
    }
    @RequestMapping("/upload")
    public String upload(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request, ModelMap model){
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String mType = file.getContentType().replace("image/","");
        System.out.println("LCLC..UPLOAD--"+path+"\n"+mType);
        File targetFile = new File(path,"lcc."+mType);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }
    @RequestMapping("/saveRedis")
    @ResponseBody
    public String saveRedis(){
        Jedis jedis = redisService.getResource();
        try{
            com.domain.User user = new com.domain.User();
            user.setName("zy");
            user.setAddress("SB");
            //jedis.set("user".getBytes(), JedisUtil.ObjectToByte(user));
            byte[] users = jedis.get("user".getBytes());
            com.domain.User user1 = (com.domain.User)JedisUtil.ByteToObject(users);
            System.out.print(user1.toString());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
        return "hello";
    }
    @RequestMapping("/testv")
    @ResponseBody
    public Map<String,String> testV(@ModelAttribute @Valid com.domain.User user , BindingResult result){
        if(result.hasErrors()){
            return ParamUtil.formatError(result);
        }
        return new HashMap<String, String>();
    }
}

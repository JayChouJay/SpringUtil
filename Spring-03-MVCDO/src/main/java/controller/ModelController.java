package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @SessionAttributes注解：当Model三兄弟存了名字时，同时存入session
 */
@SessionAttributes("username")
@Controller
public class ModelController {

    @RequestMapping("/model.do")
    public String model(Model model, String username, String pass) {
        if (username.equals("") || pass.equals("")) {
            //相当于request.addAttribute();
            model.addAttribute("result", "成功了");
            return "login.html";
        } else {
            return "welcome.html";
        }
    }

    @RequestMapping("/modelAndView.do")
    public ModelAndView modelAndView(String username, String pass) {
        ModelAndView mv = new ModelAndView();
        if (username.equals("") || pass.equals("")) {

            mv.setViewName("login.html");

        } else {
            //相当于request.addAttribute();
            mv.addObject("result", "成功了");
            mv.setViewName("welcome.html");
        }
        return mv;
    }

    /**
     * 目的：替代request.setAttribute();
     * Model，ModelMap：最终的实现类都是BindingAwareModelMap，用法基本一致
     * ModelAndView：
     *
     * @return
     */
    @RequestMapping("/models.do")
    public String modelAndView(@RequestParam Map map, ModelAndView mv, Model model, ModelMap mm) {
        //有值
        System.out.println("map--->" + map);
        //有值
        System.out.println("model--->" + model);
        //有值
        System.out.println("mm--->" + mm);
        //有值
        System.out.println("mv--->" + mv);
        model.addAttribute("", "");
        mm.addAttribute("", "");
        return "welcome.html";
    }
}

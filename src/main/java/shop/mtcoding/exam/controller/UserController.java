package shop.mtcoding.exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.exam.model.User;
import shop.mtcoding.exam.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String home() {
        if (session.getAttribute("principal") != null) {
            // 로그인 한 상태
            return "redirect:/board/list";
        } else {
            // 로그인 안한 상태
            return "redirect:/loginForm";
        }
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/";
        } else {
            return "redirect:/joinForm";
        }
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        } else {
            session.setAttribute("principal", user);
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/updateForm")
    public String updateForm(Model model) {
        // 로그인 되어있는지 확인
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        int userId = principal.getId();
        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        return "user/updateForm";
    }

    @PostMapping("/user/update")
    public String update(String username, int password, String email) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        int userId = principal.getId();

        int result = userRepository.updateById(userId, username, password, email);
        if (result == 1) {
            return "redirect:/";
        } else {
            return "redirect:/updateForm";
        }
    }
}

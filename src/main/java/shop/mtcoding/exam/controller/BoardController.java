package shop.mtcoding.exam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.exam.model.Board;
import shop.mtcoding.exam.model.BoardRepository;
import shop.mtcoding.exam.model.User;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("board/list")
    public String boardList(Model model) {
        // 로그인 되어있는지 확인
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        int userId = principal.getId();
        List<Board> boardList = boardRepository.findByUserId(userId);
        model.addAttribute("boardList", boardList);

        return "board/list";
    }
}

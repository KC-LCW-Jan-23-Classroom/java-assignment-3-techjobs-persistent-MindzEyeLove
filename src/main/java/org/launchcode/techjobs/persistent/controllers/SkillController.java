package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        model.addAttribute("title", "Add Description");
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Description");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int employerId) {

        Optional optEmployer = skillRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Skill skill = (Skill) optEmployer.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }

    @Autowired
    private SkillRepository skillRepository;


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

}

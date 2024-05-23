package org.example.minitest1_md4.controller;

import jakarta.validation.Valid;
import org.example.minitest1_md4.dto.ComputerDTO;
import org.example.minitest1_md4.model.Computer;
import org.example.minitest1_md4.model.TypeComputer;
import org.example.minitest1_md4.service.computerService.IComputerService;
import org.example.minitest1_md4.service.typeComputerService.ITypeComputerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ComputerController {
    @Autowired
    private IComputerService computerService;
    @Autowired
    private ITypeComputerService typeComputerService;
    @GetMapping("")
    public String showAll(Model model, @RequestParam(required = false,defaultValue = "")String search,
                          @RequestParam(required = false,defaultValue = "0")int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Computer> computerPage=computerService.searchByName(search,pageable);
        model.addAttribute("search", search);
        model.addAttribute("computerPage",computerPage);
        return "home";
    }
    @GetMapping("/add")
    public String showFormCreate(Model model){
        ComputerDTO computerDTO = new ComputerDTO();
        List<TypeComputer> typeComputerList= typeComputerService.findAll();
        model.addAttribute("computerDTO",computerDTO);
        model.addAttribute("typeComputerList",typeComputerList);
        return "/add";
    }
    @PostMapping("/add")
    public String createComputer(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
     if(bindingResult.hasFieldErrors()){
      List<TypeComputer> typeComputerList= typeComputerService.findAll();
       model.addAttribute("typeComputerList",typeComputerList);
       return "/add";
     }else {
         Computer computer = new Computer();
         BeanUtils.copyProperties(computerDTO,computer);
         computerService.save(computer);
         redirectAttributes.addFlashAttribute("msg",1);
         return "redirect:/";
     }

    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable Long id){
        Computer computer = new Computer();
        ComputerDTO computerDTO = new ComputerDTO();
        computer= computerService.findById(id);
        BeanUtils.copyProperties(computer,computerDTO);
        List<TypeComputer>typeComputerList = typeComputerService.findAll();
        model.addAttribute("computerDTO",computerDTO);
        model.addAttribute("typeComputerList",typeComputerList);
        return "/edit";
    }
    @PostMapping("/edit")
    public String editComputer(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO,BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if(bindingResult.hasFieldErrors()){
            List<TypeComputer>typeComputerList=typeComputerService.findAll();
            model.addAttribute("typeComputerList",typeComputerList);
            return "/edit";
        }else{
            Computer computer = new Computer();
            BeanUtils.copyProperties(computerDTO,computer);
            computerService.save(computer);
            redirectAttributes.addFlashAttribute("msg",2);
            return "redirect:/";
        }
    }
    @GetMapping("/xoa")
    public String deleteComputer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        computerService.deleteById(id);
        redirectAttributes.addFlashAttribute("msg",3);
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String showview(@PathVariable Long id,Model model){
        Computer computer = new Computer();
        ComputerDTO computerDTO = new ComputerDTO();
        computer= computerService.findById(id);
        BeanUtils.copyProperties(computer,computerDTO);
//        List<TypeComputer>typeComputerList = typeComputerService.findAll();
        model.addAttribute("computerDTO",computerDTO);
//        model.addAttribute("typeComputerList",typeComputerList);
        return "/view";
    }

}

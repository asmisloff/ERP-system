package ru.geekbrains.erpsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.erpsystem.data.OperationData;
import ru.geekbrains.erpsystem.services.OperationService;

@Controller
@RequestMapping("/operations")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/all")
    public String showAllOperations(
            Model model
    ){
        model.addAttribute("operations", operationService.getAll());
        return "operations";
    }

    @GetMapping("/edit/{id}")
    public String editOperation(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("form_name","Edit Operation");

        OperationData operationData = operationService.getById(id)
                .orElseThrow(()->new RuntimeException("Operation with id - "+id+ " not found"));
        model.addAttribute("operationData", operationData);
        return "forms/operation_form";
    }

    @GetMapping("/add")
    public String addNewOperation(
            Model model
    ){
        model.addAttribute("form_name","New Operation");
        model.addAttribute("operationData", new OperationData());
        return "forms/operation_form";
    }

    @PostMapping("/add")
    public String addAndUpdateOperation(
            @ModelAttribute OperationData operationData
    ){
        if (operationData.getId() == null){
            operationService.insert(operationData);
        }else{
            if (operationService.getById(operationData.getId()).isEmpty()){
                throw new RuntimeException("Operation with id - "+ operationData.getId() + "not found");
            }
            operationService.update(operationData);
        }
        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String deleteOperationById(
            @PathVariable Long id,
            Model model
    ){
        operationService.getById(id)
                .orElseThrow(()->new RuntimeException("operation with id - "+id+" not found"));
        operationService.delete(id);
        return "redirect:/operations/all";
    }

}

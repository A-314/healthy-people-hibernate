package com.emelian.controllers;

import com.emelian.dao.PatientDao;
import com.emelian.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientsController {

    private final PatientDao patientDao;
    public PatientsController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("patientList", patientDao.index());
        return "patients/index";
    }
    @PostMapping()
    public String create(@ModelAttribute("patient") @Valid Patient patient){
        patientDao.save(patient);
        return "redirect:/patient/index";
    }
    @GetMapping("/new")
    public String newPatient(@ModelAttribute("patient") Patient patient){
        return "patients/new";
    }

    @GetMapping("/{id}/edit")
    public String getPatient(@PathVariable("id")int id,Model model){
        model.addAttribute("patient",patientDao.show(id));
        return "patients/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("patient") @Valid Patient person, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "patients/edit";
        patientDao.update(id, person);
        return "redirect:/patients";
    };

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable("id") int id){
        patientDao.delete(id);
        return "redirect:/patients/index";
    }

}
